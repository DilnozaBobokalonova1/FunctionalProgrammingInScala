package week4

object exprs {
  def show(e: Expr): String = e match {
    case Number(x) => x.toString()
    //the keyword new was not used to instantiate the Number case class because case classes have an apply method by default which takes care of object construction
    case Sum(l, r) => show(l) + " + " + show(r)
   }                                              //> show: (e: week4.Expr)String
  
  show(Sum(Number(1), Number(44)))                //> res0: String = 1 + 44
  def another(): Message ={
  val message2 = Message("jorge@catalonia.es", "guillaume@quebec.ca", "Com va?")
  val message3 = Message("jorge@catalonia.es", "guillaume@quebec.ca", "Com va?")
  //message2.sender = "travis@washington.us" //cant do this due to it being val i.e immutable
  val messagesAreTheSame = message2 == message3  // true
  val message4 = message3.copy() //shallow copy of message3 object
  message4
  //Case classes are compared by structure and not by reference:
  //Even though message2 and message3 refer to different objects, the value of each object is equal.
}}