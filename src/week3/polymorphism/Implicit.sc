package week3.polymorphism

object Implicit
{
  def myFunc(implicit x : String) =
  {
  	x + " hello"
  }
  
  class MyClass
  {
  	val y: String  = "abdul"
  }
  
  implicit object MyClass extends MyClass
  
  myFunc
}