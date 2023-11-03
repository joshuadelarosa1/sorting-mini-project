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

  static <T> void partition(T[] arr, int lb, int ub, Comparator<? super T> order) {
    T temp;
    int pivotIndex = lb + ((ub - lb) / 2);
    int small = lb;
    int large = ub - 1;

    temp = arr[large];
    arr[large] = arr[pivotIndex];
    arr[pivotIndex] = temp;

    while (small != large) {
      if(large < 0) {
        break;
      }

      if (order.compare(arr[small], arr[ub]) >= 0 && order.compare(arr[large], arr[ub]) <= 0) {
        temp = arr[small];
        arr[small] = arr[large];
        arr[large] = temp;

        small++;
        large--;
      } else if (order.compare(arr[small], arr[ub]) >= 0
          && order.compare(arr[large], arr[ub]) >= 0) {
        large--;
      } else if (order.compare(arr[small], arr[ub]) <= 0
          && order.compare(arr[large], arr[ub]) <= 0) {
        small++;
      } else if (order.compare(arr[small], arr[ub]) <= 0
          && order.compare(arr[large], arr[ub]) >= 0) {
        small++;
        large--;
      }

    }
    temp = arr[large];
    arr[large] = arr[ub];
    arr[ub] = temp;
  } // partition

  @Override
  public <T> void sort(T[] values, Comparator<? super T> order) {
    if (values.length <= 1) {
      return;
    }

    partition(values, 0, values.length - 1, order);
  } // sort(T[], Comparator<? super T>
} // class Quicksort
