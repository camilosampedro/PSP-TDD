import model.PSP1List

/**
  * ReadFromFile
  */
object ReadFromFile {
  def getListFromFile(fileName: String): PSP1List = {
    println(s"Reading from file:  \t${Console.MAGENTA}$fileName${Console.RESET}")
    scala.io.Source.fromFile(fileName).getLines().map(_.toDouble).toVector
  }

  def getListPairFromFile(fileName: String): (PSP1List, PSP1List) = {
    println(s"Reading from file:  \t${Console.MAGENTA}$fileName${Console.RESET}")
    val doubleLists = scala.io.Source.fromFile(fileName).getLines().map { line =>
      val splitted = line.split(",").map(_.toDouble)
      (splitted.head, splitted.last)
    }
    (doubleLists.map(_._1).toVector, doubleLists.map(_._2).toVector)
  }

  def isAllDigits(x: String): Boolean = x.forall(c => Character.isDigit(c) || c == '.' || c == '-')
}
