import java.util.Comparator;

/**
 * Sort using insertion sort.
 *
 * @author Joshua Delarosa
 */

public class InsertionSort implements Sorter {

  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The one sorter you can access.
   */
  public static Sorter SORTER = new InsertionSort();

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Create a sorter.
   */
  InsertionSort() {} // InsertionSort()

  // +---------+-----------------------------------------------------
  // | Methods |
  // +---------+

  @Override
  public <T> void sort(T[] values, Comparator<? super T> order) {
    T temp;

    if (values.length <= 1) {
      return;
    }

    for (int i = 1; i < values.length; i++) {
      if (i + 1 > values.length) {
        break;
      }

      if (order.compare(values[i], values[i - 1]) < 0) {
        temp = values[i];

        for (int j = i - 1; j >= 0; j--) {
          values[j + 1] = values[j];

          if (order.compare(values[j], values[i]) <= 0) {
            values[j] = temp;

            if (j - 1 < 0) {
              continue;
            }
            if (order.compare(values[j], values[j - 1]) >= 0) {
              break;
            }
          }
        }
      } else {
        continue;
      }
    }
  } // sort(T[], Comparator<? super T>

  public static void main(String[] args) {

    InsertionSort sorter = new InsertionSort();

    String[] tester = {"hello", "sam", "congratulations"};
    sorter.sort(tester, (x, y) -> Integer.compare(x.length(), y.length()));

    Integer[] original = {1, 5, 2, 3, 8, 8, 4};
    sorter.sort(original, (x, y) -> Integer.compare(x, y));

    for (String temp : tester) {
      System.out.println(temp);
    }

  }

} // class InsertionSort
