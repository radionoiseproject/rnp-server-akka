package radionoise.server

import akka.actor._
import collection.mutable.{ HashMap, MultiMap, Set }
import java.util.UUID

object Lobby {
  // Messages
  sealed trait Message
  case class RegisterUser(user: ActorRef) extends Message
  
  def props: Props = Props(new Lobby)
}

class Lobby extends Actor with ActorLogging {
  import Lobby._
  
  // TODO: This should be a distributed data store
  var users = new HashMap[UUID, Set[ActorRef]] with MultiMap[UUID, ActorRef]
  
  override def receive = {
    case RegisterUser(user) => log.info(s"Received RegisterUser message for $user")
  }
}