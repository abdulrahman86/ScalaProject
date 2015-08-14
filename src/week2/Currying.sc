package week2

import math.abs

object Currying
{
	val tolerance = 0.0001                    //> tolerance  : Double = 1.0E-4
	
	def isCloseEnough(x: Double, y: Double) =
	{
		abs((x - y) / x) / x < tolerance
	}                                         //> isCloseEnough: (x: Double, y: Double)Boolean
	
	def fixedPoint(f: Double => Double)(firstGuess: Double) =
	{
		def iterate(guess: Double): Double =
		{
			val next = f(guess)
			if (isCloseEnough(next, guess)) next
			else iterate(next)
		}
		
		iterate(firstGuess)
	}                                         //> fixedPoint: (f: Double => Double)(firstGuess: Double)Double
	
	def sqrt(x: Double): Double =
	{
		fixedPoint(y => x / y)(1.0)
	}                                         //> sqrt: (x: Double)Double
	
	fixedPoint(x => 1 + x/2)(1)               //> res0: Double = 1.999755859375
	
	
	
	
}