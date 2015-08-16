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
                                                  //| nionObjects$MyClass@630ed791
}