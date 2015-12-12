lazy val root = (project in file(".")).
  settings(
    organization := "radionoise",
    name := "rnp-server-akka",
    version := "0.0.0",
    scalaVersion := "2.11.7",
    libraryDependencies += "com.typesafe.akka" %% "akka-actor" % "2.4.1"
  )
