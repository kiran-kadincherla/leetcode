class Solution {
   public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> prevCount = new HashMap<>();
        prevCount.put(0,1);
        int count = 0;
        int sum = 0;

        for(int i=0;i<nums.length;i++){
            sum += nums[i];
            count += prevCount.getOrDefault(sum - k, 0); 
            prevCount.put(sum, prevCount.getOrDefault(sum,0)+1);
        }
        return count;
    }
}