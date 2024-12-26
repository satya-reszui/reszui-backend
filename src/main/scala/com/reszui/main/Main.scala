package com.reszui.main

import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.http.scaladsl.server.Directives._
import akka.stream.ActorMaterializer
import scala.concurrent.{ExecutionContext}

object Main {
  def main(args: Array[String]) = {
    implicit val system: ActorSystem = ActorSystem("ReszUI")
    implicit val materializer: ActorMaterializer = ActorMaterializer()
    implicit val ec: ExecutionContext = system.dispatcher

    println("Hello World ...!")
    val appRoute = path("ping") {
      get {
        complete("Pong! from App_Server")
      }
    }

    var binding = Http().newServerAt("localhost", 8080).bind(appRoute)
  }
}