/**
  * Created by Jesse Macht on May 25, 2018
  */

package Problems99

object problem_set_4 {
  /**
    * This function takes 2 lists. One main list, and a list of indexes to be filtered.
    * It returns a Map where the key is the index, and the value is the value in the list ls.
    * Do this with one line for the happy path, and without any helper vals or vars.
    * If the index specified is out of bounds, then raise a NoSuchElementException
    *
    */
  def returnListFilteredByIndexAsMap[A](ls: List[A], indexes: List[Int]): Map[Int, A] = {
    try {indexes.map(i => i -> ls(i)).toMap}
    catch {case err: IndexOutOfBoundsException => throw new NoSuchElementException()}
  }


  /**
    * This function takes a map (Map[A, A]) and returns the Map, with keys and values reversed.,
    * If a value is duplicated, then the resulting value in the map should be of the last key of the duplicated element.
    * You should be able to do this in one line.
    * You may assume that you are given a non-empty map of type collections.immutable.Map
    */
  def returnMapInverted[A](m: Map[A, A]): Map[A, A] = {
    m.map(values => values._2 -> values._1)
  }

  /**
    * Given a Map, return a Set of Sets where the Sets are of keys where the values in the original map are the same.
    * Example
    * val z = Map(1-> 4, 2->4, 3-> 5, 4->5) => Set(Set(1,2),Set(3,4))
    * See the test cases for more examples.
    */
  def returnListsOfLikeValuesIndexes[A](m: Map[A, A]): Set[Set[A]] = {
    val t = m.map(k => k._2).toSet
    val revMap =  m.toList.map(values => (values._2, values._1))
    t.map(i => revMap.filter(n => n._1 == i).map(_._2).toSet)
  }
}
