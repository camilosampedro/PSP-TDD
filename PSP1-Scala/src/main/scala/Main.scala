/**
  * Main
  */
object Main {

  def main(args: Array[String]): Unit = {
    println("======================")
    println(s"==${Console.BLINK}${Console.GREEN} [ PSP1 - Scala ] ${Console.RESET}==")
    println("======================")
    checkIfIsValid(args)
    val list = ReadFromFile.getListFromFile(args(0))
    println(s"Mean: \t\t\t${Console.UNDERLINED}${Console.CYAN}${list.mean}${Console.RESET}")
    println(s"Standard deviation: \t${Console.UNDERLINED}${Console.CYAN}${list.sqrtSum}${Console.RESET}")
  }

  def checkIfIsValid(args: Array[String]): Unit = {
    if(args.isEmpty){
      throw new IllegalArgumentException("Program was expecting a file name")
    }
  }


}
