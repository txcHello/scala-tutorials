package scala.learn.puzzle

/**
 * @Author Administrator
 * @Date 2022/10/6 14:48
 * @Version 1.0
 *          Desc:
 *          *继承
 *
 *          以下规则控制 val②的初始化和重载行为 ：
 *           1. 超类会在子类之前初始化 ：
 *           2. 按照声明的顺序对成员初始化：
 *           3. 当一个 val 被重载时，只能初始化一次：
 *           4. 与抽象 val 类似，重载的 val 在超类构造期间会有一个缺省的初始值。*          *
 */
object Chapter4Demo1 {
  def main(args: Array[String]): Unit = {
    val g = new G()
  }

}

trait E {
  val foo: Int
 // val bar = 10
  val bar = 10
  println("In E : foo: " + foo + ",bar :" + bar )
}

class F extends E {
  override val foo: Int = 25
  println("In F : foo: " + foo + ",bar :" + bar)
}

class G  extends F{
  override val bar: Int =   99
  println("In G : foo: " + foo + ",bar :" + bar)
}


