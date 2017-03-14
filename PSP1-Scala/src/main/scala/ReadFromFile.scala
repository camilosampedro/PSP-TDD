import model.PSP1List

/**
  * ReadFromFile
  */
object ReadFromFile {
  def getListFromFile(fileName: String): PSP1List = {
    println(s"Reading from file:  \t${Console.MAGENTA}$fileName${Console.RESET}")
    scala.io.Source.fromFile(fileName).getLines().map(_.toDouble).toList
  }

  def isAllDigits(x: String): Boolean = x.forall(c => Character.isDigit(c) || c == '.' || c == '-')
}
