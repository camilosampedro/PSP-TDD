// Copyright (C) 2011-2012 the original author or authors.
// See the LICENCE.txt file distributed with this work for additional
// information regarding copyright ownership.
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
// http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.
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
