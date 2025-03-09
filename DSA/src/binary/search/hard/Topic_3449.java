package binary.search.hard;

public class Topic_3449 {

  /**
   * Maximize the Minimum Game Score
   * You are given an array points of size n and an integer m. There is another array gameScore of size n, where gameScore[i] represents the score achieved at the ith game. Initially, gameScore[i] == 0 for all i.
   * You start at index -1, which is outside the array (before the first position at index 0). You can make at most m moves. In each move, you can either:
   * Increase the index by 1 and add points[i] to gameScore[i].
   * Decrease the index by 1 and add points[i] to gameScore[i].
   * Note that the index must always remain within the bounds of the array after the first move.
   * Return the maximum possible minimum value in gameScore after at most m moves.
   * <p>
   * Solution:
   * Maxium possible minimum => Binary search
   * But how can we apply binary search here and which function we use to move our left/right?
   * We gonna use a value as a target to reach in our array points
   * So we need to check how many step we need to reach that value at point[i]
   * However, We can only move back/forth only 1 position
   * => If we need 3 points[0], we need to move to 0 -> 1  -> 0 -> 1-> 0
   * => formula will be: 2*3 -1 = 5 => if we need k point[i] => 2*k -1
   * If we can reach that value, we need to move our left since we need maximum possible of minum
   * if we can't, we need to decrease our right
   */

  public long maxScore(int[] points, int m) {
    long left = 0,
      right = 1L * (m + 1) / 2 * points[0]; // use 1L to convert to long and points[0] to
    while (left < right) {
      long mid = (left + right + 1) / 2;
      if (check(points, mid, m)) {
        left = mid;
      } else {
        right = mid - 1;
      }
    }
    return left;
  }

  private boolean check(int[] points, long target, int m) {
    long res = 0,
      k = 0; // number of move we reach at points[i]
    /**
     * Each time we will increment k * 2 -1 to the result "res"
     * Example: If we needd 3 of points[0] => we need to move to 0 -> 1 -> 0 -> 1 > 0 ~= 2*3 - 1
     */
    int n = points.length;
    for (int i = 0; i < n; i++) {
      if (i == n - 1 && (1L * k * points[i]) >= target) {
        break;
      }
      /**
       The formula to calculate how many step  we need at point[i] to reach target
       (target + points[i] - 1) / points[i])
       Since we need some step to reach position "i", that's why we substract k + 1
       */
      k = Math.max(((target + points[i] - 1) / points[i]) - (k + 1), 0);
      res += k * 2 + 1;
      if (res > m) { // compare the total step we need to reach target and allowed steps
        return false;
      }
    }
    return true;
  }
}
