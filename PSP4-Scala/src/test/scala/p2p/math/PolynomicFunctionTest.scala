package p2p.math

import org.scalatest.WordSpec
import org.scalatest.Matchers._

/**
  * Created by camilosampedro on 13/04/17.
  */
class PolynomicFunctionTest extends WordSpec {
  "A polynomic function" when {
    "it is being created" should {
      "create and contain a function implicitly" in {
        val function: PolynomicFunction = (x: Double) => 2*x
        function.function(2) shouldBe 4
      }
    }
  }
}
