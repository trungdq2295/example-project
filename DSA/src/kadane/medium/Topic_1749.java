package kadane.medium;

public class Topic_1749 {

  /**
   * Maximum Absolute Sum of Any Subarray
   * You are given an integer array nums. The absolute sum of a subarray [numsl, numsl+1, ..., numsr-1, numsr] is abs(numsl + numsl+1 + ... + numsr-1 + numsr).
   *    Return the maximum absolute sum of any (possibly empty) subarray of nums.
   *    Note that abs(x) is defined as follows:
   *
   *    If x is a negative integer, then abs(x) = -x.
   *    If x is a non-negative integer, then abs(x) = x.
   *
   *
   *  Solution: use kadane algorithm
   *   We need to check the maximum and another for the minimum
   */
  public int maxAbsoluteSum(int[] nums) {
    int n = nums.length;
    int max = nums[0];
    int min = nums[0];
    int currentMax = nums[0];
    int currentMin = nums[0];

    for(int i = 1; i < n; i++){
      currentMin = Math.min(nums[i], currentMin + nums[i]); // track the min in sub continuous array
      currentMax = Math.max(nums[i], currentMax + nums[i]); // track the max in sub continuous array

      max = Math.max(currentMax, max); // possible max
      min = Math.min(currentMin, min); // possible min

    }
    return Math.max(max, Math.abs(min));
  }
}
