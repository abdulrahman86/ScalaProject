package week3.polymorphism



object Covariance
{
	
	type IntSet = Set[Int]
	
	object IntSet
	{
  	def apply[A](elems: Int*): IntSet = Set(elems: _*)
  }

	IntSet(1, 2, 3, 4)                        //> res0: scala.collection.immutable.Set[Int] = Set(1, 2, 3, 4)
}