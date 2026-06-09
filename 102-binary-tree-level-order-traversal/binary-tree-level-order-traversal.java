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
    public List<List<Integer>> levelOrder(TreeNode root) {
        return bfs(root);
    }

    private List<List<Integer>> bfs(TreeNode root){
        List<TreeNode> nodes = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> tempRes = new ArrayList<>();
        if(root!=null){
            nodes.add(root.left);
            nodes.add(root.right);
            tempRes.add(root.val);
            result.add(tempRes);
        }
        
        
        
        while(true){
            List<TreeNode> tempNodes = new ArrayList<>();
            tempRes = new ArrayList<>();
            for(int i=0;i<nodes.size();i++){
                TreeNode node = nodes.get(i);
                if(node!=null){
                    tempNodes.add(node.left);
                    tempNodes.add(node.right);
                    tempRes.add(node.val);
                }
            }
            if(tempRes.size()==0){
                break;
            }
            result.add(tempRes);
            nodes = tempNodes;
        }

        return result;

    }
}