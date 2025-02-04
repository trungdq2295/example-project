package graph.algorithm.floy.warshall;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Topic_3015 {


  /**
   * You are given three positive integers n, x, and y.
   * In a city, there exist houses numbered 1 to n connected by n streets. There is a street connecting the house numbered i with the house numbered i + 1 for all 1 <= i <= n - 1 . An additional street connects the house numbered x with the house numbered y.
   * For each k, such that 1 <= k <= n, you need to find the number of pairs of houses (house1, house2) such that the minimum number of streets that need to be traveled to reach house2 from house1 is k.
   * Return a 1-indexed array result of length n where result[k] represents the total number of pairs of houses such that the minimum streets required to reach one house from the other is k.
   * Note that x and y can be equal.
   * <p>
   * <p>
   * Solution: is to use FloydWarshall to store the distance between house
   */

  public int[] countOfPairs(int n, int x, int y) {
    int[][] dist = new int[n + 1][n + 1];
    for (int i = 1; i <= n; i++) {
      Arrays.fill(dist[i], Integer.MAX_VALUE);
      dist[i][i] = 0; // The distance from a house to itself
      if (i < n) {
        dist[i][i + 1] = 1; // There's a street connecting house i to house i +1;
      }
      if (i > 1) {
        dist[i][i - 1] = 1; // There's a street connecting house i -1 to house i;
      }
    }
    dist[x][y] = 1; // additonal street to move from house x to y
    dist[y][x] = 1; // additonal street to move from house y to x

    // Floyd-Warshall algorithm to calculate all-possible minimum distance
    for (int k = 1; k <= n; k++) {
      for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= n; j++) {
          if (dist[i][k] != Integer.MAX_VALUE && dist[k][j] != Integer.MAX_VALUE) {
            dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
          }
        }
      }
    }

    // We count the number of pair house for each distance and store it in a map
    Map<Integer, Integer> countMap = new HashMap<>();
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= n; j++) {
        if (dist[i][j] != Integer.MAX_VALUE && i != j) {
          countMap.put(dist[i][j], countMap.getOrDefault(dist[i][j], 0) + 1);
        }
      }
    }

    // convert to result
    int[] result = new int[n];
    for (int i = 1; i <= n; i++) {
      result[i - 1] = countMap.getOrDefault(i, 0);
    }
    return result;
  }
}
