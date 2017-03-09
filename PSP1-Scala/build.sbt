name := """PSP-1"""

version := "0.1.0"

scalaVersion := "2.12.1"

// ScalaTest
libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.1" % Test

// Specs2
libraryDependencies += "org.specs2" %% "specs2" % "2.4.17" % Test

// ScalaCheck
libraryDependencies += "org.scalacheck" %% "scalacheck" % "1.13.4" % Test

// JUnit (and add-ons)
libraryDependencies ++= Seq(
  "junit" % "junit" % "4.12" % Test,
  "com.novocode" % "junit-interface" % "0.11" % Test,
  "org.hamcrest" % "hamcrest-core" % "1.3" % Test,
  "org.mockito" % "mockito-core" % "2.7.14" % Test
)

// TestNG
libraryDependencies += "org.testng" % "testng" % "6.8.8" % "test"

libraryDependencies += "com.github.scopt" %% "scopt" % "3.5.0"
