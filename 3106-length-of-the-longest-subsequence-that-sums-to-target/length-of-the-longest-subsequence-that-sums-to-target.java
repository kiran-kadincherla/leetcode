class Solution {

    Integer[][] memo;

    public int lengthOfLongestSubsequence(List<Integer> nums, int target) {
        memo = new Integer[nums.size()][target+1];
        Arrays.stream(memo).forEach(x->Arrays.fill(x, null));

        int result = getLongestSubSequence(nums, 0, target);
        if(result < 0){
            return -1;
        }
        return result;
    }

    public int getLongestSubSequence(List<Integer> nums, int currentIndex, int balanceAmount){
        if(balanceAmount == 0){
            return 0;
        }
        if(currentIndex >= nums.size() || balanceAmount < 0){
            return Integer.MIN_VALUE;
        }
        if(memo[currentIndex][balanceAmount]!=null){
            return memo[currentIndex][balanceAmount];
        }
        int skip = getLongestSubSequence(nums, currentIndex+1, balanceAmount);
        int pick = 1+getLongestSubSequence(nums, currentIndex+1, balanceAmount-nums.get(currentIndex));
        memo[currentIndex][balanceAmount] = Math.max(skip, pick);
        return memo[currentIndex][balanceAmount];

    }

}