package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph {
  private Map<String, ArrayList<String>> adjList = new HashMap<>();


  public boolean addVertex(String vertex) {
    if (!adjList.containsKey(vertex)) {
      adjList.put(vertex, new ArrayList<>());
      return true;
    }
    return false;
  }

  public void printGraph() {
    System.out.println(adjList);
  }

  public boolean addEdge(String vertex, String edge) {
    if (adjList.get(vertex) == null || adjList.get(edge) == null) {
      return false;
    }
    adjList.get(vertex).add(edge);
    adjList.get(edge).add(vertex);
    return true;
  }

  public boolean removeVertex(String vertex) {
    if (adjList.containsKey(vertex)) {
      List<String> edges = adjList.get(vertex);
      edges.forEach(key -> adjList.get(key).remove(vertex));
      adjList.remove(vertex);
      return true;
    }
    return false;
  }

  public boolean removeEdge(String vertex1, String vertex2) {
    if (adjList.get(vertex1) == null || adjList.get(vertex2) == null) {
      return false;
    }
    adjList.get(vertex1).remove(vertex2);
    adjList.get(vertex2).remove(vertex1);
    return true;
  }
}
