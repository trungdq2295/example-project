package dynamic.programming.medium;

public class Topic_1937 {

  /**
   * You are given an m x n integer matrix points (0-indexed). Starting with 0 points, you want to maximize the number of points you can get from the matrix.
   * To gain points, you must pick one cell in each row. Picking the cell at coordinates (r, c) will add points[r][c] to your score.
   * However, you will lose points if you pick a cell too far from the cell that you picked in the previous row. For every two adjacent rows r and r + 1 (where 0 <= r < m - 1), picking cells at coordinates (r, c1) and (r + 1, c2) will subtract abs(c1 - c2) from your score.
   * Return the maximum number of points you can achieve.
   * <p>
   * Solution: Use Dynamic Programing to store the value at the current [i][j]
   * The idea is you gonna find at each cell which gonna give you the max value by iterating each row
   * In each row, you have left and right dp[] to check if which one has greater value
   * <p>
   * Then you update to the current dp[] and we use that current dp for the next row
   * <p>
   * After processing all row, we will get the max value from that dp
   */

  public long maxPoints(int[][] points) {
    int m = points.length;
    int n = points[0].length;

    long dp[] = new long[n];
    for (int i = 0; i < n; i++) {
      dp[i] = points[0][i]; //store the value at the first row;
    }

    for (int i = 1; i < m; i++) { //process row by row
      /**
       *  The reason we have to traversal from left and right because of the penalty of the previous row
       *  For example if you got the highest value at index 2 and dp length = 3
       *  => There will be 1 penalty at right[2] and there's most likely 2 penalty from the left
       */
      long left[] = new long[n];
      long right[] = new long[n];

      left[0] = dp[0];
      for (int j = 1; j < n; j++) {
        left[j] = Math.max(left[j - 1] - 1, dp[j]); // we use " - 1 " here because take the penalty from last row
      }

      right[n - 1] = dp[n - 1];
      for (int j = n - 2; j >= 0; j--) {
        right[j] = Math.max(right[j + 1] - 1, dp[j]); // we use " - 1 " here because take the penalty from last row
      }

      //We combine the value to compare
      for (int j = 0; j < n; j++) {
        dp[j] = points[i][j] + Math.max(left[j], right[j]);
      }
    }

    long max = Long.MIN_VALUE;
    for (long value : dp) {
      max = Math.max(value, max);
    }
    return max;
  }


}
