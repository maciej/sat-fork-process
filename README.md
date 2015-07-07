# SBT fork process

This plugin enables you to start a forked process from a Java/Scala class (that have a `main(...)` method).
It's backed by SBT's `fork` functionality.

## Usage
Add the following to plugins.sbt:

```scala
resolvers += Resolver.url("maciej-sbt-plugins",
  url("https://dl.bintray.com/maciej/sbt-plugin-releases/"))(Resolver.ivyStylePatterns)

addSbtPlugin("me.maciejb" % "sbt-fork-process" % "0.1.0")
```

### TODO
* Add testing, see [[1]](http://stackoverflow.com/questions/19102208/how-to-test-sbt-plugins), [[2]](http://eed3si9n.com/testing-sbt-plugins)
