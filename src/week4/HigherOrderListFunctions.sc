package week4

object HigherOrderListFunctions
{
	/*
		Recurring patterns in list
			-Transforming each element of a list in a certain way. Map
			-Retrieving elements of a list satisfying certin criterion. Filter
			-Combining the elements of a list using an operator. Join
	*/
	
	// Map Function
	def map[T, U](x: List[T], f: (T) => U) : List[U] =
	{
		x match
		{
			case Nil => Nil
			
			case head :: rest => f(head) :: map(rest, f)
		}
	}                                         //> map: [T, U](x: List[T], f: T => U)List[U]
	
	//reversing a list using tail recursion in linear time
	def linearReverse[T](x: List[T]) : List[T] =
	{
		def linearReverseHelper[T](list: List[T], accum: List[T]) : List[T] =
		{
			list match
			{
				case Nil => accum
			
				case head :: rest => linearReverseHelper(rest, head :: accum)
			}
		}
		
		linearReverseHelper(x, Nil)
	}                                         //> linearReverse: [T](x: List[T])List[T]
	
	//generic map function implemented using tail recursion.
	def mapTailRecur[T, U](x: List[T], f: (T) => U) : List[U] =
	{
		def mapTailRecurHelper(list: List[T], accum: List[U]) : List[U] =
		{
			list match
			{
				case Nil => accum.reverse
			
				case head :: rest => mapTailRecurHelper(rest, f(head) :: accum)
			}
		}
		
		mapTailRecurHelper(x, Nil)
	}                                         //> mapTailRecur: [T, U](x: List[T], f: T => U)List[U]
	
	def filter[T](list: List[T], cond : (T) => Boolean) : List[T] =
	{
		list match
		{
			case Nil => Nil
			case head :: rest => if (cond(head)) head :: filter (rest, cond) else filter (rest, cond)
		}
	}                                         //> filter: [T](list: List[T], cond: T => Boolean)List[T]

	mapTailRecur(List(1, 2, 3, 4, 5, 6) , (x: Int) => x + 5)
                                                  //> res0: List[Int] = List(6, 7, 8, 9, 10, 11)
                                                  
  linearReverse(List(1, 2, 3, 4, 5, 6))           //> res1: List[Int] = List(6, 5, 4, 3, 2, 1)
  
  filter(List(-1 , 3 , 4 , 5 , 6, - 9, -10 , 11), (x: Int) => x > 0)
                                                  //> res2: List[Int] = List(3, 4, 5, 6, 11)
}