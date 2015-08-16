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
                                                  
  def firstN (x : List[Int], n : Int): List[Int] =
  {
  	def firstNHelper(seenSoFar: Int) : List[Int] =
  	{
  		seenSoFar match
  		{
  			case 0 => Nil
  			
  			case y =>
  			{
  				x match
  				{
  					case head :: rest => head :: firstN(rest, seenSoFar - 1)
  				}
  			}
  		}
  	}
  	
  	firstNHelper(n)
  }                                               //> firstN: (x: List[Int], n: Int)List[Int]
  
  
	def dropN (x : List[Int], n : Int): List[Int] =
  {
  	def dropNHelper(seenSoFar: Int) : List[Int] =
  	{
  		seenSoFar match
  		{
  			case 0 => x
  			
  			case y =>
  			{
  				x match
  				{
  					case head :: rest => dropN(rest, seenSoFar - 1)
  				}
  			}
  		}
  	}
  	
  	dropNHelper(n)
  }                                               //> dropN: (x: List[Int], n: Int)List[Int]
  
  
  firstN(List(1, 2, 3, 4, 5), 2)                  //> res6: List[Int] = List(1, 2)
  dropN(List(1, 2, 3, 4, 5), 2)                   //> res7: List[Int] = List(3, 4, 5)
  
	def mergeSortedLists(x: List[Int], y: List[Int]) : List[Int] =
	{
		x match
		{
			case Nil => y
			case headX :: restX =>
			{
				y match
				{
					case Nil => x
					
					case headY :: restY =>
					{
						if ( headX <= headY) headX :: mergeSortedLists(restX, y) else mergeSortedLists(y, x)
					}
				}
			}
		}
	}                                         //> mergeSortedLists: (x: List[Int], y: List[Int])List[Int]
	
	def mergeSort(x: List[Int]): List[Int] =
	{
		val y: Int = x.size / 2
		
		if (y == 0) x
		else
		{
			mergeSortedLists(mergeSort(firstN(x,y)), mergeSort(dropN(x,y)))
		}
	}                                         //> mergeSort: (x: List[Int])List[Int]
	
	mergeSortedLists(List(1, 3, 4, 5, 7, 9), List(2, 4, 6, 8, 10))
                                                  //> res8: List[Int] = List(1, 2, 3, 4, 4, 5, 6, 7, 8, 9, 10)
                                                  
	mergeSort(List(10, 9, 8, 7, 6, 66, 4, 3, 2, 1))
                                                  //> res9: List[Int] = List(1, 2, 3, 4, 6, 7, 8, 9, 10, 66)
	
}