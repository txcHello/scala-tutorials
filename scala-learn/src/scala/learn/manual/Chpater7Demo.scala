package scala.learn.manual

import scala.collection.mutable

/**
 * @Author Administrator
 * @Date 2022/10/3 15:12
 * @Version 1.0
 *          Desc:
 */
object Chpater7Demo {
  def main(args: Array[String]): Unit = {
    val nums = collection.mutable.Buffer(1)
    for(i <- 1 to 20){
      nums += i
    }
    println(nums)
    val  nums1 = collection.mutable.Buffer[Int]()
    for(i <- 1 to 10) nums += i
    println( nums1)

    nums1.toList //将可变的缓冲区变成不可变列表

    //从不可变集合变成 可变集合
    val m = Map("Apple" -> 987,"mSFt"->40)
    val buffer: mutable.Buffer[(String, Int)] = m.toBuffer
    val b = Set.newBuilder[String]

  }

}
