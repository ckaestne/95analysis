import slick.jdbc.MySQLProfile.api._

import scala.concurrent.ExecutionContext.Implicits.global



object Gen extends App {
  slick.codegen.SourceCodeGenerator.main(
    Array("slick.jdbc.MySQLProfile", "com.mysql.jdbc.Driver", "jdbc:mysql://localhost:3306/ghtorrent", "src/main/scala", "db", "christian", "j0gg!e")
  )
  println("generation done")
}
