package week3.polymorphism

import scala.collection.mutable.LinkedList

object SubtypingGenerics {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  val x: Array[Int] = Array(1, 2, 3, 4)           //> x  : Array[Int] = Array(1, 2, 3, 4)
  
  x(0)                                            //> res0: Int = 1
  
  val a = LinkedList(1,2,3,4)                     //> a  : scala.collection.mutable.LinkedList[Int] = LinkedList(1, 2, 3, 4)

	val b = (5 /: a)(_+_)                     //> b  : Int = 15
	
	val d = (5 /: a)(_+_)                     //> d  : Int = 15
	
	class InfixOpDemo()
	{
		def binOp(x:Int) : Int = 1
	}
	
	val z = new InfixOpDemo()                 //> z  : week3.polymorphism.SubtypingGenerics.InfixOpDemo = week3.polymorphism.S
                                                  //| ubtypingGenerics$$anonfun$main$1$InfixOpDemo$1@20c7afdd
	
	class MyClass[T](val x: T)
	{
		def /:[T](y: T) : T = y
	}
	
	val xx = new MyClass[Int](5)              //> xx  : week3.polymorphism.SubtypingGenerics.MyClass[Int] = week3.polymorphism
                                                  //| .SubtypingGenerics$$anonfun$main$1$MyClass$1@232c5bfc
	"hello" /: xx                             //> res1: String = hello

	abstract class Boolean
	{
		def ifThenElse[T](t: =>T, e: =>T): T
		
		def && (x: =>Boolean) = ifThenElse(x, myFalse)
		def || (x: =>Boolean) = ifThenElse(myTrue, x)
	}
	
	object myTrue extends Boolean
	{
		def ifThenElse[T](t: =>T, e: =>T) = t
	}
	
	object myFalse extends Boolean
	{
		def ifThenElse[T](t: =>T, e: =>T) = e
	}
	
	myFalse && myTrue                         //> res2: week3.polymorphism.SubtypingGenerics.MyBoolean = week3.polymorphism.Su
                                                  //| btypingGenerics$$anonfun$main$1$myFalse$2$@678d19b7
}