import mill._, scalalib._

object app extends ScalaModule {
  def scalaVersion = "3.0.0"
}

object inspector extends ScalaModule {
  def scalaVersion = "3.0.0"
  def ivyDeps = Agg(
    ivy"org.scala-lang::scala3-tasty-inspector:${scalaVersion()}"
  )
}
