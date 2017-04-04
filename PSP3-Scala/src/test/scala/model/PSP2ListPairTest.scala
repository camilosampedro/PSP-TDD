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
    "is the first test case" should {
      val firstCase = PSP2ListPair(estimatedProxySize, actualAddedAndModifiedSize)
      val firstCaseXk = 386
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
      "have a x squared sum of 2540284" in {
        firstCase.xList.sqSum shouldBe 2540284
      }
      "have a correlation multiplication of 4303108" in {
        firstCase.sumMult shouldBe 4303108
      }
      "have a y squared sum of 7604693" in {
        firstCase.yList.sqSum shouldBe 7604693
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
      "have a beta 0 of -22.55" in pending
      "have a r sub xy of 0.9545" in pending
      "have a r squared of 0.9111" in pending
      "have a y sub k of 644.429" in pending
    }
  }
  "is the second test case" should {
    val secondCase = PSP2ListPair(estimatedProxySize, actualDevelopmentHours)
    val secondCaseXk = 386
    "have a beta 1 of 0.1681" in {
      secondCase.beta1 shouldBe 0.1681 +- 0.01
    }
    "have a beta 0 of -4.039" in pending
    "have a r sub xy of 0.9631" in pending
    "have a r squared of 0.8711" in pending
    "have a y sub k of 60.858" in pending
  }
  "is the third test case" should {
    val thirdCase = PSP2ListPair(planAddedAndModifiedSize,actualAddedAndModifiedSize)
    val thirdCaseXk = 386
    "have a beta 1 of 1.43097" in {
      thirdCase.beta1 shouldBe 1.43097 +- 0.01
    }
    "have a beta 0 of -23.92" in pending
    "have a r sub xy of 0.9631" in pending
    "have a r squared of 0.9276" in pending
    "have a y sub k of 528.4294" in pending
  }
  "is the third test case" should {
    val fourthCase = PSP2ListPair(planAddedAndModifiedSize,actualDevelopmentHours)
    val fourthCaseYk = 386
    "have a beta 1 of 0.140164" in {
      fourthCase.beta1 shouldBe 0.140164 +- 0.01
    }
    "have a beta 0 of -4.604" in pending
    "have a r sub xy of 0.9480" in pending
    "have a r squared of 0.8988" in pending
    "have a y sub k of 49.4994" in pending
  }


}
