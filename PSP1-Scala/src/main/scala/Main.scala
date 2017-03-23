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
           | _______  _______  _______  _____
           ||   _   ||   _   ||   _   || _   |  |$cyan  𐂀 Camilo A. Sampedro  $green
           ||.  1   ||   1___||.  1   ||.|   |  |$cyan  𐂁 C. Vanessa Pérez    $green
           ||.  ____||____   ||.  ____|`-|.  |  |$cyan  𐂀 V. Julián Gutiérrez $green
           ||:  |    |:  1   ||:  |      |:  |  |-------------------------
           ||::.|    |::.. . ||::.|      |::.|  |$yell  𐂷 University of Antioquia $green
           |`---'    `-------'`---'      `---'
      """.stripMargin + Console.RESET)
    checkIfIsValid(args)
    val x = ""
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
