package scala.learn.collection

import java.io
import java.util.concurrent.ForkJoinPool
import scala.collection.generic.FilterMonadic
import scala.collection.immutable.{HashMap, HashSet, TreeSet}
import scala.collection.{immutable, mutable}
import scala.collection.parallel.{ForkJoinTasks, Task, immutable}
import scala.reflect.runtime.{universe => ru}

/**
 * @Author Administrator
 * @Date 2022/10/3 21:09
 * @Version 1.0
 *          Desc: 规约，等操作
 */
object Chapter2Demo4 {
  def main(args: Array[String]): Unit = {
   //对函数进行规约操作
   val ints = Traversable(1 to 10: _*)
    val i: Int = ints.reduce(_ + _)
    println(ints.reduceRight(_ * 10 + _))
    println(ints.reduce(_*10+_))
    //对象Travsersable 对象生成字符串
    println(ints.mkString(",")) //提供分隔符 生成字符串
    println(ints.mkString("#", ",", "@")) //提供前缀和后缀
    val sb = new StringBuilder
    sb.clear()
    println(ints.addString(sb,","))

    println(ints.repr.getClass.getName)
    println(ints.stringPrefix)

  //集合类型的转换
    println(ints.toArray)
    println(ints.toParArray)
    ints.toBuffer
    val ints1 = new Array[Int](ints.size)
    println(ints.copyToArray(ints1))
    //得到一个Traverable 的视图

   val ints2 = Traversable(1 to 10: _*)
   println(ints2.view) //view 产生一个当前序列的非严格模式视图，元素是延迟计算的
   println(ints.repr)
   //使用一个相同的元素填充元素
   val strings: Traversable[String] = Traversable.fill(5)("A")
   println(strings)
   println(Traversable.fill(5, 2)("B"))
   //使用函数生成指定数量的元素
   val ints3: Traversable[Int] = Traversable.tabulate(5)(_ * 10)
   Traversable.tabulate(5,2)(_*10 +_)
   println(Traversable.empty[Int])
   val t = Traversable(1 to 10000:_*)
   t.par
  }
}

