object pascal{;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(124); 
	def pascal(c: Int, r: Int): Int =
	if (r <= 1 || r == c || c == 0) 1
	else pascal(c-1, r-1) + pascal(c, r-1);System.out.println("""pascal: (c: Int, r: Int)Int""");$skip(14); val res$0 = 
	 pascal(0,1);System.out.println("""res0: Int = """ + $show(res$0))}
 }
 