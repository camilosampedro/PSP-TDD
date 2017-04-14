package p2p.math

/**
  * Created by camilosampedro on 13/04/17.
  */
class TDistribution(dof: Int, gamma: Double => Double)
  extends PolynomicFunction((x: Double) => {
    val right: Double = 1 + (x * x / dof)
    val pow: Double = -(dof + 1).toDouble / 2
    TDistribution.leftPart(dof, gamma) * math.pow(right, pow)
  }) {
  private[math] def leftPart: Double = TDistribution.leftPart(dof, gamma)
}

object TDistribution {
  def leftPart(dof: Int, gamma: Double => Double): Double = {
    val leftUp: Double = gamma((dof + 1).toFloat / 2)
    val leftLeftDown: Double = math.sqrt(dof * math.Pi)
    val leftRightDown: Double = gamma((dof: Float) / 2)
    val leftDown: Double = leftLeftDown * leftRightDown
    leftUp / leftDown
  }
}