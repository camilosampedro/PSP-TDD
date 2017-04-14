package p2p.math

import scala.annotation.tailrec

/**
  * Created by camilosampedro on 13/04/17.
  */
class TGammaDistribution(val dof: Int)
  extends TDistribution(dof, gamma = TGammaDistribution.gamma){
  def integrate(to: Double, num_seg: Int = 10, error: Double = 0.00001): Double = {
    println(s"Executing: $to")
    untilError(to, num_seg * 2, performIntegration(to, num_seg), error)
  }

  @tailrec private def untilError(to: Double, num_seg: Int, last: Double, error: Double): Double = {
    println(s"Last: $last")
    val aNewValue = performIntegration(to, num_seg)
    if(math.abs(aNewValue - last) < error) {
      println(s"Returned: $aNewValue")
      aNewValue
    } else {
      println("Repeating")
      untilError(to, num_seg*2 , aNewValue, error)
    }
  }

  private def performIntegration(to: Double, num_seg: Int) = {
    val w = to / num_seg
    val odds = (1 until num_seg).filter(_ % 2 != 0)
    val pairs = (2 to num_seg - 2).filter(_ % 2 == 0)
    val oddSum = odds.map(i=>4*function(i*w)).sum
    val pairSum = pairs.map(i=>2*function(i*w)).sum
    w/3 * (function(0) + oddSum + pairSum + function(to))
  }
}

object TGammaDistribution {
  def gamma(x: Double): Double = {
    x match {
      case n if n == 1 => 1
      case n if n == 1f / 2 => math.sqrt(math.Pi)
      case n if n > 0 => (n - 1) * gamma(n - 1)
      case n => throw new ArithmeticException(s"n=$n is not computable!")
    }
  }
}