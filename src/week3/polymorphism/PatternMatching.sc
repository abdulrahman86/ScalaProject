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
}