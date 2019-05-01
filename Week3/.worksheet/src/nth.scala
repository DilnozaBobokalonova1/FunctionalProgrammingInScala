import week3._
object nth {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(181); 
  def nth[T](n: Int, l: List[T]):  T = {
    if (n == 0) l.head
    else if (l.isEmpty) throw new IndexOutOfBoundsException
    else nth(n-1, l.tail)
  };System.out.println("""nth: [T](n: Int, l: week3.List[T])T""");$skip(60); 
  val list = new Cons(1, new Cons(2, new Cons(3, new Nil)));System.out.println("""list  : week3.Cons[Int] = """ + $show(list ));$skip(16); val res$0 = 
   nth(2, list);System.out.println("""res0: Int = """ + $show(res$0));$skip(17); val res$1 = 
   nth(-1, list);System.out.println("""res1: Int = """ + $show(res$1));$skip(20); val res$2 = 
  new Rational(1,2);System.out.println("""res2: week3.Rational = """ + $show(res$2))}
}
