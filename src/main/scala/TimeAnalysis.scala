import java.io.File

object TimeAnalysis extends App {

  import sys.process._

  val wd = new File("../express")


  val gitlog = Process(Seq("git", "log", "--date=format:%H;%z;%w", "--pretty=format:\"%H;%an;%ad\""), wd).lineStream

  val r = "(\\w+);(.*);(\\d+);([+-]\\d+);(\\d)".r
  var data = Map[String, Map[(Int, Int), Int]]()
  var authorCommits = Map[String, Int]()
  var authorTimeZones = Map[String, Map[Int, Int]]()
  for (line <- gitlog) {
    var r(hash, author, localHour, timezone, dayOfWeek) = line
    author=author.toLowerCase

    val idx = (dayOfWeek.toInt, localHour.toInt)
    val c = data.getOrElse(author, Map[(Int, Int), Int]())
    val updatedC = c + (idx -> (c.getOrElse(idx, 0) + 1))
    data += (author -> updatedC)

    authorCommits += (author -> (authorCommits.getOrElse(author, 0) + 1))

    val tz = authorTimeZones.getOrElse(author, Map[Int, Int]())
    authorTimeZones += (author ->
      (tz + (timezone.toInt -> (tz.getOrElse(timezone.toInt, 0) + 1)))
      )
  }

  for ((author, c) <- data; if authorCommits(author)>100) {
    println(author + ":")
//    for ((i, v) <- c)
//      println(i._1+";"+i._2 + ";" + v)
//    println(authorTimeZones(author))
//
//    println("")
  }

}