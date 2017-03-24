package fpinscala.errorhandling

import org.scalatest.FunSuite
import org.scalatest.Matchers._

class ErrorHandlingTests extends FunSuite {
  test("Option.map") {
    Some(2).map(_ * 3) shouldBe Some(6)
    None.map(_.toString) shouldBe None
  }

  test("Option.getOrElse") {
    Some(2).getOrElse(1) shouldBe 2
    None.getOrElse(1) shouldBe 1
  }

  test("Option.flatMap") {
    Some(2).flatMap(e => Some(3 * e)) shouldBe Some(6)
    (None: Option[Int]).flatMap(e => Some(3 * e)) shouldBe None
    Some(2).flatMap(_ => None) shouldBe None
    None.flatMap(_ => None) shouldBe None
  }

  test("Option.orElse") {
    Some(1) orElse Some(2) shouldBe Some(1)
    Some(1) orElse None shouldBe Some(1)
    None orElse Some(2) shouldBe Some(2)
    None orElse None shouldBe None
  }

  test("Option.filter") {
    Some(4).filter(_ % 2 == 0) shouldBe Some(4)
    Some(5).filter(_ % 2 == 0) shouldBe None
    (None: Option[Int]).filter(_ % 2 == 0) shouldBe None
  }

  test("Option.variance") {
    Option.variance(Seq(1, 2, 3, 4, 5)) shouldBe Some(2.0D)
  }

  test("Option.map2") {
    val s: Option[Int] = Some(2)
    val n: Option[Int] = None
    Option.map2(s, s)(_ * _) shouldBe Some(4)
    Option.map2(s, n)(_ * _) shouldBe None
    Option.map2(n, s)(_ * _) shouldBe None
    Option.map2(n, n)(_ * _) shouldBe None
  }

  test("Either.map2") {
    type E = Either[String, Int]
    val l: E = Left("error")
    val r: E = Right(5)
    r.map2(r)(_ * _) shouldBe 25
    r.map2(l)(_ * _) shouldBe l
    l.map2(r)(_ * _) shouldBe l
    l.map2(l)(_ * _) shouldBe l
  }
}
