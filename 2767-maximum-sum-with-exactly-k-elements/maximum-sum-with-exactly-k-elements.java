class Solution {
    public int maximizeSum(int[] nums, int k) {
        Arrays.sort(nums);
        int num = nums[nums.length-1];
        int counter = 0;
        int sum = 0;

        while(k>0){
            sum += num+counter;
            counter++;
            k--;
        }
        return sum;
    }
}