package week5

object CombinatorialSearch {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  def isPrime1(n: Int) : Boolean =
	{
		2 until n forall (x => n % x != 0)
	}                                         //> isPrime1: (n: Int)Boolean
	
  def myfunc(n: Int) =
  {
  	1 to n  flatMap (x => {1 to n map (y => (x,y))}) filter {case(i,j) => i < j && isPrime1(i+j)}
  	
  }                                               //> myfunc: (n: Int)scala.collection.immutable.IndexedSeq[(Int, Int)]
  
  myfunc(6)                                       //> res0: scala.collection.immutable.IndexedSeq[(Int, Int)] = Vector((1,2), (1,4
                                                  //| ), (1,6), (2,3), (2,5), (3,4), (5,6))
	isPrime1(5)                               //> res1: Boolean = true

	1 to 5                                    //> res2: scala.collection.immutable.Range.Inclusive = Range(1, 2, 3, 4, 5)
	(1 to 5).foldRight(0)((x:Int, y:Int) => x+y)
                                                  //> res3: Int = 15
	
	
	
	(1 to 5).map((x:Int) => { (1 until x).map((y: Int) => (x,y))}).foldRight[Seq[(Int, Int)]](Nil)(_ ++ _)
                                                  //> res4: Seq[(Int, Int)] = Vector((2,1), (3,1), (3,2), (4,1), (4,2), (4,3), (5,
                                                  //| 1), (5,2), (5,3), (5,4))
	
	//(1 to 5 map ((x:Int) => {1 until x map (y => (x,y))})).foldRight[Seq[Int]](Nil)((x: Seq[(Int, Int)], y: Seq[Int]) =>[0])

	def scalarProd(xs: List[Double], ys: List[Double]):Double =
	{
		(for (
			i <- 0 until xs.size
			)yield xs(i) * ys(i)).sum
	}                                         //> scalarProd: (xs: List[Double], ys: List[Double])Double

	scalarProd(List(1,2,3), List(1,2,3))      //> res5: Double = 14.0
	
	for(i <- List(1,2,3); j<-List(4,5,6); if i + j > 7; k <- List(3,4,5); if  i + j + k > 13) yield i + j + k
                                                  //> res6: List[Int] = List(14)
}