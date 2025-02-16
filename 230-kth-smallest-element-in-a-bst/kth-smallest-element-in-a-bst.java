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
    public int kthSmallest(TreeNode root, int k) {
        ArrayList<Integer> result = DFSInorder(root);
        return result.get(k-1);
    }

    public ArrayList<Integer> DFSInorder(TreeNode root){
        if(root == null){
            return null;
        }
        ArrayList<Integer> resultArr = new ArrayList<>();
        DFSInorder(root, resultArr);
        return resultArr;

    }

    public TreeNode DFSInorder(TreeNode currentNode, ArrayList<Integer> resultArr){
        if(currentNode == null){
            return null;
        }
        DFSInorder(currentNode.left, resultArr);
        resultArr.add(currentNode.val);
        DFSInorder(currentNode.right, resultArr);
        return currentNode;
    }
}