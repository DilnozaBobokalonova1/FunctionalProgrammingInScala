object balance {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(358); 
	def checker(chars: List[Char], ls: Int, rs: Int): Boolean =
		if (chars.isEmpty && ls == rs) true
		else if (chars.isEmpty && ls != rs) false
		else if (!chars.isEmpty && ls < rs) false
		else if (chars.head == '(') checker(chars.tail, ls+1, rs)
		else if (chars.head == ')') checker(chars.tail, ls, rs+1)
		else checker(chars.tail, ls, rs);System.out.println("""checker: (chars: List[Char], ls: Int, rs: Int)Boolean""");$skip(69); 
		
	def balance(chars: List[Char]): Boolean =
		checker(chars, 0, 0);System.out.println("""balance: (chars: List[Char])Boolean""");$skip(26); val res$0 = 
	
	balance("(())".toList);System.out.println("""res0: Boolean = """ + $show(res$0))}
}


 