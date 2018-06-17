/**
  * Created by Jesse Macht on June 10, 2018
  * Tests to make sure the solutions to ProblemSet5 are correct!
  */

package TestProblems99

import Problems99.ProblemSet5._
import org.scalatest._

class TestSet5 extends FlatSpec with Matchers {

  "Decode" should "decode a run-length encoded list" in {
    val listA = List((2, 'g), (1, 'r), (3, 'e), (2, 'a), (3, 't))
    decode(listA) should be (List('g, 'g, 'r, 'e, 'e, 'e, 'a, 'a, 't, 't, 't))

    val listB = List((2, "beep"), (2, "boop"), (3, 1234))
    decode(listB) should be (List("beep", "beep", "boop", "boop", 1234, 1234, 1234))
  }
  it should "throw a NoSuchElementException if the list is empty" in {
    a[NoSuchElementException] should be thrownBy{
      decode(List())
    }
  }

  "Encode Direct" should "run-length encode a list" in {
    val listA = List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)
    encodeDirect(listA) should be (List((4,'a), (1,'b), (2,'c), (2,'a), (1,'d), (4,'e)))

    val listB = List("four", "four", "four", "four", "two", "two", "one")
    encodeDirect(listB) should be (List((4, "four"), (2, "two"), (1, "one")))
  }
  it should "throw a NoSuchElementException if the list is empty" in {
    a[NoSuchElementException] should be thrownBy{
      encodeDirect(List())
    }
  }

  "Duplicate" should "duplicate the elements of a list" in {
    val listA = List('a, 'b, 'c, 'c, 'd)
    duplicate(listA) should be (List('a, 'a, 'b, 'b, 'c, 'c, 'c, 'c, 'd, 'd))

    val listB = List(4, 5, 6, 6, 2, 3)
    duplicate(listB) should be (List(4, 4, 5, 5, 6, 6, 6, 6, 2, 2, 3, 3))
  }
  it should "throw a NoSuchElementException if the list is empty" in {
    a[NoSuchElementException] should be thrownBy{
      duplicate(Nil)
    }
  }

  "Duplicate N" should "duplicate the elements of a list N times" in {
    val listA = List('a, 'b, 'c, 'c, 'd)
    duplicateN(3, listA) should be (List('a, 'a, 'a, 'b, 'b, 'b, 'c, 'c, 'c, 'c, 'c, 'c, 'd, 'd, 'd))

    val listB = List(1, 9 ,6, 5)
    duplicateN(4, listB) should be (List(1, 1, 1, 1, 9, 9, 9, 9, 6, 6, 6, 6, 5, 5, 5, 5))
  }
  it should "throw a NoSuchElementException if the list is empty" in {
    a[NoSuchElementException] should be thrownBy{
      duplicateN(6, List())
    }
  }
  it should "throw an IllegalArgumentException if the N is less than 0" in {
    a[IllegalArgumentException] should be thrownBy{
      duplicateN(-1, List(1, 2, 3))
    }

    a[IllegalArgumentException] should be thrownBy{
      duplicateN(0, List(1, 2, 3))
    }
  }

  "Drop" should "drop every Nth element of a list" in {
    val listA = List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)
    drop(3, listA) should be (List('a, 'b, 'd, 'e, 'g, 'h, 'j, 'k))
  }
  it should "throw an IndexOutOfBoundsException if the index greater than list length " in {
    a[IndexOutOfBoundsException] should be thrownBy{
      drop(5, List(2))
    }
  }
  it should "throw a NoSuchElementException if the list is empty" in {
    a[NoSuchElementException] should be thrownBy {
      drop(1, List())
    }
  }

  "Split" should "split a list into two parts, with the integer provided identifying the length of the first list" in {
    val listA = List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)
    split(3, listA) should be (List('a, 'b, 'c), List('d, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
  }
  it should "throw an IndexOutOfBoundsException if the index is greater than the list length" in {
    a[IndexOutOfBoundsException] should be thrownBy {
      split(5, List(2))
    }
  }
  it should "throw a NoSuchElementException if the list is empty" in {
    a[NoSuchElementException] should be thrownBy {
      split(2, List())
    }
  }

}