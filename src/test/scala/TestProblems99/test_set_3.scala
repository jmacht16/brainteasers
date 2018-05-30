/**
  * Created by Jesse Macht on May 25, 2018
  * Tests to make sure the solutions to Problems99 problem_set_3 are correct!
  */

package TestProblems99

import Problems99.problem_set_3._
import org.scalatest._

class test_set_3 extends FlatSpec with Matchers {

  // Packer
  "Pack" should "return a list of lists, each one containing consecutive elements from the input list" in {
    val listA = List(1, 1, 1, 3, 3, 9, 9, 9, 9)
    pack(listA) should be(List(List(1, 1, 1), List(3, 3), List(9, 9, 9, 9)))

    val listB = List("word", "word", "thing", 1, 2, 2, 3, 4)
    pack(listB) should be(List(List("word", "word"), List("thing"), List(1), List(2, 2), List(3), List(4)))

    val listC = List(7, 7, 7, 7, 7, 7, 7)
    pack(listC) should be(List(List(7, 7, 7, 7, 7, 7, 7)))
  }
  it should "throw NoSuchElementException if the list is empty" in {
    a[NoSuchElementException] should be thrownBy {
      pack(List())
    }
  }

  // Encoder
  "Encode" should "compress consecutive duplicates into tuples of (N, E) where N is number of duplicates of element E" in {
    val listA = List(1, 1, 1, 3, 3, 9, 9, 9, 9)
    encode(listA) should be(List((3, 1), (2, 3), (4, 9)))

    val listB = List("word", "word", "thing", 1, 2, 2, 3, 4)
    encode(listB) should be(List((2, "word"), (1, "thing"), (1, 1), (2, 2), (1, 3), (1, 4)))

    val listC = List(7, 7, 7, 7, 7, 7, 7)
    encode(listC) should be(List((7, 7)))
  }
  it should "throw NoSuchElementException if the list is empty" in {
    a[NoSuchElementException] should be thrownBy {
      encode(List())
    }
  }

  // Encoded modified
  "EncodeModified" should "compress consecutive duplicates in tuples of (N, E), but elements with no duplicates are copied directly into the list" in {
    val listA = List(1, 1, 1, 3, 3, "a", "a", "C", 9, 9, 9, 9)
    encodeModified(listA) should be(List((3, 1), (2, 3), (2, "a"), "C", (4, 9)))

    val listB = List("word", "word", "thing", 1, 2, 2, 3, 4)
    encodeModified(listB) should be(List((2, "word"), "thing", 1, (2, 2), 3, 4))

    val listC = List(7, 7, 7, 7, 7, 7, 7)
    encodeModified(listC) should be(List((7, 7)))
  }
  it should "throw NoSuchElementException if the list is empty" in {
    a[NoSuchElementException] should be thrownBy {
      encodeModified(List())
    }
  }

}