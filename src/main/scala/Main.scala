package se.radionoi.hello

object Main {

  def main(args: Array[String]): Unit = {
    akka.Main.main(Array(classOf[HelloWorld].getName))
  }

}
