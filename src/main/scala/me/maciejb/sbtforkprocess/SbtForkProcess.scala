package me.maciejb.sbtforkprocess

import sbt.Def.Initialize
import sbt.Keys._
import sbt._

object SbtForkProcess {

  private[this] def classpathOption(classpath: Seq[File]) = "-classpath" :: Path.makeString(classpath) :: Nil
  private[this] def scalaOptions(mainClass: String): Initialize[Task[List[String]]] =
    (fullClasspath in Runtime) map { (cp) =>
      classpathOption(Attributed.data(cp)) ::: mainClass :: Nil
    }

  private[this] def forkOptions(config: Configuration): Initialize[Task[ForkOptions]] =
    (baseDirectory in config, javaOptions in config, outputStrategy in config, envVars in config,
      javaHome in config, connectInput in config) map {
      (base, options, strategy, env, javaHomeDir, connectIn) =>
        // bootJars is empty by default because only jars on the user's classpath should be on the boot classpath
        ForkOptions(bootJars = Nil, javaHome = javaHomeDir, connectInput = connectIn, outputStrategy = strategy,
          runJVMOptions = options, workingDirectory = Some(base), envVars = env)
    }

  def forkRunClass(mainClass: String, config: Configuration = Global): Initialize[Task[Process]] = Def.task {
    Fork.java.fork(forkOptions(config).value, scalaOptions(mainClass).value)
  }

}
