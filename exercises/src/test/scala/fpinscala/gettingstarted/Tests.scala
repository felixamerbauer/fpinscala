package fpinscala.gettingstarted

import fpinscala.gettingstarted.MyModule.fib
import fpinscala.gettingstarted.PolymorphicFunctions.isSorted
import org.scalatest.FunSuite
import org.scalatest.Matchers._

class Tests extends FunSuite {
  test("fib") {
    Seq(0, 1, 1, 2, 3, 5, 8) shouldEqual (0 to 6).map(fib)
  }

  test("isSorted") {
    isSorted[String](Array("a", "b", "c"), _ > _) shouldBe true
    isSorted[String](Array("c", "b", "a"), _ > _) shouldBe false
    isSorted[Int](Array(1, 2, 3, 99, 100), _ > _) shouldBe true
    isSorted[Int](Array(1, 2, 3, 5, 4), _ > _) shouldBe false
  }
}
