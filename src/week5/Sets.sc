package week5

object Sets
{
  def nQueens (numQueen: Int, boardSize: Int): Set[List[(Int, Int)]] =
  {
  	def isconflict (x: List[(Int, Int)], pair:(Int,Int)): Boolean =
  	{
  		x match
  		{
  			case Nil => false
  			case x :: Nil => pair._1 == x._1 || pair._2 == x._2
  			case x :: tail => if (pair._1 != x._1 && pair._2 != x._2) isconflict(tail, pair) else true
  		}
  	}
  	
  	numQueen match
  	{
  		case 0 => Set()
  		case 1 =>
  			(for (i <- (1 to boardSize).toList; j <- (1 to boardSize).toList) yield List((i, j))) toSet
  		case n =>
  		{
  			(for
  			{
  				row <- 1 to n
  				col <- 1 to n
  				prev <- nQueens(numQueen -1, boardSize)
  				if ! isconflict(prev, (row, col)) && prev.size > 0
  			} yield (row, col) :: prev).toSet
  		}
  	}

  }                                               //> nQueens: (numQueen: Int, boardSize: Int)Set[List[(Int, Int)]]
  
  nQueens(2, 1)                                   //> res0: Set[List[(Int, Int)]] = Set(List((2,2), (1,1)))
  
}