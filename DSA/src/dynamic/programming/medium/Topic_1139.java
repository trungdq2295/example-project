package dynamic.programming.medium;

public class Topic_1139 {

  /**
   * Given a 2D grid of 0s and 1s, return the number of elements in the largest square subgrid that has all 1s on its border, or 0 if such a subgrid doesn't exist in the grid.
   * <p>
   * Solution: We use Dp
   * The idea is we need to find the largest area of square with border = 1
   * So we create 2 dp, 1 is top and second is left ( these 2s array dp to store the number of consecutive 1s to the left/top)
   * We start to iterate from top-left to bottom down
   * On the first row/column, it will always depend on the value of grid[0][i]/grid[j][0]
   * On the next row/column, we gonna check if there current
   * + grid[i][j] == 0 => no way to calculate square, then we set 0 at that top[i][j]/left[i][j]
   * + grid[i][j] == 1 => It can be formed a square, we gonna set the size by the previous row/column + 1
   * And then we gonna start to find the largest "k" and set to max if it's larger than current max
   */

  public int largest1BorderedSquare(int[][] grid) {
    int m = grid.length, n = grid[0].length;
    int[][] left = new int[m][n],
      top = new int[m][n];
    int res = 0;
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (i == 0) { // first row
          top[i][j] = grid[i][j];
        } else {
          top[i][j] = grid[i][j] == 0 ? 0 : top[i - 1][j] + 1;
        }

        if (j == 0) { // first column
          left[i][j] = grid[i][j];
        } else {
          left[i][j] = grid[i][j] == 0 ? 0 : left[i][j - 1] + 1;
        }

        /**
         * The reason for i-k+1/j - k + 1 is to locate the top-left corner of the potential square subgrid size of k * k
         * Jsut take it easy dude, because array is 0-indexed and at the 0-indexed it start with 1 value, so it should be -1 LOL
         * left[i-k+1][j] >= k check if the left border of the square has at least `k` consecutive 1s
         * top[i][j-k+1] >=k check if the top border of the square has at least `k` consecutive 1s
         */
        for (int k = Math.min(top[i][j], left[i][j]); k >= 1; k--) {
          if (left[i - k + 1][j] >= k && top[i][j - k + 1] >= k) {
            res = Math.max(res, k * k);
            break;
          }
        }
      }
    }
    return res;
  }
}
