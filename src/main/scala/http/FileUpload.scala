package http

import dispatch._, Defaults._

object FileUpload {

  println("hogehoge")
  val h = new Http
  val contents = h(url("http://www.scala-lang.org/") OK as.String)


  for (c <- contents)
    println(c)

  println("hugahuga")
}