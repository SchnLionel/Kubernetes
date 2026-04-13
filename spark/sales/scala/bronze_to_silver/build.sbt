ThisBuild / version := "0.1.0-SNAPSHOT"
ThisBuild / scalaVersion := "2.12.18"

lazy val root = (project in file("."))
  .settings(
    name := "bronze_to_silver",
    libraryDependencies ++= Seq(
      "org.apache.spark" %% "spark-core" % "3.5.2" % "provided",
      "org.apache.spark" %% "spark-sql" % "3.5.2" % "provided",
      "org.postgresql" % "postgresql" % "42.6.0"
    ),
    assembly / assemblyMergeStrategy := {
      case PathList("META-INF", _*) => MergeStrategy.discard
      case _                        => MergeStrategy.first
    }
  )
