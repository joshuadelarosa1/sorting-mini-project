import java.util.Arrays;
import java.util.Comparator;

/**
 * Something that fails to sort. Intended primarily to allow us to wath tests fail.
 *
 * @author Samuel A. Rebelsky, Joshua Delarosa
 */

public class DelarosaJoshuaSort implements Sorter {

  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The one sorter you can access.
   */
  public static Sorter SORTER = new DelarosaJoshuaSort();

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Create a sorter.
   */
  DelarosaJoshuaSort() {} // FakeSort()

  // +---------+-----------------------------------------------------
  // | Methods |
  // +---------+

  private static final int MIN_MERGE = 32;

  @Override
  public <T> void sort(T[] values, Comparator<? super T> order) {
    if (values == null || values.length <= 1) {
      // Nothing to sort
      return;
    }

    int length = values.length;

    // Apply Insertion Sort to small subarrays
    for (int i = 0; i < length; i += MIN_MERGE) {
      int left = i;
      int right = Math.min(i + MIN_MERGE - 1, length - 1);
      insertionSort(values, order, left, right);
    }

    // Merge subarrays in a bottom-up fashion
    for (int size = MIN_MERGE; size < length; size = 2 * size) {
      for (int left = 0; left < length; left += 2 * size) {
        int mid = Math.min(left + size - 1, length - 1);
        int right = Math.min(left + 2 * size - 1, length - 1);
        merge(values, order, left, mid, right);
      }
    }
  }

  private <T> void insertionSort(T[] values, Comparator<? super T> order, int left, int right) {
    for (int i = left + 1; i <= right; i++) {
      T key = values[i];
      int j = i - 1;
      while (j >= left && order.compare(values[j], key) > 0) {
        values[j + 1] = values[j];
        j--;
      }
      values[j + 1] = key;
    }
  }

  private <T> void merge(T[] values, Comparator<? super T> order, int left, int mid, int right) {
    if (order.compare(values[mid], values[mid + 1]) <= 0) {
      return; // The subarrays are already sorted, no need to merge.
    }

    int leftSize = mid - left + 1;
    int rightSize = right - mid;

    T[] leftArray = Arrays.copyOfRange(values, left, mid + 1);
    T[] rightArray = Arrays.copyOfRange(values, mid + 1, right + 1);

    int i = 0, j = 0, k = left;
    while (i < leftSize && j < rightSize) {
      if (order.compare(leftArray[i], rightArray[j]) <= 0) {
        values[k] = leftArray[i];
        i++;
      } else {
        values[k] = rightArray[j];
        j++;
      }
      k++;
    }

    while (i < leftSize) {
      values[k] = leftArray[i];
      i++;
      k++;
    }

    while (j < rightSize) {
      values[k] = rightArray[j];
      j++;
      k++;
    }
  }
  // sort(T[], Comparator<? super T>
} // class FakeSort
