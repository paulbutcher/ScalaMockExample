import sbt._
import Keys._
import ScalaMockPlugin._
 
object ScalaMockExample extends Build {
 
  override lazy val settings = super.settings ++ Seq(
    organization := "com.example",
    version := "1.0",
    scalaVersion := "2.9.1",
 
	resolvers += "Sonatype OSS Snapshots" at "http://oss.sonatype.org/content/repositories/snapshots/",
    libraryDependencies += "org.scalamock" %% "scalamock-scalatest-support" % "2.3-SNAPSHOT",
    autoCompilerPlugins := true,
    addCompilerPlugin("org.scalamock" %% "scalamock-compiler-plugin" % "2.3-SNAPSHOT"))
 
  lazy val myproject = Project("ScalaMockExample", file(".")) settings(generateMocksSettings: _*) configs(Mock)
}