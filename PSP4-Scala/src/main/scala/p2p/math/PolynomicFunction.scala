package p2p.math

import scala.language.implicitConversions

/**
  * Created by camilosampedro on 13/04/17.
  */
class PolynomicFunction(val function: Double => Double)

object PolynomicFunction {
  implicit def convertFromFunction(f: Double => Double): PolynomicFunction = new PolynomicFunction(f)
}