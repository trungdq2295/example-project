package linkedlist.medium;


import linkedlist.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Topic_1019 {

  /**
   * You are given the head of a linked list with n nodes.
   * For each node in the list, find the value of the next greater node. That is, for each node, find the value of the first node that is next to it and has a strictly larger value than it.
   * Return an integer array answer where answer[i] is the value of the next greater node of the ith node (1-indexed). If the ith node does not have a next greater node, set answer[i] = 0.
   * <p>
   * Solution:
   * We wil use stack here since we process from left to right and the greater value from the right then we need da FILO
   * First: We will iterate ListNode to create a list at index "i" will have value list.get(i)
   * After that: We will loop the list again. In each loop we will check the if stack is empty and the current stack.peek()'s value is lesser than the current value in list
   * If it does, we gonna loop until the current stack.peek()'s value no longer greater than
   * And then we gonna push the index to the stack to make sure that the index will be processed
   */
  public int[] nextLargerNodes(ListNode head) {
    List<Integer> list = new ArrayList<>(10);
    ListNode current = head;
    while (current != null) {
      list.add(current.val);
      current = current.next;
    }
    int[] res = new int[list.size()];
    Stack<Integer> stack = new Stack<>();
    for (int i = 0; i < list.size(); i++) {
      while (!stack.isEmpty() && list.get(i) > list.get(stack.peek())) {
        int index = stack.pop();
        res[index] = list.get(i);
      }
      stack.push(i);
    }

    // No need to process unless it asked you to set some specific value for the case there's no greater value than current node
    // while(!stack.isEmpty()){
    //   res[stack.pop()] = 0;
    // }
    return res;
  }
}
