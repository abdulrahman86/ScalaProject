package week5

object ForExpression {
  def simpleFun(): Unit =
  {
  	1
  }                                               //> simpleFun: ()Unit
  
  //implementation of flatmap
  def flatMap[T, U](list: List[T], f: T=>Iterable[U]) : List[U]=
  {
  	for (x <- list; y <- f(x)) yield y
  }                                               //> flatMap: [T, U](list: List[T], f: T => Iterable[U])List[U]
  
  val x = List(1,2)                               //> x  : List[Int] = List(1, 2)
  val y = List(2,3)                               //> y  : List[Int] = List(2, 3)
  
  for(i <- x; j <- y) yield i + j                 //> res0: List[Int] = List(3, 4, 4, 5)

	x.flatMap( i => (for (j <- y) yield i + j))
                                                  //> res1: List[Int] = List(3, 4, 4, 5)
}