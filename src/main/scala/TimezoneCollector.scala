import java.io.File

import TimeAnalysis.wd

import scala.io.Source
import scala.sys.process.Process
import java.sql.Timestamp

import db.Tables
import slick.jdbc.MySQLProfile.api._
import db.Tables._
import slick.dbio.{DBIOAction, NoStream}

import scala.concurrent.{Await, Future}
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration.Duration

object TimezoneCollector extends App {

  val wd = new File(args(0))
  val repoListFile = new File(wd, args(1))
  assert(wd.exists(), "working directory does not exist")
  assert(repoListFile.exists(), "repo.lst does not exist")

  val db = Database.forConfig("ghtorrent")
  try {

    var repos = Source.fromFile(repoListFile).getLines()

    for (repo <- repos.take(1)) {
      val repoDir = new File(wd, repo)
      println(repoDir)
      val gitlog = Process(Seq("git", "log", "--date=format:%z", "--pretty=format:\"%H;%ad\""), repoDir).lineStream

      val inserts = for (logLine <- gitlog) yield {
        val p = logLine.split(";")
        val sha = p(0)
        val tz = p(1).toInt

        sqlu"insert into `95timezone` select id, $tz from commits where sha=$sha"
      }
      println(inserts.size + " commits")

      Await.result(db.run(DBIO.sequence(inserts)), Duration.Inf)


    }
  } finally db.close()


}
