package prefix.sum.medium;

import java.util.Arrays;

public class Topic_2731 {

  /**
   * Some robots are standing on an infinite number line with their initial coordinates given by a 0-indexed integer array nums and will start moving once given the command to move.
   * The robots will move a unit distance each second.
   * You are given a string s denoting the direction in which robots will move on command.
   * 'L' means the robot will move towards the left side or negative side of the number line,
   * whereas 'R' means the robot will move towards the right side or positive side of the number line.
   * If two robots collide, they will start moving in opposite directions.
   * Return the sum of distances between all the pairs of robots d seconds after the command. Since the sum can be very large, return it modulo 109 + 7.
   * For two robots at the index i and j, pair (i,j) and pair (j,i) are considered the same pair.
   * When robots collide, they instantly change their directions without wasting any time.
   * Collision happens when two robots share the same place in a moment.
   * For example, if a robot is positioned in 0 going to the right and another is positioned in 2 going to the left,
   * the next second they'll be both in 1 and they will change direction and the next second the first one will be in 0, heading left, and another will be in 2, heading right.
   * <p>
   * For example, if a robot is positioned in 0 going to the right and another is positioned in 1 going to the left,
   * the next second the first one will be in 0, heading left, and another will be in 1, heading right.
   * <p>
   * Solution:
   * The idea is The collision doesn't matter since it happens only the both value of robots is equals
   * So it's the same as the robot keep moving left or right as it's defined in directions
   * We gonna just calculate the numbers after d time
   * <p>
   * And for the sum, we gonna sort it first => nums[j] - nums[i] always non-negative
   * => We will use prefixSum to store the sum from the left
   * => the pattern be like : sum[i] = position[i] * i - prefixSum
   */
  public int sumDistance(int[] nums, String s, int d) {
    int n = nums.length;
    long[] positions = new long[n]; /// avoid overflow
    /*
    The collision doesn't matter since it happens only the both value of robots is equals
    So it's the same as the robot keep moving left or right as it's defined in directions
    */
    for (int i = 0; i < n; i++) {
      if (s.charAt(i) == 'R') {
        positions[i] = (long) nums[i] + d;
      } else {
        positions[i] = (long) nums[i] - d;
      }
    }

    Arrays.sort(positions);

    long sum = 0;
    long prefixSum = 0;
    for (int i = 0; i < n; i++) {
      sum = (sum + positions[i] * i - prefixSum) % 1_000_000_007;
      prefixSum = (prefixSum + positions[i]) % 1_000_000_007;
    }

    return (int) (sum % 1_000_000_007);
  }
}
