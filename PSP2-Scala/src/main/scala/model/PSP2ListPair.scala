package model

/**
  * PSP2ListPair
  */
case class PSP2ListPair(xList: PSP1List, yList: PSP1List) {
  val bothList: Vector[(Double, Double)] = xList.list.zip(yList.list)
  val n: Int = bothList.size

  def beta1: Double = {
    val up = upForBeta
    val down = downForBeta
    up / down
  }

  def rXY: Double = {
    val up = n * sumMult - xList.sum * yList.sum
    val down = Math.sqrt(xList.dividerForR * yList.dividerForR)
    up / down
  }

  private[model] def upForBeta = sumMult - n * xList.mean * yList.mean
  private[model] def downForBeta = xList.sqSum - n * xList.mean * xList.mean

  def rSqrt: Double = rXY * rXY

  def sumMult: Double = bothList.map(p => p._1 * p._2).sum
}
