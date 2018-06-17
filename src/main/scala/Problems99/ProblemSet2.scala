/**
  * Created by Jesse Macht on May 25, 2018
  */

package Problems99

object ProblemSet2 {

  /**
    * This function check whether a list is a pallindrome (a sequence that is the same forwards as backwards)
    * It returns that information as a boolean, true or false
    * @param ls => List of Any
    * @return boolean
    */
  def isListPallindrome[A](ls: List[A]): Boolean = (ls.length % 2, ls) match {
    case (1, h :: t) => (ls.dropRight((ls.length - 1) / 2) == ls.reverse.dropRight((ls.length - 1) / 2))//odds
    case (0, h :: t) => (ls.dropRight(ls.length / 2) == ls.reverse.dropRight(ls.length / 2))//evens
    case (_, h :: Nil) => false
    case (_, Nil) => throw new NoSuchElementException
  }
  /**
    * This function takes a list of lists of any and flattens them into a single list of any
    * @param ls => List of List of Any
    * @return List of Any
    */
  def flattenNestedLists[A](ls: List[List[A]]): List[A] = ls match{
    case h :: _ => ls.flatMap(_.toList) // i'm tired  :P
    case Nil => throw new NoSuchElementException
  }
  /**
    * This function takes a list of Any and eliminates sequential duplicates of an element
    * @param ls => List of Any
    * @return List of Any
    */
  def eliminateConsecutiveDuplicates[A](ls: List[A]): List[A] = ls match {
    case h :: Nil => List(h)
    case h :: t => if (h == t.head) {eliminateConsecutiveDuplicates(t)} else h :: eliminateConsecutiveDuplicates(t)
    case Nil => throw new NoSuchElementException
  }

}
