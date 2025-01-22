package graph.hard;

public class TrappingRainWater {
  /**
   * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.
   * Solution:
   * The idea is to create a temp array and fill the data into the cell which is near the boundary
   * After filling the data, you gonna calculate the water by using the cell in temp array - the cell in heightMap
   */
  public int trapRainWater(int[][] heightMap) {
    int m = heightMap.length;
    int n = heightMap[0].length;

    int[][] vols = new int[m][n];
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        vols[i][j] = heightMap[i][j];
      }
    }

    boolean upt = true; // flag to update the data
    boolean init = true; // this flag to make sure the first iteration work
    while (upt) {
      upt = false; // this is to check there's no update during the loop


      //Move from top-left to bottom-right to fill the data
      for (int i = 1; i < m - 1; i++) {
        for (int j = 1; j < n - 1; j++) {
          int value = Math.max(heightMap[i][j],
            Math.min(vols[i - 1][j], vols[i][j - 1]));
          if (init || vols[i][j] > value) {
            vols[i][j] = value;
            upt = true;
          }
        }
      }

      init = false;

      //Move from bottom-right to top-left;
      for (int i = m - 2; i >= 1; i--) {
        for (int j = n - 2; j >= 1; j--) {
          int value = Math.max(heightMap[i][j],
            Math.min(vols[i + 1][j], vols[i][j + 1]));
          if (vols[i][j] > value) {
            vols[i][j] = value;
            upt = true;
          }
        }
      }
    }

    int res = 0;
    for (int i = 1; i < m - 1; i++) {
      for (int j = 1; j < n - 1; j++) {
        if (vols[i][j] > heightMap[i][j]) {
          res += vols[i][j] - heightMap[i][j];
        }
      }
    }
    return res;
  }
}
