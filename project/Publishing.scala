import bintray.Plugin._
import sbt.Keys._
import sbt._
import bintray.Keys._

object Publishing {
  lazy val settings: Seq[Setting[_]] = bintrayPublishSettings ++ Seq(
    publishMavenStyle := true,
    publishArtifact in Test := false,
    pomExtra :=
      <developers>
        <developer>
          <id>maciej</id>
          <name>Maciej Bilas</name>
          <url>http://twitter.com/maciejb</url>
        </developer>
      </developers>,
    licenses := ("Apache-2.0", new java.net.URL("http://www.apache.org/licenses/LICENSE-2.0.txt")) :: Nil,
    homepage := Some(new java.net.URL("http://maciejb.me")),
    bintrayOrganization in bintray := Some("maciej"),
    vcsUrl in bintray := Some("git@github.com:maciej/sbt-fork-process.git")
  )

}
