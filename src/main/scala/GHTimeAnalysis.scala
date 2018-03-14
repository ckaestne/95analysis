import java.sql.Timestamp
import java.time.format.DateTimeFormatter
import java.time._
import java.time.temporal.{ChronoField, TemporalField}

import db.Tables
import slick.jdbc.MySQLProfile.api._
import db.Tables._
import slick.dbio.{DBIOAction, NoStream}

import scala.collection.mutable
import scala.concurrent.Await
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration.Duration
import scala.io.Source


object GHTimeAnalysis extends App {


  val months = for (y <- 2014 to 2017; m <- 1 to 12)
    yield ZonedDateTime.of(y, m, 1, 0, 0, 0, 0, ZoneOffset.UTC)
  val monthsi = months.zipWithIndex

  println("start")
  val db = Database.forConfig("ghtorrent")


  def getTimezone(userId: Int): Option[Int] = {
    val commitTzs = for (tz <- Tables.`95timezone`; c <- Tables.Commits;
                         if tz.commitId === c.id; if c.authorId===userId) yield tz.timezone

    eval(commitTzs.take(3).avg.result)
  }

  def analyzeProject(repo: Tables.ProjectsRow): Unit = {
    println("## analyzing "+repo.name)
    val repoId = repo.id
    eval(sqlu"delete from `95month` where repo_id=$repoId")
    //actions: userid, timestamp, isSupport
    val actionCommits = for (c <- Tables.Commits; if c.projectId === repoId) yield (c.authorId.getOrElse(-1), c.createdAt, false)
    val commits = for (c <- Tables.Commits; if c.projectId === repoId) yield c
    val issues = for (i <- Tables.Issues; if i.repoId === repoId) yield i
    val actionIssueCreation = for (i <- issues) yield (i.reporterId.getOrElse(-1), i.createdAt, true)
    val actionIssueAction = for (ia <- Tables.IssueEvents;
                                 i <- issues; if i.id === ia.issueId; if ia.action inSet Set("closed", "assigned", "labeled", "merged", "reopened", "renamed")) yield (ia.actorId, ia.createdAt, true)
    val actionCommitComment = for (cc <- Tables.CommitComments; c <- commits; if c.id === cc.commitId) yield (cc.userId, cc.createdAt, true)


    val allActions = actionCommits ++ actionIssueCreation ++ actionIssueAction ++ actionCommitComment
    val allActionsSince2014 = allActions.filter(
      a => a._2 > Timestamp.valueOf("2014-1-1 00:00:00") && a._2 < Timestamp.valueOf("2018-1-1 00:00:00")
    ).filter(_._1 > 0)

    val mostActiveDevelopers = allActionsSince2014.groupBy(_._1).map(g => (g._1, g._2.length)).sortBy(_._2.desc).take(6)


    def analyzeDeveloper(repo: Tables.ProjectsRow, userId: Int): Unit = {
//      println(s"analyzing dev $userId")

      val timeZone = getTimezone(userId)
      if (timeZone.isEmpty) {
        println(s"  no timezone data for developer $userId found")
        return
      } else {
        println(s"  time zone for developer $userId " + timeZone.get)
      }

      val developerActions = eval(allActionsSince2014.filter(_._1 === userId).sortBy(_._2).result)


      months.zipWithIndex
      var currentMonthIdx = 0

      val actionPerMonth: Map[Int, mutable.Buffer[(Int, Timestamp, Boolean)]] = monthsi.map(m => (m._2, mutable.Buffer[(Int, Timestamp, Boolean)]())).toMap
      for (action <- developerActions) {
        actionPerMonth(getMonthIdx(action._2)).append(action)
      }

      val inserts = for (month <- monthsi) yield {
        val actions = actionPerMonth(month._2)
        Tables.`95month` += `95monthRow`(userId, repo.id, month._2,
          month._1.getYear, month._1.getMonthValue,
          actions.length, actions.filter(a => Util95.is95(a._2, timeZone.get)).length, actions.filter(_._3).length
        )
      }
      eval(DBIO.sequence(inserts))

    }

    val r = db.run(mostActiveDevelopers.result).map(_.foreach(d => analyzeDeveloper(repo, d._1)))
    Await.result(r, Duration.Inf)
  }

  def getMonthIdx(date: Timestamp): Int =
    monthsi.reverse.find(Util95.toUTC(date) isAfter _._1).map(_._2).get


  def getRepo(id: Int): Tables.ProjectsRow = {
    val q = db.run(Tables.Projects.filter(_.id === id).take(1).result)
    Await.result(q, Duration.Inf).head
  }

  def eval[T](q: DBIOAction[T, NoStream, Nothing]): T =
    Await.result(db.run(q), Duration.Inf)

  try {

    val repoURLs = (for (line<-Source.fromFile("../data/projects").getLines()) yield "https://api.github.com/repos/"+line).toSet
    val repos = eval(Tables.Projects.filter(_.url inSet repoURLs).result)

    for (repo<-repos)
      analyzeProject(repo)
    // ...
  } finally db.close


}


object Util95 {

  def is95(t: Timestamp, tz: Int): Boolean = {
    val i = toUTC(t)
    //detect time zone
    val zoneId = ZoneOffset.ofHoursMinutes(Math.floor(tz / 100).toInt, /*tz % 100*/0)
    //compute local time with timezone, so that getHour etc reflects the person's local time
    val localTime = i.withZoneSameInstant(zoneId)
//    println(localTime.format(DateTimeFormatter.RFC_1123_DATE_TIME))
    //weekend is not 9-5
    (localTime.getDayOfWeek != DayOfWeek.SATURDAY) && (localTime.getDayOfWeek != DayOfWeek.SUNDAY) &&
      (localTime.getHour >= 7) && (localTime.getHour < 19)
  }

  // timestamp doesn't have a time zone, but when reading from DB it assumes local time. hence translate to UTC first
  def toUTC(t: Timestamp): ZonedDateTime =
    ZonedDateTime.ofInstant(t.toInstant, ZoneId.systemDefault()).withZoneSameLocal(ZoneOffset.UTC)

  def main(args: Array[String]): Unit = {
    //tests
    val t10 = Timestamp.valueOf("2014-1-1 10:00:00") //wed 10am UTC

    assert(is95(t10, 100))
    assert(is95(t10, -130))
    assert(!is95(t10, -400))
    assert(is95(Timestamp.valueOf("2014-1-2 23:00:00"), 1130))
    assert(!is95(Timestamp.valueOf("2014-1-3 23:00:00"), 1130))
  }
}

