 abstract class Nat {
    def isZero: Boolean
    def predecessor: Nat
    def successor: Nat
    def + (that: Nat): Nat
    def - (that: Nat): Nat
  }
  object Zero extends Nat{;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(209); 
    def isZero: Boolean = true;System.out.println("""isZero: => Boolean""");$skip(31); 
    def predecessor: Nat = - 1;System.out.println("""predecessor: => Nat""")}
  }
  class Succ(n: Nat) extends Nat
