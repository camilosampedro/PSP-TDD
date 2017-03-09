/**
  * Main
  */
object Main extends Output {
  val parser = new scopt.OptionParser[Config]("PSP1") {
    head("PSP1", "0.1.0")
    arg[String]("<file>")
  }

  def main(args: Array[String]): Unit = {
    parser.parse(args, Config("")) match {
      case Some(config) =>
        val list = ReadFromFile.getListFromFile(config.file)
        println(s"Mean: ${list.mean}")
        println(s"Standard deviation: ${list.sqrtSum}")
      case _ => throw new IllegalArgumentException("Program was expecting a file name")
    }
  }


}
