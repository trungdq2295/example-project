package doublelinkedlist;


class Node {
  int value;
  Node next;

  Node prev;

  public Node(int value) {
    this.value = value;
  }
}

public class DoubleLinkedList {

  Node head;
  Node tail;

  int length;

  public DoubleLinkedList(int value) {
    Node newNode = new Node(value);
    head = newNode;
    tail = newNode;
    length = 1;
  }

  public void printList() {
    Node temp = head;
    while (temp != null) {
      System.out.println(temp.value);
      temp = temp.next;
    }
  }

  public void reversedPrintList() {
    Node tempTail = tail;
    while (tempTail != null) {
      System.out.println(tempTail.value);
      tempTail = tempTail.prev;
    }
  }

  public void getHead() {
    System.out.println("Head: " + head.value);
  }

  public void getTail() {
    System.out.println("Tail: " + tail.value);
  }

  public void getLength() {
    System.out.println("Lenght: " + length);
  }

  public void append(int value) {
    Node newNode = new Node(value);
    if (length == 0) {
      head = newNode;
      tail = newNode;
    } else {
      tail.next = newNode;
      newNode.prev = tail;
      tail = newNode;
    }
    length++;
  }

  public Node removeLast() {
    if (length == 0) {
      return null;
    }
    Node tempNode = tail;
    if (length == 1) {
      tail = null;
      head = null;
    } else {
      tail = tempNode.prev;
      tail.next = null;
      tempNode.prev = null;
    }
    length--;
    return tempNode;
  }

  public void prepend(int value) {
    Node newNode = new Node(value);
    if (length == 0) {
      head = newNode;
      tail = newNode;
    } else {
      newNode.next = head;
      head.prev = newNode;
      head = newNode;
    }
    length++;
  }

  public Node removeFirst() {
    if (length == 0) {
      return null;
    }
    Node temp = head;
    if (length == 1) {
      head = null;
      tail = null;
    } else {
      head = temp.next;
      temp.next = null;
      head.prev = null;
    }
    length--;
    return temp;
  }

  public Node get(int index) {
    if (isInValidIndex(index)) {
      return null;
    }
    Node temp = null;
    if (index > length / 2) {
      temp = tail;
      for (int i = 0; i < (length - index - 1); i++) {
        temp = temp.prev;
      }
    } else {
      temp = head;
      for (int i = 0; i < index; i++) {
        temp = temp.next;
      }
    }
    return temp;
  }

  public boolean set(int index, int value) {
    Node node = get(index);
    if (node != null) {
      node.value = value;
      return true;
    }
    return false;
  }

  public boolean insert(int index, int value) {
    if (index == 0) {
      prepend(value);
      return true;
    }
    if (index == length) {
      append(value);
      return true;
    }
    Node node = get(index);
    Node previousNode = node.prev;
    Node newNode = new Node(value);
    previousNode.next = newNode;
    newNode.prev = previousNode;
    newNode.next = node;
    node.prev = newNode;
    length++;
    return true;
  }

  public Node remove(int index) {
    if (isInValidIndex(index)) {
      return null;
    }
    if (index == 0) {
      return removeFirst();
    }
    if (index == length - 1) {
      return removeLast();
    }
    Node temp = get(index);
    Node prevNode = temp.prev;
    Node afterNode = temp.next;
    prevNode.next = afterNode;
    afterNode.prev = prevNode;
    temp.next = null;
    temp.prev = null;
    length--;
    return temp;
  }

  private boolean isInValidIndex(int index) {
    return index < 0 || index >= length;
  }
}
