import week3._
object nth {
  def nth[T](n: Int, l: List[T]):  T = {
    if (n == 0) l.head
    else if (l.isEmpty) throw new IndexOutOfBoundsException
    else nth(n-1, l.tail)
  }
  val list = new Cons(1, new Cons(2, new Cons(3, new Nil)))
   nth(2, list)
   nth(-1, list)
  new Rational(1,2)
}