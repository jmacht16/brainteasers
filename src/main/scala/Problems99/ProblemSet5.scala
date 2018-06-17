/**
  * Created by Jesse Macht on June 10, 2018
  */

package Problems99

object ProblemSet5 {

  /*
   * P12 (**) Decode a run-length encoded list.
   * Given a run-length code list generated as specified in problem P10, construct its uncompressed version.
   * Example:
   * scala> decode(List((4, 'a), (1, 'b), (2, 'c), (2, 'a), (1, 'd), (4, 'e)))
   * res0: List[Symbol] = List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)
   */
  def decode[A](ls: List[(Int, A)]): List[A] = {
    ???
  }

  /*
   * P13 (**) Run-length encoding of a list (direct solution).
   * Implement the so-called run-length encoding data compression method directly. I.e. don't use other methods you've written (like P09's pack); do all the work directly.
   * Example:
   * scala> encodeDirect(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
   * res0: List[(Int, Symbol)] = List((4,'a), (1,'b), (2,'c), (2,'a), (1,'d), (4,'e))
   */
  def encodeDirect[A](ls: List[A]): List[(Int, A)] = {
    ???
  }

  /*
   * P14 (*) Duplicate the elements of a list.
   * Example:
   * scala> duplicate(List('a, 'b, 'c, 'c, 'd))
   * res0: List[Symbol] = List('a, 'a, 'b, 'b, 'c, 'c, 'c, 'c, 'd, 'd)
   */
  def duplicate[A](ls: List[A]): List[A] = {
    ???
  }

  /*
   * P15 (**) Duplicate the elements of a list a given number of times.
   * Example:
   * scala> duplicateN(3, List('a, 'b, 'c, 'c, 'd))
   * res0: List[Symbol] = List('a, 'a, 'a, 'b, 'b, 'b, 'c, 'c, 'c, 'c, 'c, 'c, 'd, 'd, 'd)
   */
  def duplicateN[A](i: Int, ls: List[A]): List[A] = {
    ???
  }

  /*
   * P16 (**) Drop every Nth element from a list.
   * Example:
   * scala> drop(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
   * res0: List[Symbol] = List('a, 'b, 'd, 'e, 'g, 'h, 'j, 'k)
   */
  def drop[A](i: Int, ls: List[A]): List[A] = {
    ???
  }

  /*
   * P17 (*) Split a list into two parts.
   * The length of the first part is given. Use a Tuple for your result.
   * Example:
   * scala> split(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
   * res0: (List[Symbol], List[Symbol]) = (List('a, 'b, 'c),List('d, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
   */
  def split[A](i: Int, ls: List[A]): (List[A], List[A]) = {
    ???
  }

}