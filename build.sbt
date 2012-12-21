organization := "com.example"

version := "1.0"

scalaVersion := "2.10.0-RC1"

scalacOptions ++= Seq("-deprecation", "-unchecked", "-feature")

resolvers += Resolver.sonatypeRepo("releases")

libraryDependencies +=
  "org.scalamock" %% "scalamock-scalatest-support" % "3.0" % "test"
