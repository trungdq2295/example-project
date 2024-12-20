package hash.table;


import java.util.ArrayList;

class Node {

  String key;
  int value;

  Node next;

  public Node(String key, int value) {
    this.key = key;
    this.value = value;
  }
}

public class HashTable {

  private int size = 7;
  private Node[] dataMap;

  public HashTable() {
    dataMap = new Node[size];
  }

  public void printTable() {
    for (int i = 0; i < dataMap.length; i++) {
      System.out.println(i + ":");
      Node temp = dataMap[i];
      while (temp != null) {
        System.out.println("{" + temp.key + "= " + temp.value + "}");
        temp = temp.next;
      }
    }
  }

  public void set(String key, int value) {
    int index = hash(key);
    Node temp = dataMap[index];
    Node newNode = new Node(key, value);
    if (temp == null) {
      dataMap[index] = newNode;
    } else {
      temp = getLastNodeOfAKey(temp);
      temp.next = newNode;
    }
  }

  public Node get(String key) {
    int index = hash(key);
    Node temp = dataMap[index];
    while (temp != null) {
      if (temp.key.equals(key)) {
        return temp;
      }
      temp = temp.next;
    }
    return null;
  }

  public ArrayList<String> keys() {
    ArrayList<String> keys = new ArrayList<>();
    for (Node node : dataMap) {
      Node temp = node;
      while (temp != null) {
        keys.add(temp.key);
        temp = temp.next;
      }
    }
    return keys;
  }

  private int hash(String key) {
    int hash = 0;
    char[] keysChars = key.toCharArray();
    for (int asciiValue : keysChars) {
      hash = (hash + asciiValue * 23) % dataMap.length;

    }
    return hash;
  }

  private Node getLastNodeOfAKey(Node temp) {
    while (temp.next != null) {
      temp = temp.next;
    }
    return temp;
  }
}
