package p2p.math

import org.scalatest.WordSpec
import org.scalatest.Matchers._


/**
  * Created by camilosampedro on 13/04/17.
  */
class TGammaDistributionTest extends  WordSpec {
  "The gamma function" should {
    import TGammaDistribution.gamma
    "return 1 when invoking with 1" in {
      gamma(1) shouldBe 1
    }
    "return 24 when invoking with 5" in {
      gamma(5) shouldBe 24
    }
    "return 11.61173 when invoking with 9/2" in {
      gamma(9f/2) shouldBe 11.63173 +- 0.001
    }
    "return 52.34277 when invoking with 11/2" in {
      gamma(11f/2) shouldBe 52.34277 +- 0.001
    }
    "throw an ArithmeticException when invoking with 0.1234" in {
      intercept[ArithmeticException](gamma(0.1234))
    }
  }
  "The gamma distribution" should {
    "create a new gamma distribution with dof equals to 1" in {
      new TGammaDistribution(1).dof shouldBe 1
    }
    "be an instance of TDistribution" in {
      new TGammaDistribution(1) shouldBe an[TDistribution]
    }
    "be an instance of PolynomicFunction" in {
      new TGammaDistribution(1) shouldBe an[PolynomicFunction]
    }
  }
  "The t gamma distribution" should {
    "have an integral of 0.35005864 from 0 to 1.1 with 9 degrees of freedom" in {
      new TGammaDistribution(9).integrate(1.1) shouldBe 0.35005864 +- 0.001
    }
    "have a gamma left part of 0.388035 when the degrees of freedom are 9" in {
      new TGammaDistribution(9).leftPart shouldBe 0.388035 +- 0.0001
    }
    "have an integral of 0.36757 from 0 to 1.1812 with 10 degrees of freedom" in {
      new TGammaDistribution(dof = 10).integrate(1.1812) shouldBe 0.36757 +- 0.0001
    }
    "have a gamma left part of 0.389108 when the degrees of freedom are 9" in {
      new TGammaDistribution(10).leftPart shouldBe 0.389108 +- 0.0001
    }
    "have an integral of 0.49500 from 0 to 2.750 with 30 degrees of freedom" in {
      new TGammaDistribution(dof = 30).integrate(2.750) shouldBe 0.49500 +- 0.0001
    }
  }
}
