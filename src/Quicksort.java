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

  static <T> void partition(T[] arr, int lb, int ub, int pivotIndex) {
    T temp;
    temp = arr[ub];
    arr[ub] = arr[pivotIndex];
    arr[pivotIndex] = temp;
    int small = lb;
    int large = ub - 1;
    while (small != large) {
      if ((arr[small] >= arr[ub]) && (arr[large] <= arr[ub])) {
        temp = arr[small];
        arr[small] = arr[large];
        arr[large] = temp;
        small++;
        large--;
      } else if ((arr[small] >= arr[ub]) && (arr[large] >= arr[ub])) {
        large--;
      }

      else if ((arr[small] <= arr[ub]) && (arr[large] <= arr[ub])) {
        small++;
      } else if ((arr[small] <= arr[ub]) && (arr[large] >= arr[ub])) {
        small++;
        large--;
      }

    }
    temp = arr[large];
    arr[large] = arr[ub];
    arr[ub] = temp;
    for (int i : arr) {
      System.out.print(i + " ");
    }
    System.out.println();
    return large;
  }

  @Override
  public <T> void sort(T[] values, Comparator<? super T> order) {
    
  } // sort(T[], Comparator<? super T>
} // class Quicksort
