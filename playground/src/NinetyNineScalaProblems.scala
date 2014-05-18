object NinetyNineScalaProblems {

  def main(args: Array[String]) {
    val l = List("a", "b", "c", "d")
    println(findLastElement(l))
    println(findSecondToLast(l))
    println(findKthElement(l, 2))
  }

  def findLastElement(l: List[String]) = {
    l.last
  }

  def findSecondToLast(l: List[String]): String = {
    if (l.isEmpty) return null
    if (l.length == 1) return l.head
    l.init.last
  }

  def findKthElement(l: List[String], i: Int): String = {
    l(i)
  }


}
