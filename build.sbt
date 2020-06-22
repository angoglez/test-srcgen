name := "test-srcgen"

version := "0.1"

scalaVersion := "2.13.2"

scalacOptions += "-Ymacro-annotations"

libraryDependencies += "org.typelevel" %% "cats-effect" % "2.1.3"
libraryDependencies += "io.higherkindness" %% "skeuomorph" % "0.0.23"
