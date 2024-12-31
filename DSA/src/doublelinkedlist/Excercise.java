package doublelinkedlist;

public class Excercise {


  /**
   * Given head which is a reference node to a singly-linked list. The value of each node in the linked list is either 0 or 1. The linked list holds the binary representation of a number.
   * Return the decimal value of the number in the linked list.
   * The most significant bit is at the head of the linked list.
   *
   *
   * Solution: A best way to convert bit to decimal is to simulates the left shift in binary ( multiply by 2 moves all the bit to the left)
   * Adding the current bit  incorporates the current binary digit into decimal value
   * Example: 101 => 0*2 + 1 = 1
   *              => 1 * 2 + 0 = 2
   *              = > 2 *2 + 1 = 5
   */
  public int getDecimalValue(ListNode head) {
    ListNode temp=head;
    int d=0;
    while(temp!=null){
      d=d*2+temp.val;
      temp=temp.next;
    }
    return d;
  }
}
