/**
  * Created by Jesse Macht on May 25, 2018
  */

package Problems99

object ProblemSet1 {

  def returnLastElementOfList[A](ls: List[A]): A = ls match {
    case h :: Nil => h // only one element in the list, return it
    case h :: t => t.last // anything with a tail, take the last of it
    case Nil => throw new NoSuchElementException // nothing in the list
  }

  def returnPenultimateElementOfList[A](ls: List[A]): A = ls match {
    case h :: List(t) => h // if tail is specifically of type list with one element, return the head
    case h :: t => returnPenultimateElementOfList(t) // if there's more tail, keep going
    case h :: Nil => throw new NoSuchElementException // only one element, no penultimate
    case Nil => throw new NoSuchElementException
  }

  def returnKthElement[A](k: Int, ls : List[A]): A = (k, ls) match { // little different this time, making the two
    case (0, h :: _) => ls.head // k is 0 and there is something in the list
    case (k, _ :: l) => returnKthElement(k-1, ls.tail) // k is not zero and there's still tail left
    case _ => throw new NoSuchElementException
  }

  def returnNumElementsOfList[A](ls: List[A]): Int = {
    def length(acc: Int, ls: List[A]): Int = ls match {
      case h :: t => length(acc + 1, t)
      case Nil => acc
    }
    length(0, ls)
  }

  def returnListReversed[A](ls: List[A]): List[A] = ls match {
    case h :: Nil => List(h) // again, only one element so return it
    case h :: t => ls.reverse
    case Nil => throw new NoSuchElementException
  }

}
