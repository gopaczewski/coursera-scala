import scala.collection.mutable.Queue

object TreeWalk {

  def main(args: Array[String]): Unit = {
    val n = new Node("ABBA")
    n.left = new Node("bar")
    n.right = new Node("baz")
    n.right.right = new Node("A2")
    n.left.left = new Node("A3")
    n.left.left.left = new Node("A4")
    println(breadthFirstSearch(n, "A"))
  }

  def depthFirstWalk(node: Node) {
    if (node != null) {
      depthFirstWalk(node.left)
      depthFirstWalk(node.right)
      print(node)
    }
  }

  def breadthFirstWalk(node: Node) {
    val q = Queue[Node]()
    q.enqueue(node)
    walk(q)
    def walk(q: Queue[Node]) {
      if (! q.isEmpty) {
        val n = q.dequeue()
        println(n)
        if (n.left != null) {
          q.enqueue(n.left)
        }
        if (n.right != null) {
          q.enqueue(n.right)
        }
        walk(q)
      }
    }
  }

  def depthFirstSearch(node: Node, searchToken: String): List[Node] = {
    if (node == null) return Nil
    val matches = depthFirstSearch(node.left, searchToken) ++ depthFirstSearch(node.right, searchToken)
    if (node.value.contains(searchToken)) {
      matches :+ node
    } else {
      matches
    }
  }

  def breadthFirstSearch(node: Node, searchToken: String) = {
    val q = Queue[Node]()
    q.enqueue(node)
    def search(q: Queue[Node], searchToken: String): List[Node] = {
      if (q.isEmpty) return Nil
      val n = q.dequeue()
      if (n.left != null) {
        q.enqueue(n.left)
      }
      if (n.right != null) {
        q.enqueue(n.right)
      }
      if (n.value.contains(searchToken)) {
        n :: search(q, searchToken)
      } else {
        search(q, searchToken)
      }
    }
    search(q, searchToken)
  }

  class Node(
    var value: String,
    var left: Node = null,
    var right: Node = null) {

    override def toString: String = {
      "(" + value + ")"
    }
  }
}
