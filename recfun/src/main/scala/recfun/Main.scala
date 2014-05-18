package recfun

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }


  /**
   * Exercise 1
   */
  def pascal(c: Int, r: Int): Int = {
    def numColumnsInRow = r + 1

    if (r == 0 && c == 0) 1
    else if (c < 0 || c >= numColumnsInRow) 0
    else pascal(c-1, r-1) + pascal(c, r-1)
  }

  /**
   * Exercise 2
   */
  def balance(chars: List[Char]): Boolean = {
    /*
     * Could use a stack here instead of depth, but not needed
     */
    def bal(depth: Int, chars: List[Char]): Boolean = {
      if (chars.isEmpty) {
        depth == 0
      } else {
        val c = chars.head
        if (c == '(') {
          bal(depth + 1, chars.tail)
        } else if (c == ')') {
          (depth != 0) && bal(depth - 1, chars.tail)
        } else {
          bal(depth, chars.tail)
        }
      }
    }

    bal(0, chars)
  }

  /**
   * Exercise 3
   */
  def countChange(money: Int, coins: List[Int]): Int = {
    def sumAllPossibleForOneCoin(m: Int, c: Int, coins: List[Int]): Int = {
      if (m < 0) 0 else countChange(m, coins) + sumAllPossibleForOneCoin(m - c, c, coins)
    }

    if (coins.isEmpty) 0
    else if (coins.length == 1) {
      if (money % coins.head == 0) 1 else 0
    } else {
      /*
      var sum = 0
      for (x <- 0 to money / coin) {
        sum = sum + countChange(money - (coin * x), coins.tail)
      }
      sum
      */
      sumAllPossibleForOneCoin(money, coins.head, coins.tail)
    }
  }
}
