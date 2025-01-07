package tries;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Node {


  char c;

  Map<Character, Node> nodes;

  Node() {
    this.c = '\0';
    nodes = new HashMap<>();
  }

  public Node(char c) {
    this.c = c;
    nodes = new HashMap<>();
  }

  public Node addNode(char c) {
    return nodes.computeIfAbsent(c, Node::new);
  }


  @Override
  public String toString() {
    return "Node{" +
      "c=" + c +
      ", nodes=" + nodes +
      '}';
  }
}

public class Tries {

  Node root;

  public Tries() {
    root = new Node();
  }

  public void addNode(String word) {
    Node currentNode = root;
    for (char c : word.toCharArray()) {
      currentNode = currentNode.addNode(c);
    }
  }

  public void printTries() {
    root.nodes.forEach((key, value) -> printNode(value));
  }

  public void printNode(Node current) {
    if (current == null) {
      return;
    }
    System.out.println(current.c);
    current.nodes.forEach((key, value) -> printNode(value));
  }

  public List<String> showSuggestion(String prefix) {
    List<String> suggestions = new ArrayList<>();
    Node current = root;

    for (char c : prefix.toCharArray()) {
      current = current.nodes.get(c);
      if (current == null) {
        return suggestions;
      }
    }
    current.nodes.forEach((key, value) -> buildString(value, prefix, suggestions));
    return suggestions;
  }

  private void buildString(Node current, String start, List<String> list) {
    StringBuilder sb = new StringBuilder(start);
    sb.append(current.c);
    if(current.nodes.isEmpty()){
      list.add(sb.toString());
    }
    current.nodes.forEach((key, value) -> buildString(value, sb.toString(), list));
  }
}
