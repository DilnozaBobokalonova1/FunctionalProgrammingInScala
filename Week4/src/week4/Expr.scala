package week4

trait Expr
case class Number(n: Int) extends Expr
//When you create a case class with parameters, the parameters are public vals
case class Sum(e1: Expr, e2: Expr) extends Expr
case class Message(sender: String, recipient: String, body: String)