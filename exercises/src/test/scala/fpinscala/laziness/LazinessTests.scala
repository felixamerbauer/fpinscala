package fpinscala.laziness

import org.scalatest.FunSuite
import org.scalatest.Matchers._

class LazinessTests extends FunSuite {
  test("5.1 Stream.toList") {
    Empty.toList shouldEqual Nil
    Stream(1).toList shouldEqual List(1)
    Stream(1, 2, 3).toList shouldEqual List(1, 2, 3)
  }

  test("5.2 Stream.take") {
    an[IllegalArgumentException] should be thrownBy Stream(1,2).take(3)
    Stream(1).take(1).toList shouldEqual Stream(1).toList
    Stream(1, 2, 3).take(2).toList shouldEqual Stream(1, 2).toList
  }
}
