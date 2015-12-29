lazy val root = (project in file(".")).
  settings(
    organization := "radionoise",
    name := "rnp-server-akka",
    version := "0.0.0",
    scalaVersion := "2.11.7",
    libraryDependencies ++= {
      val akkaV = "2.4.1"
      val akkaStreamV = "2.0.1"
      Seq(
        "com.typesafe.akka" %% "akka-actor" % akkaV,
	"com.typesafe.akka" %% "akka-stream-experimental" % akkaStreamV,
        "com.typesafe.akka" %% "akka-http-core-experimental" % akkaStreamV,
        "com.typesafe.akka" %% "akka-http-experimental" % akkaStreamV,
        "com.typesafe.akka" %% "akka-http-spray-json-experimental" % akkaStreamV
      )
    }
  )
