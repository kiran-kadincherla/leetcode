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
class BSTIterator {
    Queue<Integer> itemsInOrder = new LinkedList<>();
    public BSTIterator(TreeNode root) {
        itemsInOrder = inOrder(root, itemsInOrder);
    }

    public int next() {
        if(!itemsInOrder.isEmpty()){
            return itemsInOrder.poll();
        }
        return -1;
        
    }

    public boolean hasNext() {
        return !itemsInOrder.isEmpty();
    }

    private Queue<Integer> inOrder(TreeNode root, Queue<Integer> itemsInOrder){
        if(root == null){
            return null;
        }
        inOrder(root.left, itemsInOrder);
        itemsInOrder.add(root.val);
        inOrder(root.right, itemsInOrder);
        return itemsInOrder;
    }
}




/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */