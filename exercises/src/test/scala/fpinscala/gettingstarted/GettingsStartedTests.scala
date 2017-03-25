package fpinscala.gettingstarted

import fpinscala.gettingstarted.MyModule.fib
import fpinscala.gettingstarted.PolymorphicFunctions.{isSorted, curry, uncurry, compose}
import org.scalatest.FunSuite
import org.scalatest.Matchers._

class GettingsStartedTests extends FunSuite {
  test("2.1 fib") {
    Seq(0, 1, 1, 2, 3, 5, 8) shouldEqual (0 to 6).map(fib)
  }

  test("2.2 isSorted") {
    isSorted[String](Array("a", "b", "c"), _ > _) shouldBe true
    isSorted[String](Array("c", "b", "a"), _ > _) shouldBe false
    isSorted[Int](Array(1, 2, 3, 99, 100), _ > _) shouldBe true
    isSorted[Int](Array(1, 2, 3, 5, 4), _ > _) shouldBe false
  }

  test("2.3 curry") {
    val f = (a: Int, b: Int) => a + b
    val c: (Int) => (Int) => Int = curry(f)
    c(5)(3) shouldBe 8
  }

  test("2.4 uncurry") {
    val f = (a: Int) => (b: Int) => a + b
    val uc = uncurry(f)
    uc(5, 3) shouldBe 8
  }

  test("2.5 compose") {
    val f = (i: Int) => (i * 5).toString
    val g = (s: String) => (s * 3).map(_.toInt)
    val c = compose(g,f)
    c(4) shouldEqual Seq(1,2,3)
  }
}
