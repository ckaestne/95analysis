import java.io.File

import TimeAnalysis.wd

import scala.io.Source
import scala.sys.process.Process
import java.sql.Timestamp

import slick.jdbc.MySQLProfile.api._

import scala.concurrent.{Await, Future}
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration.Duration

object TimezoneCollector {


  def collectFromRepo(wd: File, repo: String) = {
    val db = Database.forConfig("ghtorrent")
    try {
      val repoDir = new File(wd, repo)
      println(repoDir)
      val gitlog = Process(Seq("git", "log", "--date=raw", "--since=2012-1-1", "--before=2018-1-1", "--pretty=format:\"%H;%ad;%an\""), repoDir).lineStream

      var tzShas = Map[Int, List[String]]()
      var knownNames = Set[String]()
      var counter = 0
      for (logLine <- gitlog) {
        val p = logLine.split(";")
        var sha = ""
        var tzi = 0
        var name = p(2)

        counter += 1
        if (counter > 1000) {
          counter = 0;
          knownNames = Set()
        }
        if (!(knownNames contains name)) {
          knownNames += name
          try {
            sha = p(0)
            var tz = p(1).takeRight(5)
            if (tz.startsWith("+")) tz = tz.drop(1)
            while (tz.startsWith("0") && tz.length > 1) tz = tz.drop(1)
            while (tz.startsWith(" ") && tz.length > 1) tz = tz.drop(1)
            tzi = tz.toInt
          } catch {
            case e: java.lang.NumberFormatException => println("invalid time zone " + p(1)); sha = "";
          }

          tzShas += (tzi -> (sha :: tzShas.getOrElse(tzi, List[String]())))
        }
      }

      val inserts = for ((tz, shas) <- tzShas; if shas.length > 0) yield {
        val cond = shas.map(s => "sha='" + s + "'").mkString(" or ")
        sqlu"insert ignore into `95timezone` select id, $tz from commits where #$cond"
      }


      //      inserts.map(_.statements.foreach(println))

      println(inserts.size + " commits")

      println("inserted " + Await.result(db.run(DBIO.sequence(inserts).map(_.sum)), Duration.Inf))

    } finally db.close()

  }

  def main(args: Array[String]): Unit = {
    val wd = new File(args(0))
    val repoListFile = new File(wd, args(1))
    assert(wd.exists(), "working directory does not exist")
    assert(repoListFile.exists(), "repo.lst does not exist")


    var repos = Source.fromFile(repoListFile).getLines()

    for (repo <- repos.toList.take(1)) try {
      collectFromRepo(wd, repo)


    } catch {
      case e: Exception => e.printStackTrace()
    }


  }
}
