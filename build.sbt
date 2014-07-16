name := "WatchAndThrow"

version := "0.1"

scalaVersion := "2.11.1"

// scalacOptions ++= Seq("-encoding", "UTF-8")

libraryDependencies ++= Seq(
  "org.slf4j" % "slf4j-simple" % "1.7.7",
  "net.databinder.dispatch" %% "dispatch-core" % "0.11.1"
)
