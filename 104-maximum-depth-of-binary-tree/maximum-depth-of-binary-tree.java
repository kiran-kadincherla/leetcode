/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int maxDepth(TreeNode root) {
        return checkDepth(root, 0);
    }

    private int checkDepth(TreeNode root, int currentDepth){
        if(root == null){
            return currentDepth;
        }
        int left = checkDepth(root.left, currentDepth+1);
        int right = checkDepth(root.right, currentDepth+1);
        return Math.max(left, right);
    }
}
