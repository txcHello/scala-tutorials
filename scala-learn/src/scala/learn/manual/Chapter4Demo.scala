package scala.learn.manual

/**
 * @Author Administrator
 * @Date 2022/9/30 15:49
 * @Version 1.0
 *          Desc:
 */
object Chapter4Demo {
  def main(args: Array[String]): Unit = {
    log(132.2)
    println(hello())
    println(hello)
    println(hi)
    println()
    val str: String = formatEuo {
      5 * 23
    }
    println(str)
     val s :Int = 2
     s match {
       case x if x>0 =>
     }
    println(max(1,2,3))
    println(sum(1, 2, 3, 4, 5, 65, 456, 64, 64, 2))


    println(identity[String]("hello"))
    println(identity[Int](2313))
    println(identity(2314.2))
  }

  def log(x:Double) = println(s"${x}")
  //过程的另一种写法
  def log1(x:Double)  {println(s"${x}")}
 //用空括号定义个函数
  def  good() :String="good"
  //注意有副作用的函数应该使用小括号
   def hello()="hello"
   def hi ="hi"
  def formatEuo(x:Double)= f" C $x%.2f "
    formatEuo(2341.5)
  formatEuo{val i= 23344; i*2344.5}
  //递归函数
  //递归函数，自身调用自身，需要检查某类参数和外部条件来避免函数调用进入无限循环。

  /**
   * 递归函数，自身调用自身，需要检查某类参数和外部条件来避免函数调用进入无限循环。
   * 递归函数如果递归次数较多 会发生栈溢出的错误
   * scala通过尾递归 优化部分递归函数，使递归调用不采用额外的栈空间。
   * 只有最后一个语句是递归函数才能由优化为尾递归
   * 利用函数注解(function annotation)标记的函数会完成 尾递归的优化
   */

  def power1(x:Int,n:Int):Long={
    if (n>1)  x * power1(x,n-1)
    else 1
  }
    @annotation.tailrec
  def power(x:Int,n:Int,t:Int=1):Long={
    if (n< 1)  t
    else  power(x,n-1,x*t)
  }
  //嵌套函数：函数表达式,中依然包含函数
  def max(a:Int,b:Int,c:Int) :Int={
    def max(a:Int,b:Int)={
      if(a>b) a else  b
    }
    max(a,max(b,c))
  }

  //命名参数调用函数
  def greet (prefix:String,name:String)=s"$prefix ,: $name"

  greet("ms","bown")
  println(greet(name = "andy", prefix = "ha"))


  //有默认值的参数
  def greet1 (prefix:String="你是帅哥",name:String)=s"$prefix ,: $name"

  //vararg 参数   可变参数
  def  sum(items:Int*):Int={
    var count :Int = 0
    for (elem <- items) {

      count+=elem
    }
    count
  }

  //类型参数  def <function-name>[type-name]:(parameter-name:<type-name>):<type-name>  ...
  def identity[A](a:A):A= a

 //方法和操作符
  /**
   * 方法 是类中定义的函数，每个类实例中都会有这个方法*
   */


}
