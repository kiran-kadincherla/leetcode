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
    TreeNode root = null;

    public TreeNode sortedArrayToBST(int[] nums) {
        divideAndConquer(nums, 0, nums.length-1);
        return root;
    }

    private void divideAndConquer(int[] nums, int startIndex, int endIndex){
        if(startIndex > endIndex)
            return;
        if(startIndex == endIndex){
            insert(nums[startIndex]);
            return;
        }
        int mid = (int) Math.ceil((double)(startIndex + endIndex) / 2);
        insert(nums[mid]);
        divideAndConquer(nums, startIndex, mid-1);
        divideAndConquer(nums, mid+1, endIndex);
    }

    private void insert(int value){
        if(root == null){
            root = new TreeNode(value);
        } else {
            insert(root, value);
        }
    }


    private TreeNode insert(TreeNode currentNode, int value){
        if(currentNode == null) {
            return new TreeNode(value);
        }
        if(value > currentNode.val){
            currentNode.right = insert(currentNode.right, value);
        } else if(value < currentNode.val) {
            currentNode.left = insert(currentNode.left, value);
        }
        return currentNode;
    }
}