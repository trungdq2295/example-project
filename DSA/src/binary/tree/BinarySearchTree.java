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

  public void insert(int value) {
    if (root == null) {
      root = new Node(value);
      return;
    }
    rInsert(root, value);
//    Node newNode = new Node(value);
//    if (root == null) {
//      root = newNode;
//      return true;
//    } else {
//      Node tempNode = root;
//      while (true) {
//        if (tempNode.value == newNode.value) {
//          return false;
//        }
//        if (newNode.value < tempNode.value) {
//          if (tempNode.left == null) {
//            tempNode.left = newNode;
//            return true;
//          }
//          tempNode = tempNode.left;
//        } else {
//          if (tempNode.right == null) {
//            tempNode.right = newNode;
//            return true;
//          }
//          tempNode = tempNode.right;
//        }
//      }
//    }
  }

  public boolean contains(int value) {
//    if (root == null) {
//      return false;
//    }
//    Node temp = root;
//    while (true) {
//      if (temp.value == value) {
//        return true;
//      }
//      if (temp.value < value) {
//        if (temp.left == null) {
//          return false;
//        }
//        temp = temp.left;
//      } else {
//        if (temp.right == null) {
//          return false;
//        }
//        temp = temp.right;
//      }
//    }
    return rContains(root, value);
  }

  private boolean rContains(Node currentNode, int value) {
    if (currentNode == null) {
      return false;
    }
    if (currentNode.value == value) {
      return true;
    }
    if (value < currentNode.value) {
      return rContains(currentNode.left, value);
    } else {
      return rContains(currentNode.right, value);
    }
  }

  private Node rInsert(Node currentNode, int value) {
    if (currentNode == null) {
      return new Node(value);
    }
    if (currentNode.value > value) {
      currentNode.left = rInsert(currentNode.left, value);
    } else if (currentNode.value < value) {
      currentNode.right = rInsert(currentNode.right, value);
    }
    return currentNode;
  }
}
