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
        if(root!=null)
            return bfs(root);
        else
            return new ArrayList<>();
    }

    private List<List<Integer>> bfs(TreeNode root){
        List<List<Integer>> result = new ArrayList<>();
        Set<TreeNode> visited = new HashSet<>();
        Queue<TreeNode> nodesInQueue = new LinkedList<>();
        nodesInQueue.add(root);

        while (true){
            List<Integer> tempVisitedNodes = new ArrayList<>();
            Queue<TreeNode> tempQueue = new LinkedList<>();
            while(nodesInQueue != null && !nodesInQueue.isEmpty()){
                TreeNode node = nodesInQueue.poll();
                tempVisitedNodes.add(node.val);
                visited.add(node);
                if(node.left!=null && !visited.contains(node.left)){
                    tempQueue.add(node.left);
                }
                if(node.right!=null && !visited.contains(node.right)){
                    tempQueue.add(node.right);
                }

            }
            if(!tempVisitedNodes.isEmpty()){
                result.add(tempVisitedNodes);
            }
            if(tempQueue.isEmpty()){
                break;
            } else {
                nodesInQueue = tempQueue;
            }
            

        }

        return result;
    }
}