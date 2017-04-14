import p2p.math.TGammaDistribution

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
         | , _     , _
         |/|/ \\ ()/|/ \\|  |
         | |__/ /\\ |__/|__|_
         | |   /(_)|      |
       """.stripMargin + reset)
    checkIfIsValid(args)
    val dof = args(0).toInt
    val rightBound = args(1).toDouble
    val error = args(2).toDouble
    val result = new TGammaDistribution(dof).integrate(rightBound, error= error)
    println("Input:")
    println(s"\tdof=$yell$dof$reset")
    println(s"\tright bound=$yell$rightBound$reset")
    println(s"\terror=$yell$error$reset")
    println(s"Integration result: \t\t\t${Console.UNDERLINED}${Console.CYAN}$result$reset")
  }

  def checkIfIsValid(args: Array[String]): Unit = {
    if (args.length != 3) {
      println(s"$red There was an error: 3 arguments expected $reset")
      println(s"$cyan Syntax:$reset <dof> <right_bound> <error> $reset")
      println(s"$cyan Example:$reset 9 1.1 0.00001 $reset")
      throw new IllegalArgumentException("Program was expecting dof, evaluate and error")
    }
  }


}
