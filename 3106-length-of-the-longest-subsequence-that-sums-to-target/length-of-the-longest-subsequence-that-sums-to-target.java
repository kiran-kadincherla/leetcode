class Solution {
    int[][] dp;
    List<Integer> nums;
    public int lengthOfLongestSubsequence(List<Integer> nums, int target) {
        dp = new int[1001][1001];
        this.nums = nums;
        for (int i = 0; i < 1001; i++) {
            Arrays.fill(dp[i], -1);
        }

        int ans = solve(0, target);
        if(ans < 0){
            return -1;
        }
        return ans;
    }

    public int solve(int currentIndex, int target) {
        if(target == 0){
            return 0;
        }
        if(target < 0  || currentIndex >= nums.size()){
            return Integer.MIN_VALUE;
        }
        if(dp[currentIndex][target] != -1){
            return dp[currentIndex][target];
        }
        int left =  solve(currentIndex+1, target);
        int right = 1+ solve(currentIndex+1, target-nums.get(currentIndex));
        dp[currentIndex][target] = Math.max(left, right);
        return dp[currentIndex][target];
    }
}