package dynamic.programming.medium;

import java.util.HashMap;
import java.util.Map;

public class Topic_873 {

  /**
   * Length of Longest Fibonacci Subsequence
   * <p>
   * A sequence x1, x2, ..., xn is Fibonacci-like if:
   * n >= 3
   * xi + xi+1 == xi+2 for all i + 2 <= n
   * Given a strictly increasing array arr of positive integers forming a sequence, return the length of the longest Fibonacci-like subsequence of arr. If one does not exist, return 0.
   * A subsequence is derived from another sequence arr by deleting any number of elements (including none) from arr, without changing the order of the remaining elements. For example, [3, 5, 8] is a subsequence of [3, 4, 5, 6, 7, 8].
   * <p>
   * Solution:
   * Use 2D DP to store the longest sequence with nums[i] and nums[j]
   */

  public int lenLongestFibSubseq(int[] nums) {
    int res = 0;
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      map.put(nums[i], i);
    }
    Map<Integer, Map<Integer, Integer>> dp = new HashMap<>();

    for (int j = 1; j < nums.length; j++) {
      for (int i = 0; i < j; i++) {
        int prev = nums[j] - nums[i];
        if (map.containsKey(prev) && map.get(prev) < i) {
          dp.putIfAbsent(i, new HashMap<>()); // init map
          int value = dp.getOrDefault(map.get(prev), new HashMap<>()).getOrDefault(i, 0) + 1;
          dp.get(i).put(j, value);
          res = Math.max(res, dp.get(i).get(j));
        }
      }
    }
    return res;
  }
}
