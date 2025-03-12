class Solution {
      public int maximumCount(int[] nums) {
        int noOfNegativeNumbers = 0;
        int noOfPositiveNumbers = 0;

        for(int i=0;i<nums.length;i++){
            if(nums[i] < 0 ){
                noOfNegativeNumbers++;
            } else if(nums[i] > 0 ){
                noOfPositiveNumbers = nums.length-i;
                break;
            }
        }
        return Math.max(noOfNegativeNumbers, noOfPositiveNumbers);
    }
}