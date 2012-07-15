import sbt._
import Keys._
import ScalaMockPlugin._
 
object ScalaMockExample extends Build {
 
  override lazy val settings = super.settings ++ Seq(
    organization := "com.example",
    version := "1.0",
    scalaVersion := "2.9.2",
 
    libraryDependencies += "org.scalamock" %% "scalamock-scalatest-support" % "2.4",
    autoCompilerPlugins := true,
    addCompilerPlugin("org.scalamock" %% "scalamock-compiler-plugin" % "2.4"))
 
    lazy val myproject = Project("ScalaMockExample", file(".")) settings(generateMocksSettings: _*) configs(Mock)
}