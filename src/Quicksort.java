import java.util.Comparator;

/**
 * Sort using Quicksort.
 *
 * @author Your Name Here
 */

public class Quicksort implements Sorter {

  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The one sorter you can access.
   */
  public static Sorter SORTER = new Quicksort();

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Create a sorter.
   */
  Quicksort() {} // Quicksort()

  // +---------+-----------------------------------------------------
  // | Methods |
  // +---------+


  @Override
  public <T> void sort(T[] values, Comparator<? super T> order) {
    
  } // sort(T[], Comparator<? super T>
} // class Quicksort
