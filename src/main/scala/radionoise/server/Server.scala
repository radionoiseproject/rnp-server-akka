package radionoise.server

import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.stream.ActorMaterializer
import akka.stream.scaladsl.Flow
import akka.http.scaladsl.model.ws.{Message, TextMessage}
import scala.io.StdIn
import akka.http.scaladsl.server._
import service.UserService

object Server extends App {
  implicit val actorSystem = ActorSystem("akka-system")
  implicit val flowMaterializer = ActorMaterializer()
  
  val lobby = actorSystem.actorOf(Lobby.props, "Lobby")
  
  val interface = "localhost"
  val port = 8080
  
  implicit def myRejectionHandler = MisakaRejectionHandler.newHandler()
  
  import Directives._
  
  val route = UserService.route
  
  val binding = Http().bindAndHandle(route, interface, port)
  
  println(s"Server is now online at http://$interface:$port\nPress RETURN to stop...")
  StdIn.readLine()

  import actorSystem.dispatcher

  binding.flatMap(_.unbind()).onComplete(_ => actorSystem.shutdown())
  println("Server is down...")
  
}