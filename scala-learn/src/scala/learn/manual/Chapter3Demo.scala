package scala.learn.manual

import scala.collection.immutable

/**
 * @Author Administrator
 * @Date 2022/9/29 23:53
 * @Version 1.0
 *  Desc: 概念描述
 *   表达式和条件式:
 *    表达式表示在执行后会返回值的一个代码单元;
 *    用大括号{} 将多行代码收集在一起也可以认为是一个表达式
 *    表达式为函数式编程的基础，返回值是不可变的
 *    声明格式:
 *    var indentifier :type = expression
 *    val indentifier :type = expression
 *    语句statement 是没有返回值的表达式*
 *
 *    表达式种类:
 *    if  else 表达式
 *    匹配表达式 *    *    *    *
 *    *
 */
object Chapter3Demo {
  def main(args: Array[String]): Unit = {
    val a = 5 * 20
    val amount = a + 10


    val amount1 = {
      val a = 100;
      a * 8
    }
    //表达式可以嵌套
    val i: Int = {
      val a = 1;
      {
        val b = a * 2;
        {
          val c = a + b
        }
      };
      a + 1
    }
    println(amount)


    //匹配表达式
    val m = 1
    val n = 2

    val i1: Int = m > n match {
      case false => m
      case true => n
    }
    val status = 500

    val value: Any = status match {
      case 200 => "ok"
      case 400 => println("Error, we called the service incorrectly ")
      case 500 => println("Error - the service encountered error")
    }
    println(value)

    //模式替换式
    val str1: String = "lisi"

    val str: String = str1 match {
      case "lisi" | "wangwu" | "zhangsan" => "hh "
      case "alice" | "dad" => "hehe"
    }
    //通配模式匹配: 值绑定和通配符
    val message = "hl"
    val i2: Int = message match {
      case "OK" => 200
      //定义值other 将 hl赋值给 other  message为匹配表达式的输入
      case other => {
        println(s"Couldn't  parse $other");
        -1
      }
    }
    println(i2) // 结果 Couldn't  parse hl

    //通配符模式
    val star: String = "zhaobensan"
    val str2: String = star match {
      case "东北人" => "你跺你也麻"
      case _ => star
    }
    println(str2)

    //模式哨位匹配 : 向值绑定模式增加一个if 表达式,为表达式增加判断逻辑
    val  r :Int = 18
    val unit: Unit = r match {
      case x if (x == 10) => println(s"Received $x")
      case _ => println("")
    }
    //循环
    val ints: immutable.IndexedSeq[Int] = for (x <- 1 to 20) yield {
      x + 1
    }
    println(ints)
    //迭代器哨位
    for( x <- 1 to 200  if x <20){

      println(x)

    }
    val words:String = "red,green,orange,blue"
    for {x <- words.split(",")
         if x!= null
         if x.length>0 } {

      println(x)
    }
    //嵌套迭代器  Nested iterator ,是增加到一个for循环的额外的迭代器，di
    for {
      x <- 1 to 2
      y <- 1 to 3
    }{
      println(x +","+ y)

    }



  }
}
