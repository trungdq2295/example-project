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

  private Node deleteNode(Node currentNode, int value) {
    if (currentNode == null) { // The case when value is not present in the tree
      return null;
    }
    if (value < currentNode.value) {
      currentNode.left = deleteNode(currentNode.left, value);
    } else if (value > currentNode.value) {
      currentNode.right = deleteNode(currentNode.right, value);
    } else {
      if (currentNode.left == null && currentNode.right == null) { // The case when value we delete is a leaf node ( no child)
        return null;
      } else if (currentNode.left == null) { // The case when value has right child
        currentNode = currentNode.right;
      } else if (currentNode.right == null) { // The case when value has left child
        currentNode = currentNode.left;
      } else { // The case when value has both left and right child. We need to move the minimum of the right child to the node we want to delete and put replace the deleted node with that
        int subTreeMin = minimumValue(currentNode.right);
        currentNode.value = subTreeMin;
        currentNode.right = deleteNode(currentNode.right, subTreeMin);
      }
    }
    return currentNode;
  }

  public void deleteNode(int value) {
    deleteNode(root, value);
  }

  private int minimumValue(Node currentNode) {
    while (currentNode.left != null) {
      currentNode = currentNode.left;
    }
    return currentNode.value;
  }
}
