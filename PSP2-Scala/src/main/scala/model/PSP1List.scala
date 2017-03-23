package model

import scala.language.implicitConversions

/**
  * Lista
  */
case class PSP1List(list: Vector[Double]) {
  val n: Int = list.size

  def mean: Double = {
    if (list.isEmpty) {
      throw new ArithmeticException("Division by zero")
    } else {
      list.sum / list.size
    }
  }

  def sqrtSum: Double = if (mean.isNaN) {
    Double.NaN
  } else {
    list.map(n => (n - mean) * (n - mean)).sum
  }

  def stdDev: Double = Math.sqrt(sqrtSum / (list.size - 1))

  def sumPow: Double = list.map(v=>v*v).sum

  def sum: Double = list.sum

  def dividerForR: Double = n * sumPow - (sum * sum)
}

object PSP1List {
  implicit def convertToNeededList(list: Vector[Double]): PSP1List = new PSP1List(list)

  implicit def convertToNeededListFromInt(list: Vector[Int]): PSP1List = new PSP1List(list.map(_.toDouble))

  implicit def toList(list: PSP1List): Vector[Double] = list.list
}