class Solution {
    boolean isPossible = false;
    Boolean[][] dp;
    public boolean canPartition(int[] nums) {
        int count = 0;
        for(int i=0;i<nums.length;i++){
            count += nums[i];
        }
        if(count % 2 != 0){
            return false;
        }
        dp = new Boolean[nums.length][count];
        for(int i=0;i<nums.length;i++){
            Arrays.fill(dp[i], null);
        }
        isPartitionPossible(nums, 0, 0, count/2);
        return isPossible;
    }

    private boolean isPartitionPossible(int[] nums, int index, int count, int target){
        if(index >= nums.length){
            //System.out.print(count +" .. count .. ");
            return count==target;
        }
        if(dp[index][count] != null){
            return dp[index][count];
        }
        boolean pick = isPartitionPossible(nums, index+1, count+nums[index], target);
        boolean leave = isPartitionPossible(nums, index+1, count, target);
        dp[index][count] = pick == true || leave == true;
        if(pick == true || leave == true){
            
            isPossible = true;
            return true;
        }
        return false;
    }
}