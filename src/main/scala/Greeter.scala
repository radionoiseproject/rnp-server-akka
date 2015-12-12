package se.radionoi.hello

import akka.actor.Actor

object Greeter {
  case object Greet
  case object Done
}

class Greeter extends Actor with akka.actor.ActorLogging {
  def receive = {
    case Greeter.Greet =>
      log.debug("Hello World!")
      sender() ! Greeter.Done
  }
}
