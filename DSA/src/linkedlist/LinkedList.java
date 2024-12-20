package linkedlist;


class Node {

  int value;
  Node next;


  Node(int value) {
    this.value = value;
  }
}

public class LinkedList {

  private Node head;

  private Node tail;

  private int length;

  public LinkedList(int value) {
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

  public void getHead() {
    System.out.println("Head: " + head.value);
  }

  public void getTail() {
    System.out.println("Tail: " + tail.value);
  }

  public void getLength() {
    System.out.println("Length: " + length);
  }

  public void append(int value) {
    Node newNode = new Node(value);
    if (length == 0) {
      head = newNode;
      tail = newNode;
    } else {
      tail.next = newNode;
      tail = newNode;
    }
    length++;
  }

  public Node removeLast() {
//    Node tempNode = head;
//    if (length == 0) {
//      return;
//    }
//    if (length == 1) {
//      head = null;
//      tail = null;
//      length = 0;
//      return;
//    }
//    while (tempNode.next.next != null) {
//      tempNode = tempNode.next;
//    }
//    tail = tempNode;
//    tail.next = null;
//    length--;

    // Second way: Two pointer, prev pointer and temp pointer
    Node tempNode = head;
    if (length == 0) {
      return null;
    }
    if (tempNode.next == null) {
      head = null;
      tail = null;
      length = 0;
      return tempNode;
    }
    Node prevTempNode = tempNode;
    while (tempNode.next != null) {
      prevTempNode = tempNode;
      tempNode = tempNode.next;
    }
    tail = prevTempNode;
    tail.next = null;
    length--;
    return tempNode;
  }

  public void prepend(int value) {
    var newNode = new Node(value);
    if (length == 0) {
      head = newNode;
      tail = newNode;
    } else {
      newNode.next = head;
      head = newNode;
    }
    length++;
  }

  public Node removeFirst() {
    if (length == 0) {
      return null;
    }
    var tempNode = head;
    head = head.next;
    tempNode.next = null;
    length--;
    if (length == 0) {
      tail = null;
    }
    return tempNode;
  }

  public Node get(int index) {
    if (index <= -1 || index >= length) {
      return null;
    }
    Node tempNode = head;
    for (int i = 0; i < index; i++) {
      tempNode = tempNode.next;
    }
    return tempNode;
  }

  public boolean set(int index, int value) {
    Node tempNode = get(index);
    if (tempNode != null) {
      tempNode.value = value;
      return true;
    }
    return false;
  }

  public boolean insert(int index, int value) {
    if (isValidIndex(index)) {
      return false;
    }
    if (index == 0) {
      prepend(value);
      return true;
    }
    if (index == length) {
      append(value);
      return true;
    }
    Node temp = get(index - 1);
    var newNode = new Node(value);
    newNode.next = temp.next;
    temp.next = newNode;
    length++;
    return true;
  }

  public Node remove(int index) {
    if (isValidIndex(index)) {
      return null;
    }
    if (index == 0) {
      return removeFirst();
    }
    if (index == length - 1) {
      return removeLast();
    }
    var current = get(index);
    if (current != null) {
      var prev = get(index - 1);
      prev.next = current.next;
      length--;
    }
    return current;
  }

  public void reverse() {
    Node temp = head;
    head = tail;
    tail = temp;
    Node after = temp.next;
    Node before = null;
    for (int i = 0; i < length; i++) {
      after = temp.next;
      temp.next = before;
      before = temp;
      temp = after;
    }
  }

  private boolean isValidIndex(int index) {
    return index < 0 || index >= length;
  }

  public void reverseBetween(int startIndex, int endIndex){
      

  }

    public static void main(String[] args) {

            // Create a linked list with values 1, 2, 3, 4, and 5
            LinkedList myLinkedList = new LinkedList(1);
            myLinkedList.append(2);
            myLinkedList.append(3);
            myLinkedList.append(4);
            myLinkedList.append(5);

            System.out.println("Original linked list: ");
            myLinkedList.printList();

            // Reverse a sublist within the linked list
            myLinkedList.reverseBetween(1, 3);
            System.out.println("\nReversed sublist (1, 3): ");
            myLinkedList.printList();
    }
}
