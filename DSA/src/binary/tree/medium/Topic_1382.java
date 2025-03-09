package binary.tree.medium;

import binary.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Topic_1382 {


  /**
   * Balance a Binary Search Tree
   * Given the root of a binary search tree, return a balanced binary search tree with the same node values.
   * If there is more than one answer, return any of them.
   * A binary search tree is balanced if the depth of the two subtrees of every node never differs by more than 1.
   */

  public TreeNode balanceBST(TreeNode root) {
    List<Integer> list = new ArrayList<>();
    inorder(root, list);
    return buildBalanceTree(list, 0, list.size() - 1);
  }

  private void inorder(TreeNode root, List<Integer> list) {
    if (root == null) {
      return;
    }
    inorder(root.left, list);
    list.add(root.val);
    inorder(root.right, list);
  }

  private TreeNode buildBalanceTree(List<Integer> list, int left, int right) {
    if (left > right) {
      return null;
    }
    int mid = (left + right) / 2;
    TreeNode root = new TreeNode(list.get(mid));
    root.left = buildBalanceTree(list, left, mid - 1);
    root.right = buildBalanceTree(list, mid + 1, right);
    return root;
  }
}
