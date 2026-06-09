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
    Integer prev = null;
    public boolean isValidBST(TreeNode root) {
        return inOrder(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean inOrder(TreeNode root, long min, long max){
        if(root==null){
            return true;
        }
        if(root.val<=min || root.val>=max){
            return false;
        }
        boolean leftResult = inOrder(root.left, min, root.val);
        boolean rightResult = inOrder(root.right, root.val, max);
        return leftResult&&rightResult;
        
    }
}