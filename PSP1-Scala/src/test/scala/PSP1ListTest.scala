import PSP1List._
import org.scalatest.Matchers._
import org.scalatest._

/**
  * ListaTest
  */
class PSP1ListTest extends WordSpec {
  private def have = afterWord("have")

  val column1List: List[Int] = List(160, 591, 114, 229, 230, 270, 128, 1657, 624, 1503)
  val column2List: List[Double] = List(15, 69.9, 6.5, 22.4, 28.4, 65.9, 19.4, 198.7, 38.8, 138.2)
  val negativeList: List[Int] = (-11 to -1).toList
  val emptyList: List[Double] = List.empty[Double]

  "A list" when {
    "empty" must have {
      "a NaN as a calculated mean" in {
        assert(emptyList.mean.isNaN)
      }
      "a NaN as a calculated standard deviation" in {
        assert(emptyList.stdDev.isNaN)
      }
    }
    "is the first column" must have {
      "a calculated mean of 550.6" in {
        column1List.mean shouldBe 550.6 +- 0.01
      }
      "a squared sum of 2944932.4" in {
        column1List.sqrtSum shouldBe 2944932.4 +- 0.01
      }
      "a calculated standard deviation of 572.03" in {
        column1List.stdDev shouldBe 572.03 +- 0.01
      }
    }
    "is the second column" must have {
      "a calculated mean of 60.32" in {
        column2List.mean shouldBe 60.32 +- 0.01
      }
      "a calculated standard deviation of 62.26" in {
        column2List.stdDev shouldBe 62.26 +- 0.01
      }
    }
    "is a list just with negative numbers from -11 to -1" must have {
      "a negative calculated mean of -6" in {
        negativeList.mean should not be >= (0)
        negativeList.mean shouldBe -6
      }
      "a standard deviation of 3.31" in {
        negativeList.stdDev shouldBe 3.31 +- 0.01
      }
    }
  }
}
