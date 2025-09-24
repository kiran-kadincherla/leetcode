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
    Integer minVal = null;
    boolean isValid = true;
    public boolean isValidBST(TreeNode root) {
        inOrder(root);
        return isValid;
    }

    private void inOrder(TreeNode root){
        if(root == null){
            return;
        }
        inOrder(root.left);
        if(minVal!=null && root.val<=minVal){
            isValid = false;
            return;
        } else {
            minVal=root.val;
        }
        inOrder(root.right);
    }

    

  
}