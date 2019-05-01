object pascal{
	def pascal(c: Int, r: Int): Int =
	if (r <= 1 || r == c || c == 0) 1
	else pascal(c-1, r-1) + pascal(c, r-1)    //> pascal: (c: Int, r: Int)Int
	 pascal(0,1)                              //> res0: Int = 1
 }
 