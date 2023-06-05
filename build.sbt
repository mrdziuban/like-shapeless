Global / onChangedBuildSource := ReloadOnSourceChanges

lazy val likeShapeless = project.in(file("."))
  .settings(
    scalaVersion := "3.3.0",
    organization := "like-shapeless",
    version := "0.0.1",
  )
