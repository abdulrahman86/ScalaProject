package week2

object week2
{
	def mapReduce(f: Int => Int, combine: (Int, Int)=>Int, zero: Int)(start: Int, end: Int) : Int  =
	{
		if (start > end) zero else combine(f(start), mapReduce(f, combine, zero)(start+1, end))
	}                                         //> mapReduce: (f: Int => Int, combine: (Int, Int) => Int, zero: Int)(start: Int
                                                  //| , end: Int)Int
	
	def sum (f : Int => Int, start : Int, end : Int): Int =
	{
		def sumHelper(start : Int, acc : Int): Int =
		{
			if (start > end) acc
			else sumHelper(start + 1, acc + f(start))
		}
		
		if (start > end) 0
		else sumHelper(1, 0)
	}                                         //> sum: (f: Int => Int, start: Int, end: Int)Int
	

	sum((x : Int) => x * x * x, 1 , 5)        //> res0: Int = 225
	
	def sum5 =  (x: Int) => x+5               //> sum5: => Int => Int
	
	def sum59 = (x : Int) => (y: Int) => {x + y}
                                                  //> sum59: => Int => (Int => Int)
	
	sum5(4)                                   //> res1: Int = 9
	
	sum59(4)(5)                               //> res2: Int = 9

	def sumCurry (f : Int => Int) (a: Int, b: Int) : Int =
	{
		if(a > b) 0 else f(a) + sumCurry(f)(a+1 , b)
	}                                         //> sumCurry: (f: Int => Int)(a: Int, b: Int)Int
	
	sumCurry((x:Int)=>x)_                     //> res3: (Int, Int) => Int = <function2>
	
	
	def product(f: Int => Int)(a: Int, b: Int) = mapReduce(x => x, (x: Int, y: Int) => x * y, 1)(a,b)
                                                  //> product: (f: Int => Int)(a: Int, b: Int)Int
	
	def factorial(a: Int) : Int = if(a <= 0) 1 else product((x:Int)=> x)(1, a)
                                                  //> factorial: (a: Int)Int
	
	factorial(1)                              //> res4: Int = 1
	product((x : Int) => x * x)_              //> res5: (Int, Int) => Int = <function2>
}