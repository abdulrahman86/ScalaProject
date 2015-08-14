package week1

//Comment2
object week1
{
  def abs(x: Double):Double = if (x < 0) -x else x//> abs: (x: Double)Double
  
  /**
  	* Computes square root of the function
  */
  def sqrt(x:Double) : Double =
  {
 		def sqrtItr (guess:Double): Double =
  	{
	  	def isGoodEnough(guess:Double) : Boolean =
	  	{
	  		abs(guess * guess - x) <= 0.001
	  	}
	  	
	  	def improve(guess:Double) : Double =
	  	{
	  		(guess + x / guess) / 2
	  	}
	  	
	  	if (isGoodEnough(guess)) guess
	  	else sqrtItr(improve(guess))
	  
	  }
	  
	  sqrtItr(1.0)
  }                                               //> sqrt: (x: Double)Double
  
  sqrt(4)                                         //> res0: Double = 2.0000000929222947
  sqrt(2)                                         //> res1: Double = 1.4142156862745097
  
}
