class Solution {
    public int findNumbers(int[] nums) {
        int noOfDigits=1;
        int result =0;
        for(int i=0;i<nums.length;i++){
            int num=nums[i];
            while(num>9){
                num /= 10;
                noOfDigits++;
            }
            if(noOfDigits%2==0)
                result++;
            noOfDigits=1;
        }
        return result;
        
    }
}