class Solution {


    // here are the multiple cases where we can expect peak and our task is to point mid to that peak

    // 1. at the starting of the array



    public int findPeakElement(int[] nums) {
        if(nums.length >= 2){
            if(nums[0]>nums[1]){
                return 0;
            }
            if(nums[nums.length-1]>nums[nums.length-2]){
                return nums.length-1;
            }
            int start = 1;
            int last = nums.length-2;
            return binarySearch(start, last, nums);
        } else{
            return 0;
        } 
    }

    private int binarySearch(int start, int end, int[] nums){
        if(start <= end){
            int mid = start + ((end-start)/2);
            //System.out.println("mid"+mid);
            if(nums[mid] > nums[mid-1] && nums[mid] > nums[mid+1]){
                return mid;
            }
            else if(nums[mid] > nums[mid-1]){
                return binarySearch(mid+1, end, nums);
            } else {
                return binarySearch(start, mid-1, nums);
            }
        }
        return -1;
    }
}