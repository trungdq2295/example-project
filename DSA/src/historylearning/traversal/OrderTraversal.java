package historylearning.traversal;

import historylearning.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class OrderTraversal {


    /**
     * Is to scan starting from the root and then left and then right
     * Root -> left -> right
     */
    public void preOrderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        preOrderHelper(root, list);
        list.forEach(System.out::println);
    }

    public void preOrderHelper(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }
        list.add(node.val);
        preOrderHelper(node.left, list);
        preOrderHelper(node.right, list);

    }

    /**
     * How to iterate over it
     * We will use stack
     */
    public void iteratePreorder(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.empty()) {
            TreeNode node = stack.pop();
            System.out.println(node.val);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
    }

    /**
     * inorder is to traverse a tree from left to root to right
     *
     */

    public void inOrderTraverseTree(TreeNode focusNode) {
        if (focusNode != null) {
            inOrderTraverseTree(focusNode.left);
            //Do the logic here
            System.out.println(focusNode.val);
            inOrderTraverseTree(focusNode.right);
        }
    }

    /**
     * Preorder is to traverse a tree from left and right starting from the root
     */
    public void preOrderTraverse(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        //Do the logic here
        System.out.println(treeNode.val);
        postOrderTraverse(treeNode.left);
        postOrderTraverse(treeNode.right);
    }

    /**
     * Postorder is traverse a tree from left and right but starting from the bottom
     */
    public void postOrderTraverse(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }

        postOrderTraverse(treeNode.left);
        postOrderTraverse(treeNode.right);
        //Do the logic here
        System.out.println(treeNode.val);
    }


    public static void main(String[] args) {
        OrderTraversal test = new OrderTraversal();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        test.inOrderTraverseTree(root);
    }

}
