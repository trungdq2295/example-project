package prefix.sum.medium;

public class Topc_2145 {

  /**
   * You are given a 0-indexed array of n integers differences,
   * which describes the differences between each pair of consecutive integers of a hidden sequence of length (n + 1). More formally, call the hidden sequence hidden, then we have that differences[i] = hidden[i + 1] - hidden[i].
   * You are further given two integers lower and upper that describe the inclusive range of values [lower, upper] that the hidden sequence can contain.
   * For example, given differences = [1, -3, 4], lower = 1, upper = 6, the hidden sequence is a sequence of length 4 whose elements are in between 1 and 6 (inclusive).
   * [3, 4, 1, 5] and [4, 5, 2, 6] are possible hidden sequences.
   * [5, 6, 3, 7] is not possible since it contains an element greater than 6.
   * [1, 2, 3, 4] is not possible since the differences are not correct.
   * Return the number of possible hidden sequences there are. If there are no possible sequences, return 0.
   * <p>
   * Solution:
   * We gonna use mathematical in here.
   * We will track the min/max value while iterating the differences array
   * x be long [min,max] and x belong [lower, upper]
   * => upper - lower >= max - min
   * => upper-lower > max -min   => no "x" is  valid
   * => upper - lower == max-min => there's 1 value
   * and if upper - lower == max - min + 1 => there're "1 + 1" value
   * and if upper - lower == max -min + k => there're "1 +k " value
   */
  public int numberOfArrays(int[] differences, int lower, int upper) {
    int n = differences.length;
    long min = 0, max = 0, current = 0;
    for(int diff : differences){
      current += diff;
      min = Math.min(min, current);
      max = Math.max(max, current);
    }

    return (int) Math.max(0, (upper - lower) - (max - min) + 1);
  }
}
