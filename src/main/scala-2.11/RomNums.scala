/**
  * Created by jackt on 28/02/2016.
  */
object RomNums {

  val numerals = List(("M", 1000), ("CM", 900), ("D", 500), ("CD", 400),
    ("C", 100),  ("XC", 90),  ("L", 50),  ("XL", 40),
    ("X", 10),   ("IX", 9),   ("V", 5),   ("IV", 4),
    ("I", 1))

  def numeralsConverter(n: Int): String={

    def go(n:Int, holder: Int, input: List[(String, Int)], output: List[String]): List[String] ={
      if(holder <= 0) output
      else go(n, holder - input.head._2,input.filter(_._2 <= (holder - input.head._2)), input.head._1::output)
    }
    go(n, n, numerals.filter(_._2 <= n), List[String]()).reverse.mkString
  }
}
