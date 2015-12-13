package radionoise.server

import akka.http.scaladsl.model._
import akka.http.scaladsl.server._
import akka.http.scaladsl.model.StatusCodes._
import akka.http.scaladsl.marshalling.ToResponseMarshallable.apply

object MisakaRejectionHandler {
  def newHandler(): akka.http.scaladsl.server.RejectionHandler = {
    import Directives._
    
    akka.http.scaladsl.server.RejectionHandler.newBuilder()
      .handle { case ExpectedWebsocketRequestRejection =>
          complete("“‘I don’t understand… Do you speak WebSockets?’ MISAKA asks, speaking very slowly.”")
        }
      .handleNotFound {
        complete((NotFound, "“‘You seem to be a bit lost,’ MISAKA says as she looks on with a concerned expression.”"))
      }
      .result()
  }
}