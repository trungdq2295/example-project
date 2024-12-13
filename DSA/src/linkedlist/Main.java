package linkedlist;

public class Main {

  public static void main(String[] args) {
    LinkedList myLinkedList = new LinkedList(4);
    myLinkedList.append(10);
    myLinkedList.append(14);
    myLinkedList.append(15);
    myLinkedList.printList();
    myLinkedList.reverse();
    myLinkedList.printList();
  }
}
