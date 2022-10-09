package scala.learn.collection

import java.util
import scala.{Iterable, collection}

/**
 * @Author Administrator
 * @Date 2022/10/8 14:37
 * @Version 1.0
 *          Desc:
 *          1.Traversable 和 Itertor  的区别
 *          主动迭代: Iterator 遍历对象 可以通过hasNext 进行判断，客户代码自主控制执行过程
 *
 *          被动迭代： Traversable 的foreach方法，只能提供一个函数，不能控制遍历过程，迭代过程由集合控制
 */
object Chapter3IterableDemo {

  def main(args: Array[String]): Unit = {
  //将对象分组
  val ints = Iterable(1 to 16: _*)
    val iterator: Iterator[Iterable[Int]] = ints.grouped(5) //根据传入的元素数量进行分组
    while (iterator hasNext){
      println(iterator.next())
    }
    println(ints.sliding(4, 2).foreach(println))
      //zip 缝合两个集合
      val ints1 = Iterable(1 to 7: _*)
    val strings  = Iterable("A", "B", "C", "D", "F")
    println(ints1.zip(strings))
    //zipAll
    val t1 =Iterable("A","B","C","D","F")
    val ints2 = Iterable(1 to 3: _*)

    println(t1.zipAll(ints2, "Z", 100))
    println()

  }

}
