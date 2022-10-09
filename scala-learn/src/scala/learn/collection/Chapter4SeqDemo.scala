
package scala.learn.collection

import scala.+:
import scala.util.Random

/**
 * @Author Administrator
 * @Date 2022/10/8 14:37
 * @Version 1.0
 *   Seq特质：代表按照一定顺序排序的元素序列，序列是可迭代的集合，他包含可重复元素并且元素顺序关系是确定的。
 *    Seq有两个重要特质，
 *    IndexSeq ： 适合快速的随机访问
 *    LinearSeq ：可以快速方位 tail head操作
 *
 *
 */
object Chapter4SeqDemo {

  def main(args: Array[String]): Unit = {
    //
    val ints = Seq(1 to 5: _*)
    println(ints)
    println(ints.indices) //返回序列的索引集合
    println(ints.size) //获得序列的长度   Traversable 方法
    println(ints.length) //获得序列的长度

    println(ints.lengthCompare(-10)) //
    println(ints.lengthCompare(5))
    println(ints.lengthCompare(3))
    println(ints.lengthCompare(10))

    println(ints(2))
    println(ints.apply(2))
    println(ints.indexOf(3))
    ints.indexOf(3,4)
  //寻找满足条件的元素索引
  val ints1 = Iterable(1 to 20: _*)
    println(ints.indexWhere(x => (x % 2 == 0) && x > 5)) //返回满足条件集合的第一条索引
    println(ints.lastIndexWhere(x => (x % 2 == 0) && x > 5)) //返回满足条件集合的最后一条索引
    //增加元素到序列中
    println(1 +: ints)
    println(ints :+ 3)
    println(ints.padTo(3, 5))
    println(ints.padTo(21,6))
    //替换序列中的元素
    val ints2 = Seq(1 to 20: _*)

    println(ints2.patch(3, Seq(20, 32, 23), 3))//从第3个位置替换序列，删除几个元素
    println(ints2.updated(2, 200))
    // 排序
    val ints3 = Seq(3, 4, 532, 4, 23, 53421, 43)
    println(ints3.sorted)
    println(ints3.sortBy(x => x.toString.length))
    println(ints.sortWith(_-_<0))
    //反转一个序列
    val ints4: Seq[Int] = Seq.fill(5)(Random.nextInt(100))
    val reverse: Seq[Int] = ints4.reverse
    println(ints4.reverseMap(_ + 10))
    println(reverse)
    println(ints4.reverseIterator.next())
    //IndexSeq  和 LinearSeq



  }

}
