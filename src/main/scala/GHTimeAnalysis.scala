import java.sql.Timestamp

import db.Tables
import slick.jdbc.MySQLProfile.api._
import db.Tables._
import slick.dbio.{DBIOAction, NoStream}

import scala.concurrent.Await
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration.Duration


object GHTimeAnalysis extends App {



  println("start")
  val db = Database.forConfig("ghtorrent")


  def getTimezone(repo: Tables.ProjectsRow, userId: Int) : Int = {
    val q=db.run(Tables.`95timezone`.filter(_.userId===userId).map(_.timezone).result)
    val tz = Await.result(q, Duration.Inf)
    if (tz.headOption.isDefined) return tz.head

    //get two random commits
    val randomCommitsQ = Tables.Commits.filter(_.authorId===userId).sortBy(_.sha).take(2)
// /repos/:owner/:repo/git/commits/:sha
//    val randomCommits = eval(randomCommitsQ.result)
//    for (c <- randomCommits) {
//      val url = repo.url+"/git/commits/"+c.sha
//      val r = Http().singleRequest(HttpRequest(
//        method = HttpMethods.GET,
//        uri = url
//      ))
//      val commitData = Await.result(r, Duration.Inf)
//      commitData.
//    }

    ???
  }

  def analyzeProject(repo: Tables.ProjectsRow): Unit = {
    val repoId = repo.id
    //actions: userid, timestamp, isSupport
    val actionCommits = for (c <- Tables.Commits; if c.projectId===repoId) yield (c.authorId.getOrElse(-1), c.createdAt, false)
    val commits = for (c <- Tables.Commits; if c.projectId===repoId) yield c
    val issues = for (i<-Tables.Issues; if i.repoId===repoId) yield i
    val actionIssueCreation = for (i<-issues) yield (i.reporterId.getOrElse(-1), i.createdAt, true)
    val actionIssueAction =for (ia <- Tables.IssueEvents;
      i<-issues; if i.id===ia.issueId; if ia.action inSet Set("closed", "assigned", "labeled", "merged", "reopened", "renamed")) yield (ia.actorId, ia.createdAt, true)
    val actionCommitComment =for (cc <- Tables.CommitComments; c<-commits; if c.id===cc.commitId) yield (cc.userId, cc.createdAt, true)


    val allActions = actionCommits ++ actionIssueCreation ++ actionIssueAction ++ actionCommitComment
    val allActionsSince2014 = allActions.filter(
      a=>a._2 > Timestamp.valueOf("2014-1-1 00:00:00") && a._2 < Timestamp.valueOf("2018-1-1 00:00:00")
    ).filter(_._1>0)

    val mostActiveDevelopers = allActionsSince2014.groupBy(_._1).map(g => (g._1, g._2.length)).sortBy(_._2.desc).take(6)


    def analyzeDeveloper(repo: Tables.ProjectsRow, userId: Int): Unit = {
      println(s"analyzing dev $userId")

//      val timeZone = getTimezone(repo.id, userId)

      val developerActions = allActionsSince2014.filter(_._1===userId)


    }

    val r=db.run(mostActiveDevelopers.result).map(_.foreach(d=>analyzeDeveloper(repo, d._1)))
    println(r)
    Await.result(r, Duration.Inf)
    println(r)
    println(mostActiveDevelopers.result.statements.head)
  }




  def getRepo(id: Int): Tables.ProjectsRow = {
    val q = db.run(Tables.Projects.filter(_.id===id).take(1).result)
    Await.result(q, Duration.Inf).head
  }

  def eval[T](q: DBIOAction[T, NoStream, Nothing]):T =
    Await.result(db.run(q), Duration.Inf)

  try {


    analyzeProject(getRepo(5230))
    // ...
  } finally db.close



}




