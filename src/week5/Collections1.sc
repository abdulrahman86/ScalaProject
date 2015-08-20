package week5

object Collections1
{
  val x = Vector(1, 2, 3)                         //> x  : scala.collection.immutable.Vector[Int] = Vector(1, 2, 3)
	
	5 +: x                                    //> res0: scala.collection.immutable.Vector[Int] = Vector(5, 1, 2, 3)
	
	x :+ 6                                    //> res1: scala.collection.immutable.Vector[Int] = Vector(1, 2, 3, 6)



	val xx = List[Int](1, 2, 3)               //> xx  : List[Int] = List(1, 2, 3)
	
	1 to 5                                    //> res2: scala.collection.immutable.Range.Inclusive = Range(1, 2, 3, 4, 5)
	
	1 until 5                                 //> res3: scala.collection.immutable.Range = Range(1, 2, 3, 4)
	
	val y = List(1, 2, 3)                     //> y  : List[Int] = List(1, 2, 3)
	y flatMap (x => List(List(x)))            //> res4: List[List[Int]] = List(List(1), List(2), List(3))
	
	
	//primality testing
	
	def isPrime(n: Int) : Boolean =
	{
		2 until n exists (x => n % x != 0)
	}                                         //> isPrime: (n: Int)Boolean
	
	isPrime(7)                                //> res5: Boolean = true
}