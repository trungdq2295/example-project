package graph.medium;

import java.util.*;

public class Topic_310 {


  /**
   * A tree is an undirected graph in which any two vertices are connected by exactly one path. In other words, any connected graph without simple cycles is a tree.
   * Given a tree of n nodes labelled from 0 to n - 1, and an array of n - 1 edges where edges[i] = [ai, bi] indicates that
   * there is an undirected edge between the two nodes ai and bi in the tree, you can choose any node of the tree as the root.
   * When you select a node x as the root, the result tree has height h.
   * Among all possible rooted trees, those with minimum height (i.e. min(h))  are called minimum height trees (MHTs).
   * Return a list of all MHTs' root labels. You can return the answer in any order.
   * The height of a rooted tree is the number of edges on the longest downward path between the root and a leaf.
   * <p>
   * Solution:
   * The topic requires us to get the center node which has the minimum height ( from root node to leaves)
   * every node can be center node, so first we think, we gonna build a graph map<integer, set<integer>>, however this approach is not efficient since it O(n^2)
   * So we start to think if it's center node, then that node has to have more than or equal to 2 leaves
   * => conclusion: every node which has 1 leave, that node is a leave for the other node
   * => We gonna use BFS to traversal the graph
   * We will create a count array to store the count for each node, and use the queue to add all the leaf node
   * And then we gonna start to process
   * + Each process we gonna pull the leaf node from queue and process all the neighbor of that node by -1 and check if the count of that neighbor =1 => add back to the queue
   * + We increase the total node has been processed
   * + Stopping when 1 or 2 nodes remain ensures that we have found the centers of the tree.
   * Why? because if we have 2 nodes, each of them can be a center since each of them can connect each other
   * IF we have 3 nodes, the middle of them will be a new center
   */
  public List<Integer> findMinHeightTrees(int n, int[][] edges) {
    if (n == 1) {
      return List.of(0);
    }
    Map<Integer, Set<Integer>> map = new HashMap<>();

    int[] count = new int[n];
    for (int i = 0; i < n; i++) {
      map.put(i, new HashSet<>());
    }
    for (int i = 0; i < n - 1; i++) {
      int a = edges[i][0];
      int b = edges[i][1];
      count[a]++;
      count[b]++;
      map.get(a).add(b);
      map.get(b).add(a);
    }

    Queue<Integer> queue = new LinkedList<>();
    for (int i = 0; i < n; i++) {
      if (count[i] == 1) { // the leaf nodes only
        queue.offer(i);
      }
    }

    int processed = 0;
    while (n - processed > 2) {
      int size = queue.size();
      processed += size;
      for (int i = 0; i < size; i++) {
        int leaf = queue.poll();
        for (int neighbor : map.get(leaf)) {
          if (--count[neighbor] == 1) {
            queue.add(neighbor);
          }
        }
      }
    }
    return new ArrayList<>(queue);
  }
}
