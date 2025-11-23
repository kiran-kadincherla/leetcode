class Solution {
    int target;

    Integer[][] dp; //memo[index][sum]

    public int lengthOfLongestSubsequence(List<Integer> nums, int target) {
        dp = new Integer[nums.size()][target+1];
        this.target=target;
        int result = getCount(nums, 0, 0);
        return result > 0 ? result : -1;
    }

    private int getCount(List<Integer> nums, int index, int sum){
        if(sum == target){
            return 0;
        }
        if(index >= nums.size() || sum > target){
            return -100000;
        }
        if(dp[index][sum] != null){
            return dp[index][sum];
        }
        
        
        int skip =  getCount(nums, index+1, sum);
        int pick = 1 + getCount(nums, index+1, sum+nums.get(index));
        int best = Math.max(skip, pick);
        dp[index][sum] = best;

        return best;
       
    }

}