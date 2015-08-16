package week3.polymorphism

object PatternMatching
{
  trait Expr
  {
  }
  
  case class Number(n: Int) extends Expr
  case class Sum(op1: Expr, op2: Expr) extends Expr
  
  def show(expr: Expr) : String =
  {
  	expr match
  	{
  		case Number(n) => n.toString()
  		case Sum(x, y) => "(+ " + show(x) + " " + show(y) + ")"
  	}
  }                                               //> show: (expr: week3.polymorphism.PatternMatching.Expr)String
  
  show(Sum(Sum(Number(3), Number(4)), Number(2))) //> res0: String = (+ (+ 3 4) 2)
  
  
  def addList(x: List[Int]) : Int =
  {
  	x match
  	{
  		case y :: Nil => y
  		case y :: xs => y + addList(xs)
  	}
  }                                               //> addList: (x: List[Int])Int
  
  addList(1 :: 2 :: 3 :: 4 :: 5 :: Nil)           //> res1: Int = 15
  
  
  def insertIntoSortedList(x: Int, list : List[Int] ) : List[Int] =
  {
  	list match
  	{
  		case Nil => List(x)
  		case head :: xs =>
  		{
  			if (head > x) x :: head :: xs else head :: insertIntoSortedList(x, xs)
  		}
  	}
  }                                               //> insertIntoSortedList: (x: Int, list: List[Int])List[Int]
  
  insertIntoSortedList(1, 2 :: 4 :: 5 :: Nil)     //> res2: List[Int] = List(1, 2, 4, 5)
  
  
  def sortList(x: List[Int]) : List[Int] =
  {
  	x  match
  	{
  		case Nil => Nil
  		case x :: Nil => List(x)
  		case x :: xs =>
  		{
  			insertIntoSortedList(x, sortList(xs))
  		}
  	}
  
  }                                               //> sortList: (x: List[Int])List[Int]
  
  sortList(2 :: 3 :: 4 :: 5 :: 1 :: Nil)          //> res3: List[Int] = List(1, 2, 3, 4, 5)

	
	(1 :: 2 :: Nil) :: 3 :: Nil               //> res4: List[Any] = List(List(1, 2), 3)
	def flatten(x:List[Any]) : List[Any]=
	{
		x match
		{
			case Nil => Nil
			case  (xh :: xhs) :: rest => flatten(xh :: xhs) ++ flatten(rest)
			case  x :: rest => x :: flatten(rest)
		}
	}                                         //> flatten: (x: List[Any])List[Any]
	
	flatten(List(List(1, List(2, 3, 4, 5, 6)), 3, 4))
                                                  //> res5: List[Any] = List(1, 2, 3, 4, 5, 6, 3, 4)
}