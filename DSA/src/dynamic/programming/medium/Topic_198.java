package dynamic.programming.medium;

public class Topic_198 {

  /**
   * You are a professional robber planning to rob houses along a street.
   * Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected
   * and it will automatically contact the police if two adjacent houses were broken into on the same night.
   * Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.
   * <p>
   * Solution:
   * The idea is you have to check the number of house at even index or odd index(since you can't rob 2 adjacent house) which one gonna give you the maximum profit
   * So we will use DP here (bottom-up) and  at each index we gonna compare the dp[i-1] and (dp[i-2] + nums[i-1]) // nums[i-1] because we init our dp like dp = new int[n+1]
   */
  public int rob(int[] nums) {
    int n = nums.length;
    int[] dp = new int[n + 1];
    dp[0] = 0;
    dp[1] = nums[0];
    for (int i = 2; i <= n; i++) {
      dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i - 1]);
    }
    return dp[n];
  }
}
