package binary.tree;


class Node {
  int value;

  Node left;

  Node right;

  public Node(int value) {
    this.value = value;
  }
}

public class BinarySearchTree {

  Node root;

  public boolean insert(int value) {
    Node newNode = new Node(value);
    if (root == null) {
      root = newNode;
      return true;
    } else {
      Node tempNode = root;
      while (true) {
        if (tempNode.value == newNode.value) {
          return false;
        }
        if (newNode.value < tempNode.value) {
          if (tempNode.left == null) {
            tempNode.left = newNode;
            return true;
          }
          tempNode = tempNode.left;
        } else {
          if (tempNode.right == null) {
            tempNode.right = newNode;
            return true;
          }
          tempNode = tempNode.right;
        }
      }
    }
  }

  public boolean contains(int value) {
    if (root == null) {
      return false;
    }
    Node temp = root;
    while (true) {
      if (temp.value == value) {
        return true;
      }
      if (temp.value < value) {
        if (temp.left == null) {
          return false;
        }
        temp = temp.left;
      } else {
        if (temp.right == null) {
          return false;
        }
        temp = temp.right;
      }
    }
  }
}
