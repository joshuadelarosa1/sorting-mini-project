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

  static <T> int partition(T[] arr, int lb, int ub, Comparator<? super T> order) {
    if (arr.length <= 1) {
      return 0;
    }

    int small = lb + 1;
    int large = ub;
    int pivotIndex = lb + ((ub - lb) / 2);

    T temp = arr[lb];
    arr[lb] = arr[pivotIndex];
    arr[pivotIndex] = temp;

    while (small < large) {
      if (order.compare(arr[small], arr[lb]) <= 0) {
        small++;
      } else if (order.compare(arr[large - 1], arr[lb]) > 0) {
        large--;
      } else {
        temp = arr[small];
        arr[small] = arr[--large];
        arr[large] = temp;
        small++;
      }
    }

    temp = arr[lb];
    arr[lb] = arr[small - 1];
    arr[small - 1] = temp;

    return small - 1;
  } // partition

  @Override
  public <T> void sort(T[] values, Comparator<? super T> order) {
    partition(values, 0, values.length, order);
  } // sort(T[], Comparator<? super T>
} // class Quicksort
