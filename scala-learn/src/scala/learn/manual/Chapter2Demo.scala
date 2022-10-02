package scala.learn.manual

/**
 * @Author Administrator
 * @Date 2022/9/29 21:38
 * @Version 1.0
 *          Desc:
 *          字面量(literal)或字面数据   是直接出现再源代码的数据，如数字5, 字母'A'和文本‘hello world’
 *          值(value) 是一个不可变的，有类型的存储单元， 可以在定义值时为它指定数据，不过不允许重新赋值
 *          变量(variable) 是一个可变的，有类型的存储单元。可以在定义变量时为它指定数据，而且可以在任何时间重新赋值
 *           计算机科学里，变量是通常表示一个唯一的标识，对应一个已分配和保留的内存空间，既可以赋值，也可以从空间中获取值，内存空间是动态的或可变的
 *           scala中，按照惯例，值优先于变量，因为
 *           1.值可以为源代码带来稳定性和可预测性。
 *           2.代码段指定值时，直至代码段结束值都不会改变，方便阅读和调试
 *           3.有些数据在应用的整个生命周期都可用，对于并发或多线程代码访问，处理这些数据，不可变的值会更稳定，而且与可能会被意外修改的可变数据*
 *    *
 *          类型(type) 是处理数据的种类，对数据的定义分类。scala中的所有数据都对应一个特定的类型，所有SCAlA类型都定义为包含方法的类，方法来处理这些数据
 *          数值数据类型:Int Double
 *          非数值数据类型:String
 *          *          *
 *          *          *
 *
 *        *          *
 */
object Chapter2Demo {
  def main(args: Array[String]): Unit = {
     //值定义
     val  x: Int = 5
     val  y: Int = x * 2
     val   res3:Int = x*y
    //变量
    var a:Double = 2.72
        a = 355.0/113.3
       // a = "String"  //编译错误,类型必须匹配
        a =23
       var b :Int =  21   //可以进行类型转换
        // b = 2.2   //类型不匹配
    //类型
    val  c :Byte = 10
    val  s :Short =c
    val  i :Int =s
    val d :Double=i    //类型可以向高级转换，不允许高级向低级转换
    //字面量类型记法
    val  anInt =5
    val  yellowRgb = 0xffff00
    val  anLong = 100l
    val pi = 3.1415926
    //String 字符串
    val  hello ="hello there"
    val signature ="With Regards, \n your friend"
      // 使用 相等运算符 (==) 比较两个String的值,与java不同 比较对象引用的相等性
    val greeting ="hello," +"world"
    val  matched = (greeting == "hello,world")
    println(matched)
    val theme = "Na" *16 +"Batman!"
    println(theme)
    val greetingNew =
      """ She suggested reformatting the file
        |by replacing tabs (\t) with newLines (\n);
        | "Why do that ? " ,he asked. """.stripMargin

    println(greetingNew)
    //字符串内插
    val approx  =355/133f
    println("pi,using 355/113, is about "+ approx +".")
    println(s"pi,Using 355/113,is about $approx .")
    println(s"pi,Using 355/113,is about ${approx +3} .")
    val value = f"hello,${approx}%.5f"
    println(value)

    //正则表达式  我时字符和标点符号组成的字符串,表示一个搜索模式，

    //Scala类型体系
    /**
     * Nothing 是所有类型的一个子类型， 目的是为那些影响程序流的操作提供一个兼容的返回类型，例如return 返回值类型就是Nothing
     * Null 是所有 AnyRef类型的子类型，目的是为了给关键字null提供一个类型
     * Unit 类型 不是一个指示数据的类型，而是指示没有数据。字面量为 （）*
     */
    //类型的操作
    val l: Long = 5.asInstanceOf[Long]  //将一个值转换为指定类型的值，如果这个值与指定的类型不兼容,会报错
    val clazz: Class[_ <: Double] = (7.0 / 5).getClass  //返回值的类型
    val bool: Boolean = (5.0).isInstanceOf[Float]   //如果值的类型和指定的类型相同返回true
    val byte: Byte = 20.toByte  //转换函数，将一个值转换为一个兼容的值
    val string: String = 3.toString  //将值转为字符串

    //tuple 元组   是一个包含两个或多个值的有序容器,所有这些值可以有不同的类型。作为一个多个值的容器
    val  info = (1,"kevin","男")

    val tuple: (String, String) = "red" -> "oxff0000" //二元组  利用关系操作符 -> 进行创建


  }

}
