package union.find;

public class UnionFind {

  int[] parent;

  public int find(int x) {
    if (parent[x] != x) {
      return find(parent[x]);
    } else {
      return x;
    }
  }

  private void union(int x, int y) {
    parent[find(y)] = find(x);
  }

}
