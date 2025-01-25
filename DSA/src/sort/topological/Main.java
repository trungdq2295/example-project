package sort.topological;

public class Main {

  public static void main(String[] args) {
    Topological topological = new Topological();

    int[][] graph = new int[5][];

    // Initialize the adjacency lists for each node
    graph[0] = new int[] {1, 2}; // Node 0 points to Node 1 and Node 2
    graph[1] = new int[] {3};    // Node 1 points to Node 3
    graph[2] = new int[] {3};    // Node 2 points to Node 3
    graph[3] = new int[] {4};    // Node 3 points to Node 4
    graph[4] = new int[] {};     // Node 4 has no outgoing edges (terminal node)

    topological.topologicalSort(graph);
  }
}
