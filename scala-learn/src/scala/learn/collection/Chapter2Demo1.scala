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
object Chapter2Demo1 {
  def main(args: Array[String]): Unit = {

    //初始化 traversable
    val traversable: Traversable[Int] = List(1, 23, 4, 6).toTraversable
    val traversable1: Traversable[Int] = TreeSet(1, 2, 3, 4).toTraversable
    val traversable2: Traversable[(String, Int)] = HashMap("a" -> 97, "b" -> 98, "c" -> 99).toTraversable
    val traversable3: Traversable[Char] = "hello".toTraversable
    val t5 :Traversable[Int]=List(12,3,435,6)
    //通过伴生对象
    val ints = Traversable(2, 3, 4, 5)
    //集合的静态类型和类型擦除 scala的参数类型在编译时被擦除，可以通过TypeTag类保存用户的编译时的类型信息
    def getTypeTag[T: ru.TypeTag](obj:T) =ru.typeTag[T]
    val xs:Iterable[Int]=List(1,2,3,45)
    val name: String = xs.getClass.getName
    println(getTypeTag(xs).tpe)

    println(A[String].isInstanceOf[A[String]]) //true
    println(A[String].isInstanceOf[A[Int]]) //尽管静态类型不同，但是结果还是true
    println(getTypeTag(A[String]).tpe == getTypeTag(A[Int]).tpe)

    println(ru.typeOf[A[String]]==ru.typeOf[A[String]])

    ints.foreach(x=>x*x)
    ints.foreach(println)
    ints.foreach(println(_))
    ints.foreach(x=>println(x+3))

    //平展Traversable 实例
    val tr  = Traversable(Traversable(1, 2, 3), Traversable(2, 3, 4), Traversable(5, 6, 7, 8))
    val flatten: Traversable[Int] = tr.flatten
    println(flatten)
    println(flatten.isInstanceOf[Traversable[Int]])
    val tr1  = Traversable(Traversable(Traversable(2,2,3,4), 2, 3), Traversable(2, 3, 4), Traversable(5, 6, 7, 8))
    val flatten1: Traversable[Any] = tr1.flatten
    println(flatten1) //只能平展第一层
    val tr2  = Traversable(Traversable(3123124l, 13213l, 3l), Traversable(2, 3, 4), Traversable(5, 6, 7, 8)) // 不同类型输出为共同父类
    val flatten2: Traversable[AnyVal] = tr2.flatten
    //集合转置
    val  matrix = Traversable(Traversable(1, 2, 3), Traversable(4, 5, 6), Traversable( 7, 8, 9))
    val transpose: Traversable[Traversable[Int]] = matrix.transpose
    println(transpose)
    //unzip 一个Traversable,像一个拉链操作，将一个结合分层两个部分
    val t1 = Traversable( "a" -> 97, "b" -> 98, "c" -> 99)
    val (a,b) = t1.unzip
    println(a)
    println(b)

    //显示传递转换函数
    val t2 = Traversable("A_1","B_2","C_3")
    val tuple: (Traversable[Char], Traversable[Int]) = t2.unzip { x => (x(0), x.substring(2).toInt) }
    println(tuple)
    val (c,d): (Traversable[Char], Traversable[Int]) = t2.unzip { x => (x(0), x.substring(2).toInt) }
    println(c)
    println(d)
    //提供隐式转换函数
    implicit def  asPair(x:String)= (x(0), x.substring(2).toInt)
    val unzip: (Traversable[Char], Traversable[Int]) = t2.unzip


   import  scala.reflect.NameTransformer._
    val  pos ="~=<>!@#$%^&*()_+|/-:\\?"
     pos.map { x =>  x -> encode(x.toString) }.foreach(println)
    //获取movies的类型参数
    def getInnerType[T](t: Traversable[T])(implicit  tag:ru.TypeTag[T]) = tag.tpe.toString

    //连接两个Traverable 到新的一个Traverable

    val movieNames = Traversable("小王子","万里归途","海绵宝宝")
    val movieIds=   HashSet(313123,4242,3,5353)
    val moviesAndIds: Traversable[Any] = movieNames ++ movieIds
    println(moviesAndIds.getClass)
    println(getInnerType(moviesAndIds))
    val idsAndNames: HashSet[Any] = movieIds ++ movieNames
    println(idsAndNames)
    println(idsAndNames.getClass)
    println(getInnerType(idsAndNames))

    //Traversable 的 ++ 方法 结果类型与左边的类型保持一致
    // A ++: B   相当于  B + A

    //高效连接   todo 不了解
    val result : mutable.Traversable[Int] = mutable.Traversable.concat(Traversable(1 to 3:_*), Traversable(4 to 5: _*), Traversable(6 to 8: _*))

    val traversable4: Traversable[Int] = result.toTraversable


  }


}
case  class A[T]()