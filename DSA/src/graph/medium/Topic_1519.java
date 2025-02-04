package graph.medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Topic_1519 {

  /**
   * You are given a tree (i.e. a connected, undirected graph that has no cycles) consisting of n nodes numbered from 0 to n - 1 and exactly n - 1 edges.
   * The root of the tree is the node 0, and each node of the tree has a label which is a lower-case character given in the string labels (i.e. The node with the number i has the label labels[i]).
   * The edges array is given on the form edges[i] = [ai, bi], which means there is an edge between nodes ai and bi in the tree.
   * Return an array of size n where ans[i] is the number of nodes in the subtree of the ith node which have the same label as node i.
   * A subtree of a tree T is the tree consisting of a node in T and all of its descendant nodes.
   * <p>
   * Solution:
   * The idea is we first create a map which form a undirected graph
   * And then we use DFS to reach the leaf node and count the character of that leaf node
   * After counting child node, we gonna accumulate the count to the parent's count
   * <p>
   * So the result will be calculated first for the child, and then the parent
   */
  public int[] countSubTrees(int n, int[][] edges, String labels) {
    int[] res = new int[n];
    Map<Integer, Set<Integer>> map = new HashMap<>();
    for (int i = 0; i < n; i++) {
      map.put(i, new HashSet<>());
    }

    for (int i = 0; i < edges.length; i++) {
      int a = edges[i][0];
      int b = edges[i][1];
      map.get(a).add(b);
      map.get(b).add(a);
    }
    dfs(map, 0, -1, labels, res);
    return res;
  }

  private int[] dfs(Map<Integer, Set<Integer>> map, int node, int parent, String labels, int[] res) {
    int[] count = new int[26]; // only contains lowerase english
    char current = labels.charAt(node);
    count[current - 'a']++; // We count the character in the current node;

    for (int child : map.get(node)) {
      if (child == parent) { // skip parent node;
        continue;
      }
      int[] childCount = dfs(map, child, node, labels, res);
      for (int i = 0; i < 26; i++) { // where you accumulate the count from hte child node
        count[i] += childCount[i];
      }
    }

    res[node] = count[current - 'a']; // set the value of the current node
    return count; // return the count to the parent so it can be accumulated for the parent

  }
}
