name := "slick-noschema"

version := "1.0"

logLevel := Level.Warn
scalaVersion := "2.12.3"
val slickVersion = "3.2.3"

libraryDependencies ++= Seq(
  "com.typesafe.slick" %% "slick" % slickVersion,
)
