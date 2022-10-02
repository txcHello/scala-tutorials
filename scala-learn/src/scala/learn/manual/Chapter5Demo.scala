package scala.learn.manual

import javax.swing.Action

/**
 * @Author Administrator
 * @Date 2022/10/1 14:37
 * @Version 1.0
 *          Desc:
 */
object Chapter5Demo {
  def main(args: Array[String]): Unit = {
    doubles(5)
    println("*"*20)
    doubles(f(8))
    println("*"*20)
    println(statusHandler(200))
  }

  def double(x: Int): Int = x * 2
  val  myDouble1 : Int=>Int =double  //myDouble1 是一个值,并且可以调用myDouble1 ,必须有显示类型，区分它是函数值还是函数调用
  val myDouble2 = double _     // 定义函数值和函数赋值的另一个操作是使用通配符 _  不用显示附上类型
  myDouble1(23) // 调用的结果值和 double(23) 值相等
  myDouble2(23)
  val myDoubleCopy = myDouble1


  //高阶函数

  def stringOps(s: String, f: String => String): String = {
    if (s != null) f(s) else s
  }

  def reverse(x: String): String = {
    x.reverse
  }

  //函数字面量   (x:Int)=>x*2  为函数字面量, double 为函数值，函数字面量可以存在值中也可以存在变量中，亦可以定义为高阶函数调用的部分
  // 接受函数类型的地方都可以使用函数字面量
  //函数字面量是没有函数名字的函数 ：scala 称函数字面量为匿名函数，java中称为 lambda表达式
  val doubler = (x: Int) => x * 2

  //占位符语法 ：为函数字面量的缩写形式，将命名参数替换为通配符(_)
  /**
   * 1.函数的显示类型在字面量之外指定
   * 2.参数最多使用一次* *
   */
  val doubler1: Int => Int = _ * 2
  val devide :(Int,Int)=>Double =  _/_


  def safeStringOps(s: String, f: String => String): String = {
    if (s != null) f(s) else s
  }
  //函数： 部分应用函数和柯里化

  def factorOf(x: Int, y: Int): Boolean = y % x == 0

  val f = factorOf _

  f(1, 32)
  private val intToBoolean: Int => Boolean = f(1, _: Int)

  println(intToBoolean(2))

  //函数柯里化
  def factorOf1(x: Int)(y: Int): Boolean = x % y == 0

  private val intToBoolean1: Int => Boolean = factorOf1(2) _

  //传名参数
  def doubles(x: => Int) = {       //x为传名参数
    println(s"No Double  + $x >>>>>$x" ); x * 2
  }

  def f(x: Int) = {println(s"Hello from f($x)"); x}
  //偏函数
   val  statusHandler :Int=>String={
     case 200 =>"okay"
     case 400 =>"your error"
     case 500 => "our error"
   }

  // 用字面量块调用高阶函数
  def safeStringOpsH(s:String,f:String=>String)={
    if (s!=null) f(s) else s
  }
  val  uuid = java.util.UUID.randomUUID().toString
  private val timedUUID: String = safeStringOpsH(uuid, { s =>
    val now = System.currentTimeMillis()
    val timed = s.take(24) + now
    timed.toUpperCase
  })
  def safeStringOpsE(s:String)(f:String=>String)={

    if (s!=null) f(s) else s
  }

  private val timedUUIDE: String = safeStringOpsE(uuid) {
    s =>
      val now = System.currentTimeMillis()
      val timed = s.take(24) + now
      timed.toUpperCase
  }

  def  timer[A](f : => A):A={
    def now  = System.currentTimeMillis
    val start= now
    val  a =f
    val  end = now
    println(s"Executed in ${end -start} ms ")
     a
  }

  timer{
    util.Random.setSeed(System.currentTimeMillis)
    for(i <- 1 to 100000){
      util.Random.nextDouble()
      util.Random.nextDouble()
    }

  }
}
