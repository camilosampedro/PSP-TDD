package model

import model.PSP1List._

import scala.language.implicitConversions

/**
  * PSP3LinesOfCode
  */
case class PSP3LinesOfCode(linesOfCodePerClass: Vector[(Int, Int)]) {

  import math._

  def linesOfCodePerMethod: Vector[Double] = linesOfCodePerClass.map(p => p._1.toDouble / p._2)

  private[model] def lnXi: Vector[Double] = linesOfCodePerMethod.map(math.log)

  private[model] def avgLnXi: Vector[Double] = lnXi.map(n => pow(n - lnXi.mean, 2))

  private[model] def lnXiStdDev: Double = lnXi.stdDev

  private[model] def lnVS: Double = lnXi.mean - 2 * lnXiStdDev

  private[model] def lnS: Double = lnXi.mean - lnXiStdDev

  private[model] def lnM: Double = lnXi.mean

  private[model] def lnL: Double = lnXi.mean + lnXiStdDev

  private[model] def lnVL: Double = lnXi.mean + 2 * lnXiStdDev

  def verySmall: Double = pow(E, lnVS)

  def small: Double = pow(E, lnS)

  def medium: Double = pow(E, lnM)

  def large: Double = pow(E, lnL)

  def veryLarge: Double = pow(E, lnVL)

}

object PSP3LinesOfCode {
  implicit def fromList(list: Vector[(Int, Int)]): PSP3LinesOfCode = new PSP3LinesOfCode(list)
}