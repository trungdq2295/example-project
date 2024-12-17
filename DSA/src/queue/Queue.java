package queue;


class Node {
  int value;
  Node next;

  public Node(int value) {
    this.value = value;
  }
}

public class Queue {
  private Node first;

  private Node last;

  private int length;

  public Queue(int value) {
    Node newNode = new Node(value);
    first = newNode;
    last = newNode;
    length = 1;
  }

  public void getFirst() {
    System.out.println("First: " + first);
  }

  public void getLast() {
    System.out.println("Last: " + last);
  }

  public void getLength() {
    System.out.println("Length: " + length);
  }

  public void enqueue(int value) {
    Node newNode = new Node(value);
    if (length == 0) {
      first = newNode;
      last = newNode;
    } else {
      last.next = newNode;
      last = newNode;
    }
    length++;
  }

  public Node dequeue() {
    if (length == 0) {
      return null;
    }
    Node temp = first;
    first = temp.next;
    temp.next = null;

    if (length == 0) {
      last = null;
    }
    length--;
    return temp;
  }
}
