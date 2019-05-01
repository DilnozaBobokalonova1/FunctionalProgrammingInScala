package week4.*
import week4.Expr

object exprs {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(177); 
  def show(e: Expr): String = e match {
    case Number(x) => x.toString()
    case Sum(l, r) => show(l) + " + " + show(r)
   };System.out.println("""show: (e: week4.Expr)String""");$skip(38); val res$0 = 
  
  show(Sum(Number(1), Number(44)));System.out.println("""res0: <error> = """ + $show(res$0))}
}
