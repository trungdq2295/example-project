package hash.table.medium;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Topic_1072 {

  /**
   * You are given an m x n binary matrix.
   * You can choose any number of columns in the matrix and flip every cell in that column (i.e., Change the value of the cell from 0 to 1 or vice versa).
   * Return the maximum number of rows that have all values equal after some number of flips.
   * <p>
   * Solution:
   * When you flip a column, it affects all rows in that columns
   * So if two rows has same pattern then flipping the appropriate columns can make both rows entirely equals
   * And we gonna flip the row to find the same pattern
   * Example:
   * [0, 1, 0]
   * [1, 0, 1]
   * These two have same pattern so if you flip at first column and third column, these two rows will contain equal value
   * After normalizing the rows, we gonna use hash table to store these pattern and return the largest key with highest value
   */
  public int maxEqualRowsAfterFlips(int[][] matrix) {
    Map<String, Integer> count = new HashMap<>();
    for (int[] row : matrix) {
      StringBuilder key = new StringBuilder(); // build the key
      if (row[0] == 1) {
        for (int n : row) {
          key.append(n == 0 ? 1 : 0);
        }
      } else {
        for (int n : row) {
          key.append(n);
        }
      }
      count.merge(key.toString(), 1, Integer::sum);
    }
    return Collections.max(count.values());
  }
}
