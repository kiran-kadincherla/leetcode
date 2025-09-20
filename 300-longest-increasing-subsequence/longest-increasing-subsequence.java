class Solution {

    int longestSubSeq = Integer.MIN_VALUE;
    int[][] dp;
    public int lengthOfLIS(int[] nums) {
        dp = new int[nums.length][nums.length];
        for(int i=0;i<nums.length;i++){
            Arrays.fill(dp[i], -1);
        }
        
        return getLongestSubSequence(nums, 0, -1);
    }

    private int getLongestSubSequence(int[] nums, int currentIndex, int prevIndex){
        
        if(currentIndex >= nums.length){
            return 0;
        }
        if(prevIndex != -1 && dp[currentIndex][prevIndex] !=-1){
            return dp[currentIndex][prevIndex];
        }
        int count1 = -1;
        int count2 = -1;
        if(prevIndex == -1 || nums[currentIndex] > nums[prevIndex]){
            count1 = 1 + getLongestSubSequence(nums, currentIndex+1, currentIndex);
        }
        count2 = getLongestSubSequence(nums, currentIndex+1, prevIndex);
        if(prevIndex!=-1)
            dp[currentIndex][prevIndex] = Math.max(count1, count2);
        return Math.max(count1, count2);
    }
}