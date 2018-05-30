/**
  * Created by Jesse Macht on May 25, 2018
  */

package Problems99

object problem_set_3 {
  /*
   * (**) Pack consecutive duplicates of list elements into sublists.
   * If a list contains repeated elements they should be placed in separate
   * sublists.
   *
   * Example:
   * scala> pack(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
   * res0: List[List[Symbol]] = List(List('a, 'a, 'a, 'a), List('b), List('c, 'c), List('a, 'a), List('d), List('e, 'e, 'e, 'e))
   */

  def pack[A](ls: List[A]): List[List[A]] = {
    def packer(compact: List[A], acc: List[A]): List[List[A]] = compact match{
      case Nil => List(acc) // we can think of the acc here being lists appended together to make our list of lists using cons
      case h :: t if acc.isEmpty => packer(t, List(h)) // start the recursion - since the first segement of the acc will be empty when it's called, make the first acc list begin with the head of the list
      case h :: t if (h == acc.head) => packer(t, h :: acc) // if the element we're looking at in the list is the same as what's on the current acc, just keep rolling by appending it to the acc and passing the tail
      case h :: t if (h != acc.head) => acc :: packer(t, List(h)) // if the latest head element is not in the acc, we start a new call of packer on the rest of the list and just prepend the previous acc to this call (this is what builds out list of lists)
    }

    if (ls.isEmpty)
      throw new NoSuchElementException
    else
      packer(ls, List())
  }

  /*
   * (*) Run-length encoding of a list.
   * Use the result of the previous problem to implement the so-called run-length
   * encoding data compression method.  Consecutive duplicates of elements are
   * encoded as tuples (N, E) where N is the number of duplicates of the
   * element E.
   *
   * Example:
   * scala> encode(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
   * res0: List[(Int, Symbol)] = List((4,'a), (1,'b), (2,'c), (2,'a), (1,'d), (4,'e))
  */
  def encode[A](ls: List[A]): List[(Int, A)] = {
    pack(ls).map(item => (item.length, item.head))
  }

  /*
   * (*) Modified run-length encoding.
   * Modify the result of problem P10 in such a way that if an element has no
   * duplicates it is simply copied into the result list.  Only elements with
   * duplicates are transferred as (N, E) terms.
   *
   * Example:
   * scala> encodeModified(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
   * res0: List[Any] = List((4,'a), 'b, (2,'c), (2,'a), 'd, (4,'e))
   */
  def encodeModified[A](ls: List[A]): List[Any] = {
    pack(ls).map(item => if (item.length == 1) item.head else (item.length, item.head))
  }

}