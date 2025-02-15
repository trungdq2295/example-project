package sort.medium;

import java.util.Arrays;

public class Topic_910 {


  /**
   * You are given an integer array nums and an integer k.
   * For each index i where 0 <= i < nums.length, change nums[i] to be either nums[i] + k or nums[i] - k.
   * The score of nums is the difference between the maximum and minimum elements in nums.
   * Return the minimum score of nums after changing the values at each index.
   * <p>
   * Solution:
   * The idea is we gonna sort the array to make sure the nums[0] is the minimum and nums[n-1] is the mximum
   * and have an initial res = nums[n-1] - nums[0] which assume the minimum value
   * And then we start to iterate array
   * in each loop, we gonna check if the current num[i] + k is greater than the nums[n-1] - k;
   * The same for the minum if current num[i] - k is lesser than nums[0] + k
   * Then we calculate the sum from these two with the initial res to get the minimum
   */

  public int smallestRangeII(int[] nums, int k) {
    int n = nums.length;
    if (n == 1) {// edge case
      return 0;
    }
    Arrays.sort(nums);
    int res = nums[n - 1] - nums[0];
    /**
     The idea is to check if there's any greater value than the current max - k if we add k to that nums[i]
     The same for the minimum
     After that, we gonna calculate the minimum value
     */
    for (int i = 0; i < n - 1; i++) {
      int maxI = Math.max(nums[n - 1] - k, nums[i] + k);
      int minI = Math.min(nums[0] + k, nums[i + 1] - k);
      res = Math.min(res, maxI - minI);
    }
    return res;

  }
}
