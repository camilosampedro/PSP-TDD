/**
  * ReadFromFile
  */
object ReadFromFile {
  def getListFromFile(fileName: String): PSP1List = {
    scala.io.Source.fromFile(fileName).getLines().map(_.toDouble).toList
  }
}
