/**
  * Main
  */
object Main {

  private val reset = Console.RESET
  private val cyan = reset + Console.CYAN
  private val green = reset + Console.GREEN
  private val yell = reset + Console.YELLOW
  private val red = reset + Console.RED


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
       """.stripMargin + reset)
    checkIfIsValid(args)
    val list = ReadFromFile.getLOCFromFile(args(0))
    val result = list.evaluate(args(1).toDouble)
    println(s"Scale: \t\t\t${Console.UNDERLINED}${Console.CYAN}$result$reset")
  }

  def checkIfIsValid(args: Array[String]): Unit = {
    if (args.size != 2) {
      println(s"$red There was an error: 2 arguments expected $reset")
      println(s"$cyan Syntax:$reset <file_path> <evaluate> $reset")
      throw new IllegalArgumentException("Program was expecting a file name")
    }
  }


}
