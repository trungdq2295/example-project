package graph.medium;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class MapOfHighestPeak {

  /**
   * You are given an integer matrix isWater of size m x n that represents a map of land and water cells.
   * If isWater[i][j] == 0, cell (i, j) is a land cell.
   * If isWater[i][j] == 1, cell (i, j) is a water cell.
   * You must assign each cell a height in a way that follows these rules:
   * The height of each cell must be non-negative.
   * If the cell is a water cell, its height must be 0.
   * Any two adjacent cells must have an absolute height difference of at most 1. A cell is adjacent to another cell if the former is directly north, east, south, or west of the latter (i.e., their sides are touching).
   * Find an assignment of heights such that the maximum height in the matrix is maximized.
   * Return an integer matrix height of size m x n where height[i][j] is cell (i, j)'s height. If there are multiple solutions, return any of them
   *
   * Solution:
   * The idea is you have to find the water cell and starting from that cell, increase the value by using BFS
   */

  public int[][] highestPeak(int[][] isWater) {
    int[] dx = {0, 0, 1, -1};//Horizontal
    int[] dy = {1, -1, 0, 0}; //Vertical
    int m = isWater.length;
    int n = isWater[0].length;

    int[][] result = new int[m][n];
    for (int[] rows : result) { // to detecet unprocess cell
      Arrays.fill(rows, -1);
    }

    Queue<int[]> cellQueue = new LinkedList<>();
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (isWater[i][j] == 1) {
          cellQueue.add(new int[]{i, j});
          result[i][j] = 0;
        }
      }
    }

    int heightOfNextCell = 1; //inital value

    //BFS in graph
    while (!cellQueue.isEmpty()) {
      int size = cellQueue.size();
      for (int i = 0; i < size; i++) {
        int[] currentCell = cellQueue.poll();
        for (int d = 0; d < 4; d++) { //process 4 direction
          int neightborX = currentCell[0] + dx[d];
          int neightborY = currentCell[1] + dy[d];
          if (isValidCell(neightborX, neightborY, m, n)
            && result[neightborX][neightborY] == -1 // haven't process yet
          ) {
            result[neightborX][neightborY] = heightOfNextCell;
            cellQueue.add(new int[]{neightborX, neightborY}); //add to queue to process the cell next to this neightbor again
          }
        }
      }
      heightOfNextCell++;
    }

    return result;
  }

  private boolean isValidCell(int row, int column, int rows, int columns) {
    return row >= 0 && row < rows && column >= 0 && column < columns;
  }
}
