class Solution {
   public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> presum = new HashMap<>();
        presum.put(0,1);
        int sum =0;
        int result = 0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            result += presum.getOrDefault(sum-k,0);
            presum.put(sum, presum.getOrDefault(sum,0)+1);
        }
        return result;
    }
}