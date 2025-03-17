class Solution {
    Map<Integer, Integer> memo;
    public int rob(int[] nums) {
        memo = new HashMap<>();
        return getMaxProfit(nums, 0);
    }


    private int getMaxProfit(int[] nums, int currentIndex) {
        if(currentIndex >= nums.length){
            return 0;
        }
        if(memo.containsKey(currentIndex)){
            return memo.get(currentIndex);
        } 
        int pick = nums[currentIndex] + getMaxProfit(nums, currentIndex+2);
        int skip = getMaxProfit(nums, currentIndex+1);

        int maxProfit = Math.max(pick, skip);
        memo.put(currentIndex, maxProfit);
        return maxProfit;
    }
}