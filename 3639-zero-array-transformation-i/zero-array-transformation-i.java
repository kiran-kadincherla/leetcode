class Solution {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int[] diffArr = new int[nums.length+1];
        int[] preSumArr = new int[nums.length];
        for (int[] query : queries) {
            diffArr[query[0]] += 1;
            diffArr[query[1] + 1] -= 1;
        }
        int sum = 0;
        for(int i=0;i<diffArr.length-1;i++){
            sum += diffArr[i];
            preSumArr[i] = sum; //will optimise this later
        }

        for(int i=0;i<preSumArr.length;i++){
            if(nums[i] - preSumArr[i] > 0){
                return false;
            }
        }
        return true;
    }
}