package stack;

public class Main {

  public static void main(String[] args) {
    Stack stack = new Stack(4);
    stack.push(2);
    stack.getTop();
    stack.pop();
    stack.printStack();
  }
}
