package radionoise.server

import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport
import spray.json._

final case class Error(message: String)

trait JsonMessages extends SprayJsonSupport with DefaultJsonProtocol {
  implicit val errorFormat = jsonFormat1(Error.apply)
}