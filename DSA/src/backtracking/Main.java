package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

  static List<int[]> list = new ArrayList<>();

  public static boolean findingPathInMaze(int[][] maze, int[] start, int[] end) {
    int rows = maze.length;
    int cols = maze[0].length;
    boolean[][] visited = new boolean[rows][cols];
    return checking(maze, start[0], start[1], end, visited);
  }

  public static boolean checking(int[][] maze, int row, int col, int[] end, boolean[][] visited) {
    if (row < 0 || row >= maze.length || col < 0 || col >= maze[0].length || visited[row][col] || maze[row][col] == 1) {
      return false;
    }
    list.add(new int[]{row, col});
    if (row == end[0] && col == end[1]) {
      return true;
    }
    visited[row][col] = true;
    // move to the left
    if (checking(maze, row, col - 1, end, visited)) {
      return true;
    }
    //move to the right
    if (checking(maze, row, col + 1, end, visited)) {
      return true;
    }

    //move to top
    if (checking(maze, row - 1, col, end, visited)) {
      return true;
    }

    //move down
    if (checking(maze, row + 1, col, end, visited)) {
      return true;
    }
    list.remove(new int[]{row, col});
    return false;
  }

  public static void main(String[] args) {
    int[][] maze = {
      {1, 0, 1},
      {0, 0, 1},
      {0, 1, 0}
    };

    boolean result = findingPathInMaze(maze, new int[]{0, 1}, new int[]{2, 0});
    System.out.println(result);

    list.forEach(x -> System.out.println(Arrays.toString(x)));
  }
}
