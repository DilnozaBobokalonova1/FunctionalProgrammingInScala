object exercises {
	def sum(f: Int => Int, a: Int, b: Int) = {
		def loop(a:Int, acc:Int): Int =
			if (a > b) acc
			else loop(a+1, f(a) + acc)
		loop(a, 0)
	}                                         //> sum: (f: Int => Int, a: Int, b: Int)Int
	sum(x => x*x, 3, 5)                       //> res0: Int = 50
	
	def product(f: Int => Int) (a:Int, b:Int): Int =
		if (a > b) 1
		else f(a) * product(f) (a+1, b)   //> product: (f: Int => Int)(a: Int, b: Int)Int
	product(x => x*x)(3, 5)                   //> res1: Int = 3600
	
	def factorial(n:Int) = product(x=>x) (1, n)
                                                  //> factorial: (n: Int)Int
		
	factorial(5)                              //> res2: Int = 120
	
	def mapReduce(f: Int => Int, combine: (Int, Int) => Int, zero: Int) (a: Int, b:Int): Int =
		if (a > b) zero
		else combine(f(a), mapReduce(f, combine, zero)(a+1, b))
                                                  //> mapReduce: (f: Int => Int, combine: (Int, Int) => Int, zero: Int)(a: Int, b:
                                                  //|  Int)Int
	def product2(f:Int => Int)(a: Int, b: Int): Int = mapReduce(f, (x, y) => x*y, 1) (a, b)
                                                  //> product2: (f: Int => Int)(a: Int, b: Int)Int
	
	product2(x => x*x)(3,5)                   //> res3: Int = 3600
	
	def sum2(f: Int => Int)(a: Int, b: Int): Int = mapReduce(f, (x, y) => x+y, 0) (a, b)
                                                  //> sum2: (f: Int => Int)(a: Int, b: Int)Int
  sum2(x=>x*x) (3, 5)                             //> res4: Int = 50
  import math.abs
  val tolerance = 0.0001                          //> tolerance  : Double = 1.0E-4
  def isCloseEnough(x: Double, y: Double) =
  		abs((x-y)/x)/x < tolerance        //> isCloseEnough: (x: Double, y: Double)Boolean
  	def fixedPoint(f: Double => Double) (firstGuess: Double) = {
  		def iterate(guess: Double): Double = {
  			println("guess" + guess)
  			val next = f(guess)
  			if(isCloseEnough(guess, next)) next
  			else iterate(next)
  		}
  		iterate(firstGuess)
  	}                                         //> fixedPoint: (f: Double => Double)(firstGuess: Double)Double
  	fixedPoint(x => 1 + x/2) (1)              //> guess1.0
                                                  //| guess1.5
                                                  //| guess1.75
                                                  //| guess1.875
                                                  //| guess1.9375
                                                  //| guess1.96875
                                                  //| guess1.984375
                                                  //| guess1.9921875
                                                  //| guess1.99609375
                                                  //| guess1.998046875
                                                  //| guess1.9990234375
                                                  //| guess1.99951171875
                                                  //| res5: Double = 1.999755859375
	def sqrt(x: Double) = fixedPoint(y => (y+x/y)/2)(1)
                                                  //> sqrt: (x: Double)Double
	sqrt(2)                                   //> guess1.0
                                                  //| guess1.5
                                                  //| guess1.4166666666666665
                                                  //| guess1.4142156862745097
                                                  //| res6: Double = 1.4142135623746899
  def averageDamp(f: Double => Double)(x: Double) = (x+f(x))/2
                                                  //> averageDamp: (f: Double => Double)(x: Double)Double
  def sqrt2(x: Double) =
  		fixedPoint(averageDamp(y => x/y)) (1)
                                                  //> sqrt2: (x: Double)Double
  	sqrt2(2)                                  //> guess1.0
                                                  //| guess1.5
                                                  //| guess1.4166666666666665
                                                  //| guess1.4142156862745097
                                                  //| res7: Double = 1.4142135623746899
  	def greaterThanFive(x: Int): Boolean = x > 5
                                                  //> greaterThanFive: (x: Int)Boolean
  	def greaterThanFive2: Int => Boolean = (x: Int) => x > 5
                                                  //> greaterThanFive2: => Int => Boolean
  	
  	def greaterThan(x: Int): Int => Boolean = {
  		println("x " + x)
  		y => y > x
  	}                                         //> greaterThan: (x: Int)Int => Boolean
  	
  	val greaterThanThree: Int => Boolean = greaterThan(3)
                                                  //> x 3
                                                  //| greaterThanThree  : Int => Boolean = exercises$$$Lambda$19/398887205@7a0ac6
                                                  //| e3
  	val isTwoGreaterThanThree: Boolean = greaterThanThree(2)
                                                  //> isTwoGreaterThanThree  : Boolean = false
  
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