package graph.hard;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Topic_827 {

  /**
   * You are given an n x n binary matrix grid. You are allowed to change at most one 0 to be 1.
   * Return the size of the largest island in grid after applying this operation.
   * An island is a 4-directionally connected group of 1s.
   * <p>
   * Solution:
   * The idea is we count the neighbor of island in 4 directions, assign an id to each island such as grid[i][j] = 2 ( we start with id = 2) and we store the count in a ArrayList
   * After counting, if ArrayList's empty, It means there's no island existed in the graph => we return 1 since we only can flip at most once from '0' to '1'
   * <p>
   * After that, we loop the graph again, and at grid[i][j] == 0, we will count the neighbor around it
   * If the grid[neighborRow][neighborColumn] >= 2 ( this mean, at that grid[i][j] we can connect to the other island which has the total island in our ArrayList)
   * And we can just get the total of that island by using Arraylist.get(islandId - 2) as we start with id = 2
   * <p>
   * We gonna compare the sum to get the maximum
   * If our maximum still equal 0, it mean all the graph contains island (1) => return graph length * graph length
   */

  private static final int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

  public int largestIsland(int[][] grid) {
    int n = grid.length;
    List<Integer> key = new ArrayList<>();
    int id = 2;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (grid[i][j] == 1) { // We gonna find the island with have neighbor and assign an id to it to make it
          // distinct
          int size = dfs(grid, i, j, id);
          key.add(size);
          id++;
        }
      }
    }
    if (key.isEmpty()) { // there's no island, so the result will be 1 only since you can only flip at
      // most once from 0 to 1
      return 1;
    }
    int max = 0;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (grid[i][j] == 0) {
          Set<Integer> seen = new HashSet<>();
          int sum = 1;
          for (int[] dir : directions) {
            int neighborRow = i + dir[0];
            int neighborColumn = j + dir[1];
            if (neighborRow >= 0 && neighborRow < n // valid neighBor
              && neighborColumn >= 0 && neighborColumn < n
              && grid[neighborRow][neighborColumn] >= 2) {
              int islandId = grid[neighborRow][neighborColumn];
              if (!seen.contains(islandId)) {
                sum += key.get(islandId - 2);
                seen.add(islandId);
              }
            }
          }
          max = Math.max(max, sum);
        }
      }
    }
    return max == 0 ? n * n : max;
  }

  private int dfs(int[][] grid, int row, int column, int id) {
    if (row < 0 || row >= grid.length || column < 0 || column >= grid[0].length || grid[row][column] != 1) {
      return 0;
    }
    grid[row][column] = id;
    int count = 1;
    for (int[] dir : directions) {
      count += dfs(grid, row + dir[0], column + dir[1], id);
    }
    return count;
  }
}
