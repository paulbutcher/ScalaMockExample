organization := "com.example"

version := "1.0"

scalaVersion := "2.10.0-RC1"

scalacOptions ++= Seq("-deprecation", "-unchecked")

libraryDependencies +=
  "org.scalamock" % "scalamock-scalatest-support_2.10.0-RC1" % "3.0-M5"
