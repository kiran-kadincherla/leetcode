class Solution {
    public int singleNonDuplicate(int[] nums) {
        int start = 0;
        int end = nums.length-1;
        while(start <= end) {
            int mid = start + ((end-start)/2);
            //System.out.println("start "+ start + " end " +end + " mid "+mid);
            if ((mid - 1 < 0 || nums[mid] != nums[mid - 1]) &&
            (mid + 1 >= nums.length || nums[mid] != nums[mid + 1])) 
                {
                    return nums[mid];
                } else if(mid-1>=0 && nums[mid]==nums[mid-1]){
                if((mid+1)%2==0){
                    start = mid+1;
                } else {
                    end = mid-1;
                }
            } else {
                if((mid+1)%2!=0){
                    start = mid+1;
                } else {
                    end = mid-1;
                }

            }
        } 
        return -1;
    }
}