package math;

public class Topic_1922 {


  /**
   * A digit string is good if the digits (0-indexed) at even indices are even and the digits at odd indices are prime (2, 3, 5, or 7).
   * For example, "2582" is good because the digits (2 and 8) at even positions are even and the digits (5 and 2) at odd positions are prime. However, "3245" is not good because 3 is at an even index but is not even.
   * Given an integer n, return the total number of good digit strings of length n. Since the answer may be large, return it modulo 109 + 7.
   * A digit string is a string consisting of digits 0 through 9 that may contain leading zeros.
   * <p>
   * Solution:
   * Notice the pattern:
   * Index:    0 1 2 3 4 5 6
   * Choices:  5 4 5 4 5 4 5
   * => Total number = 5 * 4 * 5 * 4 * 5
   * That just power of 5 and 4
   * So the idea is to calculate how many power you need to calculate
   * However, the number will be so large that long number won't be able to take it so we need to write our own power function and  % MODULO 10^9 + 7
   */

  private static int MOD = 1_000_000_007;

  public int countGoodNumbers(long n) {
    long odd = n / 2;
    long even = (n + 1) / 2;
    return (int) (pow(5, even) * pow(4, odd) % MOD);
  }


  private long pow(long x, long n) {
    if (n == 0) {
      return 1;
    }
    long temp = pow(x, n / 2);
    if (n % 2 == 0) {
      return (temp * temp) % MOD;
    } else {
      return (x * temp * temp) % MOD;
    }
  }

}
