object rationals {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(46); 
	val x = new Rational(1, 3);System.out.println("""x  : Rational = """ + $show(x ));$skip(28); 
	val y = new Rational(5, 7);System.out.println("""y  : Rational = """ + $show(y ));$skip(28); 
	val z = new Rational(3, 2);System.out.println("""z  : Rational = """ + $show(z ));$skip(9); val res$0 = 
	x.numer;System.out.println("""res0: Int = """ + $show(res$0));$skip(9); val res$1 = 
	x.denom;System.out.println("""res1: Int = """ + $show(res$1));$skip(25); val res$2 = 
	new Rational(1,2).numer;System.out.println("""res2: Int = """ + $show(res$2));$skip(25); val res$3 = 
	new Rational(1,2).denom;System.out.println("""res3: Int = """ + $show(res$3));$skip(7); val res$4 = 
	x + y;System.out.println("""res4: Rational = """ + $show(res$4));$skip(17); val res$5 = 
	x.sub(y).sub(z);System.out.println("""res5: Rational = """ + $show(res$5));$skip(7); val res$6 = 
	y + y;System.out.println("""res6: Rational = """ + $show(res$6));$skip(11); val res$7 = 
	x.less(y);System.out.println("""res7: Boolean = """ + $show(res$7));$skip(10); val res$8 = 
	x.max(y);System.out.println("""res8: Rational = """ + $show(res$8));$skip(77); val res$9 = 
	//val strange = new Rational(1, 0)
	//strange.add(strange)
	new Rational(2);System.out.println("""res9: Rational = """ + $show(res$9))}
}

class Rational(x: Int, y: Int){
	require(y != 0, "denominator must be nonzero!")
	
	def this(x: Int) = this(x, 1) //a second constructor in addition to the primary one
	
	private def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)
	//private val g = gcd(x, y)
	def numer = x
	def denom = y
	//or can make numer and denom vals so they are not recomputed every time we call them
	
	def less(that: Rational) = numer * that.denom < that.numer * denom
	def < (that:Rational) = numer*that.denom < that.numer * denom
	def max(that: Rational) = if (this.less(that)) that else this
	def + (that: Rational) =
		new Rational(
			numer * that.denom + that.numer*denom,
			denom * that.denom)
			
	override def toString = {
		val g = gcd(numer, denom)
		numer/g + "/" + denom/g
	}
	def unary_- : Rational = new Rational(-numer, denom)
	def sub(that: Rational) = this + -that
	def - (that: Rational) = this + -that
}
	