class Solution {
    int startIndex=Integer.MAX_VALUE;
    int endIndex=Integer.MIN_VALUE;
    public int[] searchRange(int[] nums, int target) {
        int start = 0;
        int end = nums.length-1;
        
        int index = binarySearch(start, end, target, nums);
        //System.out.println("index.."+index);
        if(index==-1){
            return new int[]{-1,-1};
        } else {
            binarySearchOnSingleDirection(0, index, target, nums, true);
            binarySearchOnSingleDirection(index, end, target, nums, false);
            return new int[]{startIndex, endIndex};
        }
        
    }

    int binarySearch(int start, int end, int target, int[] nums){
        int index=-1;
        if(start <= end){
            int mid = start + ((end-start)/2);
            //System.out.println("mid.."+mid);
            if(nums[mid]==target){
                return mid;
            } else if(nums[mid]<target) {
                return binarySearch(mid+1, end, target, nums);
            } else {
                return binarySearch(start, mid-1, target, nums);
            } 
        }
        return index;
    }

    void binarySearchOnSingleDirection(int start, int end, int target, int[] nums, boolean isLeft){
        if(start <= end){
            int mid = start + ((end-start)/2);
            // if(!isLeft)
            //     System.out.println("mid.."+mid+" .. start.. "+start+".. end.. "+ end);
            if(nums[mid]==target){
                if(mid < startIndex){
                    startIndex=mid;
                }
                if(mid > endIndex){
                    endIndex=mid;
                }
                if(isLeft){
                    binarySearchOnSingleDirection(start, mid-1, target, nums, isLeft);
                } else {
                    binarySearchOnSingleDirection(mid+1, end, target, nums, isLeft);
                }
            } else if(nums[mid]<target) {
                 binarySearchOnSingleDirection(mid+1, end, target, nums, isLeft);
            } else {
                 binarySearchOnSingleDirection(start, mid-1, target, nums, isLeft);
            } 
        }
    }


}