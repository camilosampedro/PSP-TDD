/**
  * Main
  */
object Main {

  def main(args: Array[String]): Unit = {
    if(args.isEmpty){
      throw new IllegalArgumentException("Program was expecting a file name")
    }
    val list = ReadFromFile.getListFromFile(args(0))
    println(s"Mean: ${list.mean}")
    println(s"Standard deviation: ${list.sqrtSum}")
  }


}
