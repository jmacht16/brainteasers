/**
  * Created by Jesse Macht on May 25, 2018
  * Tests to make sure the solutions to Problems99 problem_set_4 are correct!
  */

package TestProblems99

import Problems99.ProblemSet4._
import org.scalatest._

class TestSet4 extends FlatSpec with Matchers{

  def testReturnListFilteredByIndexAsMap(): Unit = {
    val myMainList = List(1,2,3,4,5,6,7,8,9,10)
    val myAlphaList = List("A", "B", "C", "D", "E", "F", "G", "H")
    "ReturnListFilteredByIndexAsMap" should "return a Map where the key is the index from a list, and the value is the value at that index in the list" in {
      returnListFilteredByIndexAsMap(myMainList, List(0,1,2,3)) should be(Map(0->1, 1->2, 2->3, 3->4))
      returnListFilteredByIndexAsMap(myMainList, List(3,4,6,7)) should be(Map(3 -> 4, 4 -> 5, 6 -> 7, 7 -> 8))
      returnListFilteredByIndexAsMap(myAlphaList, List(2,4,6,7)) should be(Map(2->"C", 4-> "E", 6->"G", 7-> "H"))
    }
    it should "throw a NoSuchElementException when an index passed in is outside of the indexes in the main list" in {
      a [NoSuchElementException] should be thrownBy {
        returnListFilteredByIndexAsMap(myMainList, List(-4))
        returnListFilteredByIndexAsMap(myMainList, List(3,4,6,100))

      }
    }
  }

  def testReturnMapInverted():Unit = {
    val myMap: Map[Any, Any] = Map("A"-> 1, "B"-> 2, "C"->3)
    val myOtherMap: Map[Any, Any] = Map(1-> 7, 2-> "Z", 3-> "gocart")
    val myOtherFinal = myOtherMap.updated(4,  "gocart")
    "Return Inverted Map " should "Take a map an invert it's keys and values" in {
      returnMapInverted(myMap) should be(Map(1->"A", 2-> "B", 3-> "C"))
      returnMapInverted(myOtherMap) should be(Map(7->1, "Z"->2, "gocart"-> 3))
    }
    it should "return a map inverted, with the final instance of the key value pair in the map which is duplicated holding the key value pair in the result" in {
      returnMapInverted(myOtherFinal) should be(Map(7->1, "Z"->2, "gocart"-> 4))
    }

  }

  def testReturnListsOfLikeValuesIndexes(): Unit = {
    val myMapOfThings: Map[Any, Any] = Map(1-> 3, 2-> 3, 3-> 3, 4-> 6, 5-> 6, 6-> 6)
    val myOtherMapOfThings: Map[Any, Any] = Map(1-> "ferrari", 2-> "ford", 3-> "lamborghini", 4-> "ferrari", 5-> "lamborghini", 6-> "ford")
    "return lists of like values indexes" should "return a list of lists where the sub-lists are the keys of values that are like" in {
      returnListsOfLikeValuesIndexes(myMapOfThings) should be(Set(Set(1,2,3), Set(4,5,6)))
      returnListsOfLikeValuesIndexes(myOtherMapOfThings) should be(Set(Set(1,4), Set(2, 6), Set(3,5)))
    }
  }
  testReturnListFilteredByIndexAsMap()
  testReturnMapInverted()
  testReturnListsOfLikeValuesIndexes()


}
