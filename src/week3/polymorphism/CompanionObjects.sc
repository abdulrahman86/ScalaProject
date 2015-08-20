package week3.polymorphism

object CompanionObjects {
  
  class MyClass(x: Int)
  {
  	val y = x
  	
  	private def doSomething =
  	{
  	}
  }
  
 object MyClass
  {
  	def apply(x: Int) =
  	{
  		new MyClass(x)
  	}
  	
  	def something (f: MyClass) =
  	{
  		f.doSomething
  	}
  }
   
  MyClass(1)                                      //> res0: week3.polymorphism.CompanionObjects.MyClass = week3.polymorphism.Compa
                                                  //| nionObjects$MyClass@2e559e7f
  
  	class Obj[T](val x: T)
	{
	}
	
	object Obj
	{
		def apply[T](x: T) : Obj[T] =
		{
			new Obj[T](x)
		}
	}
	
	
	val y = Obj(1).x                          //> y  : Int = 1
}