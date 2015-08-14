package week2

object Classes
{
	val x = new Rational(1, 2)                //> x  : week2.Rational = week2.Rational@636aa365
	x.numer                                   //> res0: Int = 1
}

class Rational(x: Int, y: Int)
{
	def numer = x
	def denom = y
	
	def add(that: Rational) =
	{
		
	}
}