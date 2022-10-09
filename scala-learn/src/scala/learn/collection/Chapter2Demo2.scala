package scala.learn.collection

import java.io
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
object Chapter2Demo2 {
  def main(args: Array[String]): Unit = {
    //利用偏函数筛选元素

    val isEven:PartitialFunction[Int,String]={
      case x if x%2==0 =>  x+" is even"
    }

    //对所有元素应用一个函数，并将结果放入新的Traversable 集合中
   // def map[B](x: (A) => B):Traversable[B]
    val t =Traversable(1,2,34,45,6)
    val ints: Traversable[Int] = t.map(x => x * 2)
    println(ints)
    val s =
      """Builds a new collection  by applying  a  function
        |to  all  elements of  this collect an using  the
        |elements of  the  resulting  collection
        |""".stripMargin
    val tt : Traversable[String] = for (x <- s.split("\r\n")) yield x
    def  getWords(lines:Traversable[String]):Traversable[String]= {
      lines.flatMap(line => line.split("\\W+"))
    }

    val strings: Traversable[String] = getWords(tt)
    println(strings)
    //利用scan 计算Traversable 元素的阶层

    def badFactorial(x:Int):Int ={
      if (x==0) 1 else (x *badFactorial(x-1))
    }


    val inclusives = Traversable(1 to 5:_*)
    val ints1: Traversable[Int] = inclusives.map(x => badFactorial(x))
    println(ints1)
  }


}
trait PartitialFunction[-A,+B] extends ( (A) => B){
  //  def collect[A,B](pf:PartitialFunction[A,B]):Traversable[B]
 // def  map[B](f : (A)=>B):Traversable[B]

}