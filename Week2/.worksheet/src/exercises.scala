object exercises {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(160); 
	def sum(f: Int => Int, a: Int, b: Int) = {
		def loop(a:Int, acc:Int): Int =
			if (a > b) acc
			else loop(a+1, f(a) + acc)
		loop(a, 0)
	};System.out.println("""sum: (f: Int => Int, a: Int, b: Int)Int""");$skip(21); val res$0 = 
	sum(x => x*x, 3, 5);System.out.println("""res0: Int = """ + $show(res$0));$skip(101); 
	
	def product(f: Int => Int) (a:Int, b:Int): Int =
		if (a > b) 1
		else f(a) * product(f) (a+1, b);System.out.println("""product: (f: Int => Int)(a: Int, b: Int)Int""");$skip(25); val res$1 = 
	product(x => x*x)(3, 5);System.out.println("""res1: Int = """ + $show(res$1));$skip(47); 
	
	def factorial(n:Int) = product(x=>x) (1, n);System.out.println("""factorial: (n: Int)Int""");$skip(17); val res$2 = 
		
	factorial(5);System.out.println("""res2: Int = """ + $show(res$2));$skip(170); 
	
	def mapReduce(f: Int => Int, combine: (Int, Int) => Int, zero: Int) (a: Int, b:Int): Int =
		if (a > b) zero
		else combine(f(a), mapReduce(f, combine, zero)(a+1, b));System.out.println("""mapReduce: (f: Int => Int, combine: (Int, Int) => Int, zero: Int)(a: Int, b: Int)Int""");$skip(89); 
	def product2(f:Int => Int)(a: Int, b: Int): Int = mapReduce(f, (x, y) => x*y, 1) (a, b);System.out.println("""product2: (f: Int => Int)(a: Int, b: Int)Int""");$skip(27); val res$3 = 
	
	product2(x => x*x)(3,5);System.out.println("""res3: Int = """ + $show(res$3));$skip(88); 
	
	def sum2(f: Int => Int)(a: Int, b: Int): Int = mapReduce(f, (x, y) => x+y, 0) (a, b);System.out.println("""sum2: (f: Int => Int)(a: Int, b: Int)Int""");$skip(22); val res$4 = 
  sum2(x=>x*x) (3, 5)
  import math.abs;System.out.println("""res4: Int = """ + $show(res$4));$skip(43); 
  val tolerance = 0.0001;System.out.println("""tolerance  : Double = """ + $show(tolerance ));$skip(75); 
  def isCloseEnough(x: Double, y: Double) =
  		abs((x-y)/x)/x < tolerance;System.out.println("""isCloseEnough: (x: Double, y: Double)Boolean""");$skip(262); 
  	def fixedPoint(f: Double => Double) (firstGuess: Double) = {
  		def iterate(guess: Double): Double = {
  			println("guess" + guess)
  			val next = f(guess)
  			if(isCloseEnough(guess, next)) next
  			else iterate(next)
  		}
  		iterate(firstGuess)
  	};System.out.println("""fixedPoint: (f: Double => Double)(firstGuess: Double)Double""");$skip(32); val res$5 = 
  	fixedPoint(x => 1 + x/2) (1);System.out.println("""res5: Double = """ + $show(res$5));$skip(53); 
	def sqrt(x: Double) = fixedPoint(y => (y+x/y)/2)(1);System.out.println("""sqrt: (x: Double)Double""");$skip(9); val res$6 = 
	sqrt(2);System.out.println("""res6: Double = """ + $show(res$6));$skip(63); 
  def averageDamp(f: Double => Double)(x: Double) = (x+f(x))/2;System.out.println("""averageDamp: (f: Double => Double)(x: Double)Double""");$skip(67); 
  def sqrt2(x: Double) =
  		fixedPoint(averageDamp(y => x/y)) (1);System.out.println("""sqrt2: (x: Double)Double""");$skip(12); val res$7 = 
  	sqrt2(2);System.out.println("""res7: Double = """ + $show(res$7));$skip(48); 
  	def greaterThanFive(x: Int): Boolean = x > 5;System.out.println("""greaterThanFive: (x: Int)Boolean""");$skip(60); 
  	def greaterThanFive2: Int => Boolean = (x: Int) => x > 5;System.out.println("""greaterThanFive2: => Int => Boolean""");$skip(93); 
  	
  	def greaterThan(x: Int): Int => Boolean = {
  		println("x " + x)
  		y => y > x
  	};System.out.println("""greaterThan: (x: Int)Int => Boolean""");$skip(61); 
  	
  	val greaterThanThree: Int => Boolean = greaterThan(3);System.out.println("""greaterThanThree  : Int => Boolean = """ + $show(greaterThanThree ));$skip(60); 
  	val isTwoGreaterThanThree: Boolean = greaterThanThree(2);System.out.println("""isTwoGreaterThanThree  : Boolean = """ + $show(isTwoGreaterThanThree ))}
  
}
  // the following mean the same thing
	//def greaterThanFive(x: Int): Boolean = x > 5
	//def greaterThanFive: Int => Boolean = (x: Int) => x > 5
	
	// so you could define greaterThan:
	// it takes an Int x and gives you a function that returns
	// true if its parameter  is greater than x and false
	// otherwise
	//def greaterThan(x: Int): Int => Boolean = y => y > x
	
	// usage example for greaterThan
	//val greaterThanThree: Int => Boolean = greaterThan(3)
	//val isTwoGreaterThanThree: Boolean = greaterThanThree(2) // false
