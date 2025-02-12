package binary.search.medium;

import java.util.Arrays;

public class Topic_3048 {

  /**
   * You are given two 1-indexed integer arrays, nums and, changeIndices, having lengths n and m, respectively.
   * Initially, all indices in nums are unmarked. Your task is to mark all indices in nums.
   * In each second, s, in order from 1 to m (inclusive), you can perform one of the following operations:
   * Choose an index i in the range [1, n] and decrement nums[i] by 1.
   * If nums[changeIndices[s]] is equal to 0, mark the index changeIndices[s].
   * Do nothing.
   * Return an integer denoting the earliest second in the range [1, m] when all indices in nums can be marked by choosing operations optimally, or -1 if it is impossible.
   * <p>
   * Solution:
   * Use binary search to calculate the minimum of second with left is 1 and right is changeIndices.length -1
   * For each "mid" second, we are going to check if all nums can be marked
   * If it can, we decrease the right
   * If it can't, we increase the left
   * How to check if all num can be marked:
   * We gonna create an temp array to track the last num can be marked in changeIndices
   * And then we iterate from 0 second to mid "s" second with a variable marked (total number can be marked) and operations (number of times can be used to decrement other number)
   * If at current second isn't the second for number which can be marked, we gonna increment the operation ( use to decrement other number)
   * If it is, then we need to check if the current operation is enough to decrease the number
   * If it's not, return false
   * If it's , then increase the marked and decrease the operation since we used it to decrease the number
   */
  public int earliestSecondToMarkIndices(int[] nums, int[] changeIndices) {
    int n = nums.length;
    int[] changeIndicesAdjusted = Arrays.stream(changeIndices).map(index -> index - 1).toArray();
    int low = 0, high = changeIndices.length - 1;
    while (low < high) {
      int mid = (low + high) / 2;
      if (isPossible(nums, changeIndicesAdjusted, mid)) {
        high = mid;
      } else {
        low = mid + 1;
      }
    }
    return isPossible(nums, changeIndicesAdjusted, low) ? low + 1 : -1;
  }

  private boolean isPossible(int[] nums, int[] changeIndices, int s) {
    int n = nums.length;
    int[] last = new int[n];
    Arrays.fill(last, -1);
    for (int i = 0; i <= s; i++) {
      last[changeIndices[i]] = i; // get the latest possible index to mark the current num
    }
    int marked = 0, operations = 0;
    for (int i = 0; i <= s; i++) {
      if (i == last[changeIndices[i]]) { // the latest index we can use to mark
        if (nums[changeIndices[i]] > operations) { // not enough operation to decrease the num
          return false;
        }
        operations -= nums[changeIndices[i]];
        marked++;
      } else {
        operations++;
      }
    }
    return marked == n; // after go through "s" second, check if the all number is marked;
  }
}
