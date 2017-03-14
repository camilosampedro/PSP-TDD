package model

import scala.language.implicitConversions

/**
  * Lista
  */
class PSP1List(val list: List[Double]) {
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
}

object PSP1List {
  implicit def convertToNeededList(list: List[Double]): PSP1List = new PSP1List(list)

  implicit def convertToNeededListFromInt(list: List[Int]): PSP1List = new PSP1List(list.map(_.toDouble))

  implicit def toList(list: PSP1List): List[Double] = list.list
}