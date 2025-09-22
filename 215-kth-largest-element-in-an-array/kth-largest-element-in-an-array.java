class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)-> b-a);
        for(int i=0;i<nums.length;i++){
            pq.add(nums[i]);
        }
        for(int i=1;i<k;i++){
            pq.remove();
        }
        return pq.remove();
    }
}