package src.week4



object exprs {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(163); 
  def show(e: Expr): String = e match {
    case Number(x) => x.toString()
    case Sum(l, r) => show(l) + " + " + show(r)
   };System.out.println("""show: (e: <error>)String""");$skip(38); val res$0 = 
  
  show(Sum(Number(1), Number(44)));System.out.println("""res0: <error> = """ + $show(res$0))}
}
