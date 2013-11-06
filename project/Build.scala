import sbt._
import Keys._
import play.Project._

import de.johoop.jacoco4sbt.JacocoPlugin._


object ApplicationBuild extends Build {

  val appName         = "tdu"
  val appVersion      = "1.0-SNAPSHOT"

  val appDependencies = Seq(
    jdbc,
    anorm,
    "org.apache.xmlbeans" % "xmlbeans" % "2.4.0"
  )
  lazy val jacoco_settings = Defaults.defaultSettings ++ Seq(jacoco.settings: _*)

  val main = play.Project(appName, appVersion, appDependencies, settings = jacoco_settings).settings(
    parallelExecution in jacoco.Config := false
  )

}

