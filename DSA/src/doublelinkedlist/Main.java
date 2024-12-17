package doublelinkedlist;

public class Main {

  public static void main(String[] args) {
    DoubleLinkedList list = new DoubleLinkedList(5);
    list.append(6);
    list.append(1);
    list.append(2);
    list.append(8);
    list.append(9);

    list.insert(2, 15);
    list.set(2, 16);
    System.out.println(list.get(2).value);
    list.remove(2);
    System.out.println(list.get(2).value);
  }
}
