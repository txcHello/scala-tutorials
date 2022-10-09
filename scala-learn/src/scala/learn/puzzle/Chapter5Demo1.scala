package scala.learn.puzzle

/**
 * @Author Administrator
 * @Date 2022/10/7 20:16
 * @Version 1.0
 *          Desc:
 */
object Chapter5Demo1 {


  def main(args: Array[String]): Unit = {
    val i: Int = sumSize(Seq(Vector("a"), List("b", "c"), Array("d", "e", "f")))
    println(sumSize(List(Set(1, 2), List(3, 4))))   //4
    println(sumSize(Set(List(1, 2), Set(3, 4))))    //2

    println(sumSize1(List(Set(1, 2), List(3, 4))))   //4
    println(sumSize1(Set(List(1, 2), Set(3, 4))))    //2

  }

  def sumSize(collection:Iterable[Iterable[_]]):Int={
    collection.map(_.size).sum
  }
  def sumSize1(collection:Iterable[Iterable[_]]):Int={
    collection.toSeq.map(_.size).sum
  }
  def sumSize2(collection:Iterable[Iterable[_]]):Int={
    collection.foldLeft(0){
      (sumOfsize,collection)=>{sumOfsize+ collection.size}
    }
  }
}
