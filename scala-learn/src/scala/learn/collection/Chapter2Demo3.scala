package scala.learn.collection

import java.io
import scala.collection.generic.FilterMonadic
import scala.collection.immutable.{HashMap, HashSet, TreeSet}
import scala.collection.{immutable, mutable}
import scala.collection.parallel.immutable
import scala.reflect.runtime.{universe => ru}

/**
 * @Author Administrator
 * @Date 2022/10/3 21:09
 * @Version 1.0
 *          Desc:
 */
object Chapter2Demo3 {
  def main(args: Array[String]): Unit = {
    //利用偏函数筛选元素

    val isEven: PartitialFunction[Int, String] = {
      case x if x % 2 == 0 => x + " is even"
    }

    //对所有元素应用一个函数，并将结果放入新的Traversable 集合中
    // def map[B](x: (A) => B):Traversable[B]
    val t = Traversable(1, 2, 34, 45, 6)
    val ints: Traversable[Int] = t.map(x => x * 2)
    println(ints)
    val s =
      """Builds a new collection  by applying  a  function
        |to  all  elements of  this collect an using  the
        |elements of  the  resulting  collection
        |""".stripMargin
    val tt: Traversable[String] = for (x <- s.split("\r\n")) yield x

    def getWords(lines: Traversable[String]): Traversable[String] = {
      lines.flatMap(line => line.split("\\W+"))
    }

    val strings: Traversable[String] = getWords(tt)
    println(strings)
    //利用scan 计算Traversable 元素的阶层

    def badFactorial(x: Int): Int = {
      if (x == 0) 1 else (x * badFactorial(x - 1))
    }

    val inclusives = Traversable(1 to 5: _*)
    val ints1: Traversable[Int] = inclusives.map(x => badFactorial(x))
    println(ints1)

    val ints2: Traversable[Int] = inclusives.scan(1)(_ * _)
    println(ints2)
    val ints3: Traversable[Int] = inclusives.scanRight(1)(_ * _)
    println(ints3)
  }

  //利用fold  /: 相同; foldRight :\
  val l = Traversable("A", "B", "C", "D", "F")
  println(l.fold("z")(_ + _))
  println(l./:("Z")(_ + _))
  println(l.foldRight("Z")(_ + _))
  println(l.:\("Z")(_ + _))

  //判断一个Traversable 非空,判断 检查集合是否不包含任何元素

  val t = Traversable.empty
  println(t.size)
  println(t.isEmpty) //首推荐
  println(t.nonEmpty)

  //获得某个特定函数
  println(l.head)
  println(l.last)
  println(l.headOption)
  println(l.lastOption)

  //find
  def isEven(x: Int) = x % 2 == 0

  private val ints = Traversable(1 to 10: _*)
 //得到对象尾部
  println(ints.tail) //除去第一个元素的剩余元素
  println(ints.tails) //生成 iterator[Traversable] 迭代生成tail
  for (i<- ints.tails)println(i)

  println(ints.init) //和tail相反，得到除去最后一个元素的所有元素
  for (i <-ints.inits) println(i)
  // 选择Traverable 一段子集
  println(ints.slice(1,3))
  // 选取前n个元素
  println(ints.take(12))
  ints.takeWhile(_<=6)
  //跳过前n个元素
  println(ints.drop(10))
  println(ints.dropWhile(_<8))
  //根据条件筛选元素
  println(ints.filter(_ % 2 == 0))
  println(ints.filterNot(_ % 2 == 0))
  /**
   * 类型为FilterMonadic,只包含 map,flatmap,foreach,withFilter
   * 函数式编程概念：单子（monad）,这种类型可以 进行管道操作处理数据*
   */
  private val value: FilterMonadic[Int, Traversable[Int]] = ints.withFilter(_ % 2 == 0)
  value withFilter(_<6) withFilter(_>2) foreach(println) //直到调用foreach才开始计算

  // 将Traverable 分组
  println(ints.splitAt(2)) //相当于 take(n),drop(n)
  println(ints.span(_ < 6)) //相当于 takeWhile(n),dropWhile(n)  遇到某个元素不满足断言，就不在进行断言进行切割
  println(ints.partition(_%2==0)) //会遍历集合所有元素，满足元素放在一个集合，不满足放在另一个集合
  println(ints.groupBy(_ % 3))

  //检查Traversable 对象中元素是否满足条件
   println(ints.forall(_<100)) //测试所有元素，如果所有元素都满足那么返回true
  println(ints.exists(_<12))
  //统计满足断言的元素个数
  private val values = Traversable(1 to 50: _*)
  println(values.count(_%2==0))
}

