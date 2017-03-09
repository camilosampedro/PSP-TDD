import java.io.FileNotFoundException

import org.scalatest.WordSpec

/**
  * ReadFromFileTest
  */
class ReadFromFileTest extends WordSpec {
  val emptyFileName: String = getClass.getResource("testEmpty.txt").getFile

  "A read file" when {
    "it is not found" should {
      "throw a FileNotFoundException" in {
        intercept[FileNotFoundException](ReadFromFile.getListFromFile("aowjdoaiwjdoaiwjdoaiwjdoaiwjdoaiwjdo"))
      }
    }
    "it is empty" should {
      "return an empty list" in {
        assert(ReadFromFile.getListFromFile(emptyFileName).isEmpty)
      }
    }
  }
}
