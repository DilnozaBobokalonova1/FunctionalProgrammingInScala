package week3
import week3.List
object nth {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(212); 
  def nth[T](n: Int, l: List[T]):  T =
    if (n == 0) l.head
    else if (n < 0) throw new IndexOutOfBoundsException("Index is out bounds!")
    else nth(n-1, l.tail);System.out.println("""nth: [T](n: Int, l: week3.List[T])T""");$skip(61); 
   val list = new Cons(1, new Cons(2, new Cons(3, new Nil)));System.out.println("""list  : week3.Cons[Int] = """ + $show(list ));$skip(16); val res$0 = 
   nth(2, list);System.out.println("""res0: Int = """ + $show(res$0));$skip(17); val res$1 = 
   nth(-1, list);System.out.println("""res1: Int = """ + $show(res$1))}
   
}
