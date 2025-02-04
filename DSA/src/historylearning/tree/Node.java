package historylearning.tree;

public class Node {
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class BinarySearchTree {
    TreeNode root;

    public void addNode(int value) {
        TreeNode newNode = new TreeNode(value);
        if (root == null) {
            root = newNode;
        } else {
            TreeNode focusNode = root;
            TreeNode parent;
            while (true) {
                parent = focusNode;
                if (value <= focusNode.val) {
                    focusNode = focusNode.left;
                    if (focusNode == null) {
                        parent.left = newNode;
                        return;
                    }
                } else {
                    focusNode = focusNode.right;
                    if (focusNode == null) {
                        parent.right = newNode;
                        return;
                    }
                }
            }
        }
    }

    public static void inOrderTraverseTree(TreeNode focusNode) {
        if (focusNode != null) {
            inOrderTraverseTree(focusNode.left);
            System.out.println(focusNode.val);
            inOrderTraverseTree(focusNode.right);
        }
    }

    public static void main(String[] args) {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.addNode(50);
        binarySearchTree.addNode(40);
        binarySearchTree.addNode(30);
        binarySearchTree.addNode(60);
        binarySearchTree.addNode(80);
        inOrderTraverseTree(binarySearchTree.root);
    }
}
