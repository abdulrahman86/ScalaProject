package week4

object ReductionOnLists
{
	def reduceLeft[T,U] (list: List[T], init: U)(implicit op: (U, T) => U) : U =
	{
		list match
		{
			case Nil => init
			case head :: rest => reduceLeft(rest, op(init, head))
		}
	}                                         //> reduceLeft: [T, U](list: List[T], init: U)(implicit op: (U, T) => U)U
	
	
	def foldRight[T, U] (list: List[T], initElement: U)(implicit f: (U,T) => U) : U =
	{
		list match
		{
			case Nil => initElement
			case head :: rest => f(foldRight(rest, initElement), head)
		}
	}                                         //> foldRight: [T, U](list: List[T], initElement: U)(implicit f: (U, T) => U)U
	
	reduceLeft(List(1, 2, 3, 4), 0)(_ + _)    //> res0: Int = 10
	
	foldRight(List(1, 2, 3, 4), 0)(_ + _)     //> res1: Int = 10
}