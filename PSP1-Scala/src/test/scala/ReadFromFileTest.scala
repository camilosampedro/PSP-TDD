import java.io.FileNotFoundException

import model.PSP1List
import org.scalatest.Matchers._
import org.scalatest.WordSpec

/**
  * ReadFromFileTest
  */
class ReadFromFileTest extends WordSpec {
  val emptyFileName: String = getClass.getResource("testEmpty.txt").getFile
  val testFileName: String = getClass.getResource("test.txt").getFile
  val fileWithWrongFormat: String = getClass.getResource("fileWithWrongFormat.txt").getFile

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
    "has numbers" should {
      val result = ReadFromFile.getListFromFile(testFileName)
      "return its content as a PSP1List" in {
        result shouldBe an[PSP1List]
      }
      "return its content as a non-empty List" in {
        assert(result.nonEmpty)
      }
      "its content should match to the expected ones" in {
        result.list match {
          case 160.0 :: 15.0 :: (-15.0) :: Nil => succeed
          case _ => fail
        }
      }
    }
    "has a wrong format" should {
      "throw a NumberFormatException" in {
        intercept[NumberFormatException](ReadFromFile.getListFromFile(fileWithWrongFormat))
      }
    }
  }
}
