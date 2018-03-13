name := "analysis"

version := "0.1"

scalaVersion := "2.12.4"

libraryDependencies ++= Seq(
  "com.typesafe.slick" %% "slick" % "3.2.2",
  "org.slf4j" % "slf4j-nop" % "1.6.4",
  "com.typesafe.slick" %% "slick-hikaricp" % "3.2.2"
)

libraryDependencies += "com.typesafe.slick" %% "slick-codegen" % "3.2.2"
libraryDependencies +=  "mysql" % "mysql-connector-java" % "5.1.12"

// https://mvnrepository.com/artifact/org.kohsuke/github-api
libraryDependencies += "org.kohsuke" % "github-api" % "1.92"


//libraryDependencies ++= "com.typesafe.slick" %% "slick" % "3.2.2"