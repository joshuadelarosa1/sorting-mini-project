import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import java.math.BigInteger;
import org.junit.jupiter.api.Test;

/**
 * Tests of Sorter objects.
 *
 * @author Your Name
 */
public class SortTester {

  // +---------+-----------------------------------------------------
  // | Globals |
  // +---------+

  Sorter sorter;

  // +-------+-------------------------------------------------------
  // | Tests |
  // +-------+

  // I will fix this stuff later, maybe try comparing by length instead

  @Test
  public void zeroItemTest() {
    String[] original = {""};
    String[] expected = original.clone();

    sorter.sort(original, (x, y) -> Integer.compare(x.length(), y.length()));
    assertArrayEquals(original, expected);
  } // zeroItemTest

  @Test
  public void oneItemTest() {
    String[] original = {"alpha"};
    String[] expected = original.clone();

    sorter.sort(original, (x, y) -> Integer.compare(x.length(), y.length()));
    assertArrayEquals(original, expected);
  } // oneItemTest

  @Test
  public void simpleTest() {
    String[] original = {"hello", "sam", "congratulations"};
    String[] expected = {"sam", "hello", "congratulations"};

    sorter.sort(original, (x, y) -> Integer.compare(x.length(), y.length()));
    assertArrayEquals(original, expected);
  } // simpleTest()

  @Test
  public void sameLenTest() {
    String[] original = {"hello", "world"};
    String[] expected = original.clone();
    String[] expectedTwo = {"world", "hello"};

    sorter.sort(original, (x, y) -> Integer.compare(x.length(), y.length()));
    assertAll("Checks for all permutations", () -> assertArrayEquals(original, expected),
        () -> assertArrayEquals(original, expectedTwo));
  } // sameLenTest

  @Test
  public void integerTest() {
    Integer[] original = {1, 5, 2, 3, 8, 8, 4};
    Integer[] expected = {1, 2, 3, 4, 5, 8, 8};

    sorter.sort(original, (x, y) -> Integer.compare(x, y));
    assertArrayEquals(original, expected);
  } // integerTest()

  @Test
  public void orderedStringTest() {
    String[] original = {"alpha", "bravo", "charlie", "delta", "foxtrot"};
    String[] expected = original.clone();
    sorter.sort(original, (x, y) -> x.compareTo(y));
    assertArrayEquals(original, expected);
  } // orderedStringTest

  @Test
  public void reverseOrderedStringTest() {
    String[] original = {"foxtrot", "delta", "charlie", "bravo", "alpha"};
    String[] expected = {"alpha", "bravo", "charlie", "delta", "foxtrot"};
    sorter.sort(original, (x, y) -> x.compareTo(y));
    assertArrayEquals(original, expected);
  } // orderedStringTest

} // class SortTester
