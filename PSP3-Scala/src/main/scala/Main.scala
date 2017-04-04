/**
  * Main
  */
object Main {

  private val cyan = Console.RESET + Console.CYAN
  private val green = Console.RESET + Console.GREEN
  private val yell = Console.RESET + Console.YELLOW


  def main(args: Array[String]): Unit = {
    println(
      Console.BLINK + green +
      s"""
         |8888888b.  .d8888b. 8888888b.  .d8888b.
         |888   Y88bd88P  Y88b888   Y88bd88P  Y88b
         |888    888Y88b.     888    888     .d88P
         |888   d88P "Y888b.  888   d88P    8888"
         |8888888P"     "Y88b.8888888P"      "Y8b.
         |888             "888888       888    888
         |888       Y88b  d88P888       Y88b  d88P
         |888        "Y8888P" 888        "Y8888P"
       """.stripMargin + Console.RESET)
    checkIfIsValid(args)
    val list = ReadFromFile.getListFromFile(args(0))
    println(s"Mean: \t\t\t${Console.UNDERLINED}${Console.CYAN}${list.mean}${Console.RESET}")
    println(s"Standard deviation: \t${Console.UNDERLINED}${Console.CYAN}${list.sqrtSum}${Console.RESET}")
  }

  def checkIfIsValid(args: Array[String]): Unit = {
    if (args.isEmpty) {
      throw new IllegalArgumentException("Program was expecting a file name")
    }
  }


}
