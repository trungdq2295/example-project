package dynamic.programming.medium;

public class Topic_1824 {

  /**
   * There is a 3 lane road of length n that consists of n + 1 points labeled from 0 to n.
   * A frog starts at point 0 in the second lane and wants to jump to point n. However, there could be obstacles along the way.
   * You are given an array obstacles of length n + 1 where each obstacles[i] (ranging from 0 to 3) describes an obstacle on the lane obstacles[i] at point i. If obstacles[i] == 0, there are no obstacles at point i. There will be at most one obstacle in the 3 lanes at each point.
   * For example, if obstacles[2] == 1, then there is an obstacle on lane 1 at point 2.
   * The frog can only travel from point i to point i + 1 on the same lane if there is not an obstacle on the lane at point i + 1. To avoid obstacles, the frog can also perform a side jump to jump to another lane (even if they are not adjacent) at the same point if there is no obstacle on the new lane.
   * For example, the frog can jump from lane 3 at point 3 to lane 1 at point 3.
   * Return the minimum number of side jumps the frog needs to reach any lane at point n starting from lane 2 at point 0.
   * <p>
   * Note: There will be no obstacles on points 0 and n.
   * <p>
   * Solution:
   * The idea is to use dynamic programming with size of 3  int[] {1,0,1}( because we have 3 lane and frog start at lane 2, so for other lane will be 1);
   * For each obstacles, we gonna check the value
   * If there's a stone on that lane, you should assign the largest value to that lane since we can't move on that
   * Next, we gonna check for the minimum move on the other 2 lanes
   * Either the frog can move on that lane or have to jump to another lane
   * So we gonna track the minimum of the current
   */
  // obstacles = [0,1,2,3,0]
  public int minSideJumps(int[] obstacles) {
    int[] dp = new int[]{1, 0, 1}; // becasue frog start a lane 2
    for (int num : obstacles) {
      if (num > 0) { // there's a stone
        dp[num - 1] = 1_000_000;
      }
      for (int i = 0; i < 3; i++) {
        if (num != i + 1) {
          dp[i] = Math.min(dp[i], Math.min(dp[(i + 1) % 3], dp[(i + 2) % 3]) + 1); // the format (i+1)%3 to get another index
        }
      }
    }
    return Math.min(dp[0], Math.min(dp[1], dp[2]));
  }
}
