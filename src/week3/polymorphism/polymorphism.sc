package week3.polymorphism

object polymorphism
{
  trait List[T]
  {
  	def head: T
  	def tail: List[T]
  	def isEmpty: Boolean
  }
  
  class Cons[T](val head: T, val tail: List[T]) extends List[T]
  {
  	def isEmpty: Boolean = false
  }
  
  
  class Nil[T] extends List[T]
  {
  	def head: Nothing = throw new NoSuchElementException("Head is null")
  	def tail: Nothing = throw new NoSuchElementException("Tail is null")
  	def isEmpty = true
  }
  
  def singleton[T](elem: T) = new Cons[T](elem, new Nil[T])
  
  def selectElement[T](num: Int, list: List[T], count: Int) : T =
  {
  	if (count <= num && list.isEmpty)
  		throw new IndexOutOfBoundsException()
  	else
  		if (count == num)
  			list.head
  		else
  			selectElement(num, list.tail, count + 1)
  }
  
 val list: List[Int] = new Cons(1, new Cons(2, new Cons(3, new Nil[Int])))
 
 
 
 object List1
 {
 	def applie() = 1 + 2
 }
	
 val x = List1()

	//selectElement(7, list, 0)
}