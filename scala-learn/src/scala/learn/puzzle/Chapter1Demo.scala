package scala.learn.puzzle

/**
 * @Author Administrator
 * @Date 2022/10/6 14:48
 * @Version 1.0
 *          Desc:
 */
object Chapter1Demo {
  def main(args: Array[String]): Unit = {
    val ints = List(1, 2, 3, 4, 5)
    val ints1: List[Int] = ints.map(x => x + 1)
    val ints2: List[Int] = ints.map(_ + 1)
     println(s" ints1:   ${ints1} ")
     println(s" ints2:   ${ints2} ")

    val ints3: List[Int] = List(1,2,3).map { x =>  x*x}
    println(s" ints3:   ${ints3} ")
    val ints4: List[Int] =List(1,2,3).map {
      println("hi");
      _ + 1
    }
    println(s" ints4:   ${ints4} ")

    val  printAndAddOne = (i:Int)=>{println("Hi"); i + 1}
    val  printAndReturnFunction ={println("Hi"); ( _:Int) + 1 }

    /**
     * *  用占位符语法定义的匿名函数的范围只延伸到含有下划线（）的表达式。这不同于常规的匿名函数,
     * *  常规的匿名函数的函数体是包含从箭头标识符（＝＞）一直到代码块结束的所有代码
     */
      //标准匿名函数
    val  regularFunc = {a:Any =>println("Foo");println(a);"Baz"}
    regularFunc("hello")
    //使用占位符表示的函数
    val anonymousFunction = { println("Foo");println(_:Any) }
    println("*"*20)//等价
    val confineFunc =   { println("foo"); {a:Int => println(a)}}
    println(confineFunc)

    val  demo = {a:Int => println(a)}
    List(2,3).map(anonymousFunction)
  }

}
