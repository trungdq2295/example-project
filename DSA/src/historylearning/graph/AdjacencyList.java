package historylearning.graph;

import java.util.ArrayList;
import java.util.LinkedList;

public class AdjacencyList {

    ArrayList<LinkedList<Node>> list;

    public AdjacencyList() {
        this.list = new ArrayList<>();

    }

    public void addNode(Node node) {
        LinkedList<Node> currentList = new LinkedList<>();
        currentList.add(node);
        list.add(currentList);
    }

    public void addEdge(int src, int dst) {
        LinkedList<Node> currentList = list.get(src);
        Node destinationNode = list.get(dst).get(0);
        currentList.add(destinationNode);
    }

    public boolean checkEdge(int src, int dst) {
        LinkedList<Node> currentList = list.get(src);
        Node destinationNode = list.get(dst).get(0);
        return currentList.contains(destinationNode);
    }

    public void print() {
        for(LinkedList<Node> currentList: list){
            for(Node node: currentList){
                System.out.print(node.data + " -> ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        AdjacencyList graph = new AdjacencyList();

        graph.addNode(new Node('A'));
        graph.addNode(new Node('B'));
        graph.addNode(new Node('C'));
        graph.addNode(new Node('D'));
        graph.addNode(new Node('E'));

        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(1, 4);
        graph.addEdge(2, 3);
        graph.addEdge(2, 4);
        graph.addEdge(4, 0);
        graph.addEdge(4, 2);

        graph.print();
    }
}
