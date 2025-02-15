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
    public boolean isValidBST(TreeNode root) {
        ArrayList<Integer> inOrderTraversalResultArray = DFSInOrder(root);
        if(inOrderTraversalResultArray != null && inOrderTraversalResultArray.size() > 1){
            for(int i=1;i<inOrderTraversalResultArray.size();i++){
                if(inOrderTraversalResultArray.get(i) <= inOrderTraversalResultArray.get(i-1))
                    return false;
            }
            return true;
        } else {
            return true;
        }
    }

    private ArrayList<Integer> DFSInOrder(TreeNode root){
        if(root == null){
            return null;
        } else {
            return DFSInOrder(new ArrayList<>(), root);
        }
    }

    private ArrayList<Integer> DFSInOrder(ArrayList<Integer> result, TreeNode currentNode){
        if(currentNode == null) {
            return null;
        }
        DFSInOrder(result, currentNode.left);
        result.add(currentNode.val);
        DFSInOrder(result, currentNode.right);
        return result;
    }
}