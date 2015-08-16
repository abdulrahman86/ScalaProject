package week4

object HigherOrderListFunctions
{
	/*
		Recurring patterns in list
			-Transforming each element of a list in a certain way. Map
			-Retrieving elements of a list satisfying certin criterion. Filter
			-Combining the elements of a list using an operator. Join
	*/
	
	def map[T, U](x: List[T], f: (T) => U) : List[U] =
	{
		x match
		{
			case Nil => Nil
			
			case head :: rest => f(head) :: map(rest, f)
		}
	}                                         //> map: [T, U](x: List[T], f: T => U)List[U]
	
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

	mapTailRecur(List(1, 2, 3, 4, 5, 6) , (x: Int) => x + 5)
                                                  //> res0: List[Int] = List(6, 7, 8, 9, 10, 11)
}