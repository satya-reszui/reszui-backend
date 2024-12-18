ThisBuild / version := "0.1.0-SNAPSHOT"
ThisBuild / scalaVersion := "2.12.2"

lazy val root = (project in file("."))
  .settings(
    name := "reszui"
  )

libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-http" % "10.5.3",
  "com.typesafe.akka" %% "akka-stream" % "2.7.0",
  "com.typesafe.akka" %% "akka-actor" % "2.7.0"
)

// Add sbt-assembly plugin
enablePlugins(AssemblyPlugin)

// Define main class for JAR
Compile / packageBin / mainClass := Some("com.example.Main")

// Define the dist task (optional)
val dist = taskKey[Unit]("Building the Jar starts .....")
dist := {
  println("Building the JAR...")
  (compile in Compile).value
  (assembly).value
}

// Configure output JAR name and path
assembly / outputPath := baseDirectory.value / "target" / "reszui-assembly.jar"

