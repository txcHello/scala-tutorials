package scala.learn.puzzle

/**
 * @Author Administrator
 * @Date 2022/10/6 14:48
 * @Version 1.0
 *          Desc:
 *          初始化变量
 */
object Chapter2Demo {
  def main(args: Array[String]): Unit = {

    var MONTH = 12  ; var DAY= 24
    var (hour,minute,second) = (12,0,0)
    /**
     * 多变量赋值是基于模式匹配的，而在一个模式匹配中，以大写字母开头的变量有着特别的含义：它们是静态标识符 。
     * 按照定义，在模式匹配时绝不会给静态标识符赋值。*
     */
   // var (HOUR,MINUTE,SECOND) = (12,0,0) 会发生编译错误,
   // TheAnswer 为静态标识符 模式匹配可以识别值变量

    val TheAnswer = 20
    def  checkGuess(guess:Int) = guess match {
      case TheAnswer => "you guess is correct"
      case _ =>  "try again"
    }
    val theAnswer = 20
    def  checkGuess1(guess:Int) = guess match {
      //·· 可以将值 设置为静态标识符
      case `theAnswer` => "you guess is correct"
      case _ =>  "try again"
    }
    println(checkGuess(21))
    println(checkGuess1(21))


   // val HOUR = 12 ;  val MINUTE,SECOND = 0
    //var (HOUR,MINUTE,SECOND) = (12,0,0)
    val HOUR = 13 ;  val MINUTE,SECOND = 0
    var (HOUR,MINUTE,SECOND) = (12,0,0)

  }

}
