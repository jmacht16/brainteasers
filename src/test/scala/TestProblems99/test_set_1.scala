/**
  * Created by Jesse Macht on May 25, 2018
  * Tests to make sure the solutions to Problems99 problem_set_1 are correct!
  */

package TestProblems99

import Problems99.problem_set_1._
import org.scalatest._

class test_set_1 extends FlatSpec with Matchers {

  // Return last element of list
  "Last Element of List" should "return the last element of a list of any" in {
    val myList = List(1,2,3,4,5,6)
    returnLastElementOfList(myList) should be (6)
    val myOtherList = List(6,5,4,3,2,1,0)
    returnLastElementOfList(myOtherList) should be (0)
  }
  it should "throw No Such Element Exception if the list is empty" in {
    val myEmptyList = List()
    a [NoSuchElementException] should be thrownBy {
      returnLastElementOfList(List())
    }
  }

  // Penultimate
  "Penultimate Element of List" should "return the second-to-last of the list" in {
    val myList = List(1,2,3,4,5,6)
    returnPenultimateElementOfList(myList) should be (5)
    val myOtherList = List(1,5,3,9,9,8,4)
    returnPenultimateElementOfList(myOtherList) should be (8)
  }
  it should "throw No Such Element Exception if the list is empty." in {
    val myEmptyList = List()
    a [NoSuchElementException] should be thrownBy {
      returnPenultimateElementOfList(myEmptyList)
    }
  }

  // Kth element of list
  "Kth Element of List" should "return the kth element of a given list." in {
    val myList = List(1,2,3,4,5,6)
    returnKthElement(4, myList) should be (5)
    val myOtherList = List(1,5,3,9,9,8,4)
    returnKthElement(0, myOtherList) should be (1)
  }
  it should "throw No Such Element Exception if the list is empty." in {
    val myEmptyList = List()
    a [NoSuchElementException] should be thrownBy {
      returnKthElement(5,myEmptyList)
    }
  }

  // Number of elements
  "Testing Length of List" should "return the length of the list." in {
    val myList = List(1,2,3,4,5,6)
    returnNumElementsOfList(myList) should be (6)
    val myOtherList = List(1,5,3,9,9,8,4)
    returnNumElementsOfList(myOtherList) should be (7)
  }

  // Reversing list
  "Reversing a list" should "return a list in reverse order." in {
    val myList = List(1,2,3,4,5,6)
    returnListReversed(myList) should be (List(6,5,4,3,2,1))

    val myOtherList = List(1,5,3,9,9,8,4)
    returnListReversed(myOtherList) should be (List(4,8,9,9,3,5,1))
  }
  it should "Throw a No Such Element Exception if the list is empty." in {
    val myEmptyList = List()
    a [NoSuchElementException] should be thrownBy {
      returnListReversed(myEmptyList)
    }
  }

}
