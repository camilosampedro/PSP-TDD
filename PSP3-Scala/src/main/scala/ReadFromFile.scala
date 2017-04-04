import model.{PSP1List, PSP3LinesOfCode}

/**
  * ReadFromFile
  */
object ReadFromFile {
  private[ReadFromFile] def readLines(fileName: String) = {
    println(s"Reading from file:  \t${Console.MAGENTA}$fileName${Console.RESET}")
    scala.io.Source.fromFile(fileName).getLines()
  }

  def getListFromFile(fileName: String): PSP1List = {
    readLines(fileName).map(_.toDouble).toVector
  }

  def getListPairFromFile(fileName: String): (PSP1List, PSP1List) = {
    val doubleLists = readLines(fileName).map { line =>
      val splitted = line.split(",").map(_.toDouble)
      (splitted.head, splitted.last)
    }
    (doubleLists.map(_._1).toVector, doubleLists.map(_._2).toVector)
  }

  def getLOCFromFile(fileName: String): PSP3LinesOfCode = {
    readLines(fileName).map { line =>
      val splitted = line.split(",").map(_.toInt)
      (splitted.head, splitted.last)
    }.toVector
  }

  def isAllDigits(x: String): Boolean = x.forall(c => Character.isDigit(c) || c == '.' || c == '-')
}
