/**
  * Created by Jesse Macht on May 25, 2018
  * Tests to make sure the solutions to Problems99 problem_set_2 are correct!
  */

package TestProblems99

import Problems99.problem_set_2._
import org.scalatest._

class test_set_2 extends FlatSpec with Matchers {

  // Pallindrome
  "ReturnIsListPallindrome" should "return a Boolean reflecting whether or not the list is in fact a pallindrome." in {
    val myList = List(1, 2, 3, 4, 5, 4, 3, 2, 1)
    isListPallindrome(myList) should be(true)
    val myOtherList = List(1, 2, 31, 2, 5, 3, 23)
    isListPallindrome(myOtherList) should be(false)
    val myFinalList = List("a", "b", "c", "d", "c","b", "a")
    isListPallindrome(myFinalList) should be(true)
  }
  it should "throw No Such Element Exception if the list is empty" in {
    a[NoSuchElementException] should be thrownBy {
      isListPallindrome(List())
    }
  }

  // Flatten nested list
  "FlattenNestedList" should "return a list which has been flattened " in {
    val myList = List(List(1,2,3), List(3,4,5), List(4,5,6))
    flattenNestedLists(myList) should be (List(1,2,3,3,4,5,4,5,6))
    val myOtherList = List(List(3,2), List(1,2,5))
    flattenNestedLists(myOtherList) should be (List(3,2,1,2,5))
  }
  it should "should throw a NoSuchElementException" in {
    a [NoSuchElementException] should be thrownBy {
      flattenNestedLists(List())
    }
  }

  // Eliminate consecutive duplicates
  "eliminateConsecutiveDuplicates" should "return a list which has removed sequential duplciates from a list" in {
    val myList = List(1,1,2,2,2,4,3,5,6)
    eliminateConsecutiveDuplicates(myList) should be (List(1,2,4,3,5,6))
    val myOtherList = List("a", "b", "c", "c", "d", "d", "e", "e", "e", "e", "e", "e", "e")
    eliminateConsecutiveDuplicates(myOtherList) should be (List("a", "b", "c", "d", "e"))
  }
  it should "throw a NoSuchElementException" in {
    a [NoSuchElementException] should be thrownBy{
      flattenNestedLists(List())
    }
  }

}
