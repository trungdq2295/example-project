package bit.manipulation.medium;

public class Topic_2749 {

  /**
   * You are given two integers num1 and num2.
   * In one operation, you can choose integer i in the range [0, 60] and subtract 2^i + num2 from num1.
   * Return the integer denoting the minimum number of operations needed to make num1 equal to 0.
   * If it is impossible to make num1 equal to 0, return -1.
   * <p>
   * Solution:
   * The idea is to count the bitset since the topic require subtract from 2^i
   * bitCount (such as Integer.bitCount) tell us how many "1" represent in a number.
   * For example: bitCount(13) = 2^3 + 2^2 + 2^0
   * So we gonna compare the bitcount from subtraction (num1 - num2*k) <=k (k is the number of allowed bitset)
   * and we also ensure k is not greater than the subtraction  (num1 - num2*k)
   * Because if k > subtraction, this mean we are using more
   */

  public int makeTheIntegerZero(int num1, int num2) {
    for (int k = 1; k < 61; k++) {
      if (Integer.bitCount(num1 - num2 * k) <= k && k <= num1 - num2 * k) {
        return k;
      }
    }
    return -1;
  }
}
