/**
 * TODO : Document
 *
 * @author gopaczewski
 */
object Currying {

  def main(args: Array[String]) {
    println(rop(x => x, (x,y) => x * y, 1.to(4)))
  }

  def rop(f: Int => Int, op: (Int, Int) => Int, r: Range): Int = {
    r.reduce((x,y) => op(f(x), f(y)))
  }
}
