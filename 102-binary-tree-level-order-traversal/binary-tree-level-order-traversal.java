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
        Queue<TreeNode> nodes = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();
        
        if(root!=null){
            nodes.add(root);
        }
        
        while(!nodes.isEmpty()){
            Queue<TreeNode> tempNodes = new LinkedList<>();
            List<Integer> tempRes = new ArrayList<>();

            while(!nodes.isEmpty()){
                TreeNode node = nodes.poll();
                if(node!=null){
                    tempNodes.add(node.left);
                    tempNodes.add(node.right);
                    tempRes.add(node.val);
                }
            }
            if(tempRes.size()>0)
                result.add(tempRes);
            nodes = tempNodes;
        }

        return result;

    }
}