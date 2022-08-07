package FunctionsAndEvaluation

import scala.annotation.tailrec

object RecursiveFunctions {
  def pascal(c: Int, r: Int): Int = {
    if (c == 0) 1
    else if (r == 0) 0
    else pascal(r-1,c) + pascal(r-1, c-1)
  }

  def balance(chars: List[Char]): Boolean = {
    @tailrec
    def balanced(chars: List[Char], open: Int): Boolean = {
      if (chars.isEmpty) open == 0
      else if (chars.head == '(') balanced(chars.tail,open+1)
      else if (chars.head == ')') open>0 && balanced(chars.tail,open-1)
      else balanced(chars.tail,open)
    }
    balanced(chars,0)
  }

  def countChange(money: Int, coins: List[Int]): Int = {
    if(money == 0) 1
    else if(money > 0 && coins.nonEmpty)
      countChange(money - coins.head, coins) + countChange(money, coins.tail)
    else 0
  }
}
