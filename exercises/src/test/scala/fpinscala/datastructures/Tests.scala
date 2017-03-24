package fpinscala.datastructures

import org.scalatest.FunSuite
import org.scalatest.Matchers._

class Tests extends FunSuite {
  test("3.1") {
    List.x shouldEqual 3
  }

  test("tail") {
    an[IllegalArgumentException] should be thrownBy List.tail(Nil)
    List.tail(List(1)) shouldEqual Nil
    List.tail(List(1, 2, 3)) shouldEqual List(2, 3)
  }

  test("setHead") {
    an[IllegalArgumentException] should be thrownBy List.setHead(Nil, 0)
    List.setHead(List(1), 2) shouldEqual List(2)
    List.setHead(List(1, 2, 3), 4) shouldEqual List(4, 2, 3)
  }

  test("drop") {
    an[IllegalArgumentException] should be thrownBy List.drop(Nil, 1)
    an[IllegalArgumentException] should be thrownBy List.drop(List(1), 2)
    List.drop(List(1), 1) shouldEqual Nil
    List.drop(List(1, 2, 3, 4), 2) shouldEqual List(3, 4)
  }

  test("dropWhile") {
    List.dropWhile[Int](Nil, _ > 0) shouldEqual Nil
    List.dropWhile[Int](List(1, 2, -3, 4), _ > 0) shouldEqual List(-3, 4)
  }

  test("init") {
    an[AssertionError] should be thrownBy List.init(Nil)
    List.init(List(1)) shouldEqual Nil
    List.init(List(1, 2, 3, 4)) shouldEqual List(1, 2, 3)
  }

  test("length") {
    List.length(Nil) shouldEqual 0
    List.length(List("4")) shouldEqual 1
    List.length(List(1, 2, 3, 4)) shouldEqual 4
  }

  test("foldLeft") {
    List.foldLeft(Nil:List[Int], 0)(_ + _) shouldEqual 0
    List.foldLeft(List(1, 1, 1, 1), 0)(_ + _) shouldEqual 4
    List.foldLeft(List("1", "2", "3", "4"), "")(_ + _) shouldEqual "1234"
  }
}
