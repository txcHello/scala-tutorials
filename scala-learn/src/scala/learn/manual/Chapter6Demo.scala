package scala.learn.manual

/**
 * @Author Administrator
 * @Date 2022/10/2 13:08
 * @Version 1.0
 *          Desc:
 */
object Chapter6Demo {

  def main(args: Array[String]): Unit = {
    //List

    val names =List("zhangsan","zhaosi","sunwukong")
    val colors =List("green","blue","red","black")
    println(colors.head)
    println(colors.tail)
    println(colors(0))
    for (color<-colors){
      println(color)
    }
    //高阶函数方式
    colors.foreach(x=>{println(x)})
    colors.foreach(println(_))
    colors.foreach(println)
    //set
    val  unique =Set(10,23,43,1223,23,23,23,44)
    println(unique)
    println(unique.reduce(_ + _))

    //map
    val  colorMap =("red"->0xfff23,"blue"-> 0xff23)
    //循环遍历
    val  numbers = List(32,95,14,23,34)
    var  i =numbers
    while (i.isEmpty){
      println(i.head)
      i =i.tail
    }
    //递归遍历
  println("*"*20)
    //visit(numbers)
  visit1(numbers)
    val  numbers1 =1::2::3::Nil
    println(numbers1)
    val  numbers2 = Nil.::(1).::(2)
    println(numbers2)
  }

  def visit(i:List[Int]):List[Int] = {
    if (i.isEmpty){println(i.head+",")}
    visit(i.tail)
  }

  //什么意思
  def visit1(i:List[Int]){
    if(i.size>0){
      println(i.head+",") ;
      visit1(i.tail)
    }
  }



}
