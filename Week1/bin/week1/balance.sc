object balance {
	def checker(chars: List[Char], ls: Int, rs: Int): Boolean =
		if (chars.isEmpty && ls == rs) true
		else if (chars.isEmpty && ls != rs) false
		else if (!chars.isEmpty && ls < rs) false
		else if (chars.head == '(') checker(chars.tail, ls+1, rs)
		else if (chars.head == ')') checker(chars.tail, ls, rs+1)
		else checker(chars.tail, ls, rs)  //> checker: (chars: List[Char], ls: Int, rs: Int)Boolean
		
	def balance(chars: List[Char]): Boolean =
		checker(chars, 0, 0)              //> balance: (chars: List[Char])Boolean
	
	balance("(())".toList)                    //> res0: Boolean = true
}


 