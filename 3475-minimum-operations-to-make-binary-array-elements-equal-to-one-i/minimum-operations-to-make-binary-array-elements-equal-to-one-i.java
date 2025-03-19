class Solution {
    public int minOperations(int[] nums) {
        int flips = 0;
        for(int i=0;i<nums.length-2;i++){
            if(nums[i] == 0){
                for(int j=i;j<=i+2;j++){
                    nums[j] = nums[j] ^ 1;

                }
                flips++;
            }
        }
        if(isValid(nums)){
            return flips;
        } else{
            return -1;
        }
    }

    private boolean isValid(int[] nums){
        for(int i=0;i<nums.length;i++){
            if(nums[i] == 0)
                return false;
        }
        return true;
    }
}