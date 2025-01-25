package sort.topological;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Topological {

  static int[][] DIRECTIONS = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

  List<Integer> list = new ArrayList<>();

  public void topologicalSort(int[][] graph) {
    int n = graph.length;
    boolean[] visited = new boolean[n];
    boolean[] inStack = new boolean[n];
    Stack<Integer> stack = new Stack<>();
    for (int i = 0; i < n; i++) {
      if(!visited[i]){
        dfs(graph, visited, i, inStack, stack);
      }
    }
    while(!stack.isEmpty()){
      System.out.println(stack.pop());
    }
  }

  private boolean dfs(int[][] graph, boolean[] visited, int node, boolean[] inStack, Stack<Integer> stack) {
    if (inStack[node]) { // detect cycle
      return true;
    }
    inStack[node] = true;
    for(int num : graph[node]){
      dfs(graph, visited, num, inStack, stack);
    }
    visited[node] = true;
    /**
     * This to make sure the node has to process again
     * For example
     * the node 0 contains node 2 and node 3, and the node 2 contains node 3. Node 3 is an edge
     * When we process node 0 -> node 2 -> node 3, this is a valid direct way
     * And then we process node 0 -> node 3, if we don't set to false, the code will check it already visited so it become a cycle (this is wrong)
     * You should set it to false to process node 0 -> node 3 again, to make sure it's an valid way
     */
    inStack[node] = false;
    stack.push(node);
    return false;
  }
}
