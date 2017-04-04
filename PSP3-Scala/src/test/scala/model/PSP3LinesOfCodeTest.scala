package model

import org.scalatest.Matchers._
import org.scalatest.WordSpec

/**
  * PSP3LinesOfCode
  */
class PSP3LinesOfCodeTest extends WordSpec {
  "A LinesOfCode list" when {
    "it is the first example" should {
      val firstExample = PSP3LinesOfCode(Vector(
        18 -> 3,
        18 -> 3,
        25 -> 3,
        31 -> 3,
        37 -> 3,
        82 -> 5,
        82 -> 4,
        87 -> 4,
        89 -> 4,
        230 -> 10,
        85 -> 3,
        87 -> 3,
        558 -> 10
      ))

      "match the example loc per method" in {
        firstExample.linesOfCodePerMethod
          .zip(Vector(6.0, 6.0, 8.3, 10.3, 12.3, 16.4, 20.5, 21.75, 22.25, 23.0, 28.3, 29.0, 55.8))
          .map(p => p._1 shouldBe p._2 +- 0.1)
      }

      "match the example ln xi" in {
        firstExample.lnXi
          .zip(Vector(1.7918, 1.7918, 2.1203, 2.3354, 2.5123, 2.7973, 3.0204, 3.0796, 3.1023, 3.1355, 3.3440, 3.3673, 4.0218))
          .map(p => p._1 shouldBe p._2 +- 0.1)
      }

      "match the example (lnxi - avg)^2" in {
        firstExample.avgLnXi
          .zip(Vector(1.0196, 1.0196, 0.4641, 0.2173, 0.0836, 0.0000, 0.0479, 0.0773, 0.0905, 0.1115, 0.2943, 0.3201, 1.4890))
          .map(p => p._1 shouldBe p._2 +- 0.1)
      }

      "have a ln xi standard deviation of 0.6605" in {
        firstExample.lnXiStdDev shouldBe 0.6605 +- 0.01
      }

      "have a Very Small logarithm of 1.4805" in {
        firstExample.lnVS shouldBe 1.4805 +- 0.01
      }

      "have a Small logarithm of 2.1410" in {
        firstExample.lnS shouldBe 2.1410 +- 0.01
      }

      "have a Medium logarithm of 2.8015" in {
        firstExample.lnM shouldBe 2.8015 +- 0.01
      }

      "have a Large logarithm of 3.4620" in {
        firstExample.lnL shouldBe 3.4620 +- 0.01
      }

      "have a Very Large logarithm of 4.1225" in {
        firstExample.lnVL shouldBe 4.1225 +- 0.01
      }

      "have a Very Small range of 4.3953" in {
        firstExample.verySmall shouldBe 4.3953 +- 0.01
      }

      "have a  Small range of 8.5081" in {
        firstExample.small shouldBe 8.5081 +- 0.01
      }

      "have a Medium range of 16.4696" in {
        firstExample.medium shouldBe 16.4696 +- 0.01
      }

      "have a Large range of 31.8811" in {
        firstExample.large shouldBe 31.8811 +- 0.01
      }

      "have a Very Large range of 61.7137" in {
        firstExample.veryLarge shouldBe 61.7137 +- 0.01
      }
    }
    "it is empty" should {
      "" in {
        pending
      }
    }
  }
}
