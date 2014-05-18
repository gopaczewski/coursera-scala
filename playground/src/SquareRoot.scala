/**
 * TODO : Document
 *
 * @author gopaczewski
 */
object SquareRoot {


  def sqrt(x: Double) = {
    def abs(x: Double) = if (x < 0) -x else x

    def isGoodEnough(guess: Double, x: Double): Boolean = {
      abs(guess * guess - x) / x < 0.001
    }

    def improve(guess: Double, x: Double) = (guess + x / guess) / 2

    def squareRootIter(guess: Double, x: Double): Double = {
      if (isGoodEnough(guess, x)) guess
      else squareRootIter(improve(guess, x), x)
    }

    squareRootIter(1.0, x)
  }

  /*
   * Main
   */
  def main(args: Array[String]) {
    println(sqrt(1e60))
  }
}
