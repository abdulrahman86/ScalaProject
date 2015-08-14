package week3.classHierarchy

object worksheet
{
  def error(x: Int, msg: String) : Boolean = if (x == 1) true else throw new Error(msg)
                                                  //> error: (x: Int, msg: String)Boolean

	error(1, "hello")                         //> res0: Boolean = true
	//error(2, "hello")
	
	class A()
	{
		def hello = print("hello")
	}
	
	class B() extends A
	{
		def bye = print("bye")
	}
	
	def method(x: A) =
	{
		x.hello
	}                                         //> method: (x: week3.classHierarchy.worksheet.A)Unit

	method(new B())
}