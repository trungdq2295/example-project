package graph.algorithm.floy.warshall;

import java.util.List;

public class Main {

  public static void main(String[] args) {
    int[][] graph = {
      {0, 3, 0, 7},
      {8, 0, 2, 0},
      {5, 0, 0, 1},
      {2, 0, 0, 0}
    };

    FloydWarshall fw = new FloydWarshall();
    fw.floydWarshall(graph);

    List<Integer> path = fw.reconstructPath(0, 3);
    System.out.println("Shortest path from 0 to 3: " + path);
  }
}
