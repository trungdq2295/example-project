package divide.and.conquer.medium;

public class Topic_53 {

  /**
   * Given an integer array nums, find the subarray with continuous with the largest sum, and return its sum.
   * <p>
   * Solution:
   */
  public int maxSubArray(int[] nums) {
    return divideAndConquer(nums, 0, nums.length - 1);
  }

  private int divideAndConquer(int[] nums, int left, int right) {
    if (left == right) {
      return nums[left];
    }
    int mid = left + (right - left) / 2;
    int leftSum = divideAndConquer(nums, left, mid);
    int rightSum = divideAndConquer(nums, mid + 1, right);
    int crossMax = maxCrossingSum(nums, left, mid, right);
    return Math.max(crossMax, Math.max(leftSum, rightSum));
  }

  private int maxCrossingSum(int[] nums, int left, int mid, int right) {
    int leftSum = Integer.MIN_VALUE;
    int sum = 0;
    for (int i = mid; i >= left; i--) {
      sum += nums[i];
      leftSum = Math.max(leftSum, sum);
    }

    int rightSum = Integer.MIN_VALUE;
    sum = 0;
    for (int i = mid + 1; i <= right; i++) {
      sum += nums[i];
      rightSum = Math.max(rightSum, sum);
    }
    return leftSum + rightSum;
  }
}
