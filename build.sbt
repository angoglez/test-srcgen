import sbtorgpolicies.OrgPoliciesPlugin.autoImport._
import sbtorgpolicies.model._
import sbtorgpolicies.runnable.syntax._
import sbtorgpolicies.templates._
import sbtorgpolicies.templates.badges._

name := "test-srcgen"

version := "0.1"

scalaVersion := "2.13.2"

lazy val V = new {

  val circe: String           = "0.13.0"
  val enumeratum: String      = "1.6.1"
  val enumeratumCirce: String = "1.6.1"
  val doobie: String          = "0.9.0"
  val refined: String         = "0.9.14"

}

libraryDependencies ++= Seq(
  "org.typelevel"     %% "cats-effect"      % "2.1.3",
  "org.typelevel"     %% "cats-core"        % "2.1.1",
  "io.higherkindness" %% "skeuomorph"       % "0.0.22",
  "com.beachape"      %% "enumeratum"       % V.enumeratum,
  "com.beachape"      %% "enumeratum-circe" % V.enumeratumCirce,
  "org.tpolecat"      %% "doobie-refined"   % V.doobie,
  "eu.timepit"        %% "refined"          % V.refined,
  %%("circe-core", V.circe),
  %%("circe-generic", V.circe),
)

lazy val root = project
  .in(file("."))
  .settings(
    buildInfoKeys := Seq[BuildInfoKey](name, version, scalaVersion, sbtVersion),
    buildInfoPackage := "buildinfo",
    name := "compendium-server",
    scalacOptions -= "-Xfuture"
  )
