package week3

object rationals {
	val x = new Rational(1, 3)
	val y = new Rational(5, 7)
	val z = new Rational(3, 2)
	x.numer
	x.denom
	new Rational(1,2).numer
	new Rational(1,2).denom
	x + y
	x.sub(y).sub(z)
	y + y
	x.less(y)
	x.max(y)
	//val strange = new Rational(1, 0)
	//strange.add(strange)
	new Rational(2)
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
	