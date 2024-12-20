package graph;

public class Main {

  public static void main(String[] args) {
    Graph graph = new Graph();
    graph.addVertex("TN");
    graph.addVertex("ABC");
    graph.addVertex("ABCX");

    graph.addEdge("TN", "ABC");
    graph.addEdge("TN", "ABCX");
    graph.addEdge("ABC", "ABCX");

    graph.removeVertex("TN");


    graph.printGraph();
  }
}
