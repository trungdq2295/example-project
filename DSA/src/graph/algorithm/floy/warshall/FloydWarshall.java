package graph.algorithm.floy.warshall;

import java.util.ArrayList;
import java.util.List;

public class FloydWarshall {

  /**
   * The main idea behind the FloydWarshall algorithm is to gradually build up all intermediate routes between node i and j to find the optimal path
   * The goal of Floyd Warshall is to eventually consider going through all possible intermediate nodes on paths of different lengths
   * <p>
   * We use DP with 3D matrix of size n x n x n that acts as a memo table
   * dp[k][i][j] = shortest path from i to j routing through nodes {0, 1, ..., k-1}
   * <p>
   * In the beginning the optimal solution is from i to j is simply the distance in the adjacency matrix
   * dp[k][i][j] = m[i][j] if k = 0
   * otherwise:
   * dp[k][i][j] = min(dp[k-1][i][j], dp[k-1][i][k] + dp[k-1][k][j]);
   * It means we can have the shortest path from i to j directly
   * or there's exist a path going from i to k and then k to j which is shorter than going directly from i to j
   */
  int[][] next;

  public int[][] floydWarshall(int[][] graph) {
    int n = graph.length;
    int[][] dist = new int[n][n];
    next = new int[n][n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        dist[i][j] = graph[i][j];
        if (graph[i][j] != 0 && i != j) {
          next[i][j] = j; // Set the next step for path reconstruction
        } else {
          next[i][j] = -1; // No path
        }
      }
    }

    for (int k = 0; k < n; k++) {
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
          if ( dist[i][k] + dist[k][j] < dist[i][j]) {
            dist[i][j] = dist[i][k] + dist[k][j];
            next[i][j] = next[i][k]; // Update path
          }
        }
      }
    }
    return dist;
  }

  public List<Integer> reconstructPath(int start, int end) {
    List<Integer> path = new ArrayList<>();
    if (next[start][end] == -1) {
      return path; //no path exists
    }
    int index = start;
    while (index != end) {
      path.add(index);
      index = next[start][end];
    }
    path.add(end);
    return path;
  }

}
