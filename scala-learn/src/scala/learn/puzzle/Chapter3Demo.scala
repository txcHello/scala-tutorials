package scala.learn.puzzle

/**
 * @Author Administrator
 * @Date 2022/10/6 14:48
 * @Version 1.0
 *          Desc:
 *          成员的声明位置 :
 *          初始化顺序：
 *          1.首先按照定义顺序，早定义早初始化
 *          2.然后是超类构造器初始化
 *          3.最后是缺省的构造器语句*
 *          参数评估和早期字段定义->超类和超特质-> 实例化类和特质初始化语句之前
 *          类或者对象的括号后，按照从左到右的声明顺序插入超类构造器和超特质初始化程序*
 */
object Chapter3Demo {
  def main(args: Array[String]): Unit = {

    val member = new BMember("Readers")
    println("*"*30)
    val constructor = new BConstructor("Readers")
    println("*"*30)
    new BEvery("wangxin")
  }

}

class Myclass(name:String,age:Int){
  private val memberName = name
  private val memberAge= age

}

class Myclass1(val name:String,val age :Int)

trait A {
  val audience :String
  println("Hello  " + audience)

}
class  BMember(a:String ="xiaowang") extends A {
  override val audience: String =  a
  println ( "I repeat: Hello " + audience)
}
class BConstructor(val audience :String = "world" ) extends  A{

  println("I repeat :HELLO " + audience)
}

class  BearlyDef(a:String="word") extends {
  val  audience =a
}with  A{
  println("I repeat:Hello " + audience)
}

trait B {
  val audience :String
  println("Hello " +audience)
}
trait  AfterB {
  val  introduction :String
  println(introduction)
}
class  BEvery(val audience:String) extends {
  val  introduction ={println(" Evaluating  early def "); " Are  you there ?"}
}with B with AfterB{
  println("I repeat : Hello " +audience)
}