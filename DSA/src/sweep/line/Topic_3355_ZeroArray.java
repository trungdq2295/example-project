package sweep.line;

public class Topic_3355_ZeroArray {

  /**
   * You are given an integer array nums of length n and a 2D array queries, where queries[i] = [li, ri].
   * For each queries[i]:
   * Select a subset of indices within the range [li, ri] in nums.
   * Decrement the values at the selected indices by 1.
   * A Zero Array is an array where all elements are equal to 0.
   * Return true if it is possible to transform nums into a Zero Array after processing all the queries sequentially, otherwise return false.
   * <p>
   * Solution:
   * The idea is to use prefix sum
   * You gonna create a different array with length n + 1 to store the total decrement at index i and minus 1 at the right + 1
   * After that you process both array by updating the current index of different array by diff[i] += diff[i-1]
   * And then you compare if diff[i] < nums[i], it will be false since there's no way to decrease the nums[i] to 0
   */


  public boolean isZeroArray(int[] nums, int[][] queries) {
    int n = nums.length;
    int[] diff = new int[n + 1];
    /**
     Since we are using diff[i] += diff[i-1];
     you need to decrement the diff[query[1] + 1] to make sure the increment stop at query[1]
     */
    for (int[] num : queries) {
      diff[num[0]]++;
      diff[num[1] + 1]--;
    }

    if (diff[0] < nums[0]) {
      return false;
    }

    for (int i = 1; i < n; i++) {
      diff[i] += diff[i - 1];
      if (diff[i] < nums[i]) {
        return false;
      }
    }

    return true;
  }
}
