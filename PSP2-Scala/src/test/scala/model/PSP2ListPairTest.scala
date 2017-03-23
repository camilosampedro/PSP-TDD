package model

import org.scalatest.Matchers._
import org.scalatest.WordSpec

/**
  * PSP2ListPairTest
  */
class PSP2ListPairTest extends WordSpec {
  private val estimatedProxySize = Vector(130, 650, 99, 150, 128, 302, 95, 945, 368, 961)
  private val planAddedAndModifiedSize = Vector(163, 765, 141, 166, 137, 355, 136, 1206, 433, 1130)
  private val actualAddedAndModifiedSize = Vector(186, 699, 132, 272, 291, 331, 199, 1890, 788, 1601)
  private val actualDevelopmentHours = Vector(15.0, 69.9, 6.5, 22.4, 28.4, 65.9, 19.4, 198.7, 38.8, 138.2)

  "A pair list" when {
    val firstCase = PSP2ListPair(estimatedProxySize, actualAddedAndModifiedSize)
    "is the first case" should {
      "have a x sum of 3828" in {
        firstCase.xList.sum shouldBe 3828
      }
      "have a x mean of 382.8" in {
        firstCase.xList.mean shouldBe 382.8 +- 0.1
      }
      "have a y sum of 6389" in {
        firstCase.yList.sum shouldBe 6389
      }
      "have a y mean of 638.9" in {
        firstCase.yList.mean shouldBe 638.9 +- 0.1
      }
      "have a x pow 2 sum of 2540284" in {
        firstCase.xList.sumPow shouldBe 2540284
      }
      "have a correlation multiplication of 4303108" in {
        firstCase.sumMult shouldBe 4303108
      }
      "have a y pow 2 sum of 7604693" in {
        firstCase.yList.sumPow shouldBe 7604693
      }
      "have an up for beta of 1857399" in {
        firstCase.upForBeta shouldBe 1857399.0 +- 0.2
      }
      "have a down for beta of 1074926" in {
        firstCase.downForBeta shouldBe 1074926.0 +- 1
      }
      "have a beta 1 of 1.7279" in {
        firstCase.beta1 shouldBe 1.7279 +- 0.01
      }
    }
  }
}
