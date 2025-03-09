package prefix.sum.medium;

public class Topic_1524 {

  /**
   * Number of Sub-arrays With Odd Sum
   * Given an array of integers arr, return the number of subarrays with an odd sum.
   * Since the answer can be very large, return it modulo 109 + 7.
   * <p>
   * Solution: The idea is to use prefixSum
   * We gonna create 2 sum count, 1 for even and another for odd
   * if current num is even then your odd sum still an odd sum, you only need to increment the even sum count
   * If the current num is odd, adding it will change the current sum, so we swap odd and even count then odd increase 1 ( the current element it self)
   * At the end, we gonna increment the result
   */

  private static int MOD = 1_000_000_007;

  public int numOfSubarrays(int[] arr) {
    long res = 0,
      odd = 0,
      even = 0;
    for (int num : arr) {
      if (num % 2 == 0) {
        even++;
      } else {
        long temp = even;
        even = odd;
        odd = temp;
        odd++;
      }
      /**
       * This still works no matter your current num is even/odd because if it even, odd + even = odd -> we still can add up to the result
       */
      res += odd;
    }
    return (int) (res % MOD);
  }
}
