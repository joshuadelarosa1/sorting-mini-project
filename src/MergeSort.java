import java.util.Comparator;

/**
 * Sort using merge sort.
 *
 * @author Your Name Here
 */

public class MergeSort implements Sorter {

  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The one sorter you can access.
   */
  public static Sorter SORTER = new MergeSort();

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Create a sorter.
   */
  MergeSort() {} // MergeSort()

  // +---------+-----------------------------------------------------
  // | Methods |
  // +---------+

  /**
   * Merge the values from positions [lo..mid) and [mid..hi) back into the same part of the array.
   *
   * Preconditions: Each subarray is sorted accorting to comparator.
   */
  static <T> void merge(T[] vals, int lo, int mid, int hi, Comparator<? super T> comparator) {
    T[] temp = java.util.Arrays.copyOf(vals, vals.length);
    int i = lo;
    int originalMid = mid;

    while (lo != originalMid && mid != hi) {
      if ((comparator.compare(vals[lo], vals[mid])) <= 0) {
        temp[i++] = vals[lo++];
      } else if ((comparator.compare(vals[lo], vals[mid]) > 0)) {
        temp[i++] = vals[mid++];
      }
    }

    if (lo < originalMid) {
      while (i != hi) {
        temp[i++] = vals[lo++];
      }
    }

    for (int j = 0; j < vals.length; j++) {
      vals[j] = temp[j];
    }
  } // merge

  public <T> void mergeSort(T[] values, int lb, int ub, Comparator<? super T> comparator) {
    int mid = lb + ((ub - lb) / 2);

    if (ub - lb > 1) {
      mergeSort(values, lb, mid, comparator);
      mergeSort(values, mid, ub, comparator);
      merge(values, lb, mid, ub, comparator);
    }
  } // mergeSort

  @Override
  public <T> void sort(T[] values, Comparator<? super T> order) {
    if (values.length <= 1) {
      return;
    }

    mergeSort(values, 0, values.length, order);
  } // sort(T[], Comparator<? super T>

} // class MergeSort
