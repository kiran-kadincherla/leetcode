class Solution {
    public int search(int[] nums, int target) {
        return binarySearch(nums, target);
    }

    private int binarySearch(int[] nums, int target){
        int start = 0;
        int end=nums.length-1;
        int result = -1;
        while(start <= end){
            int mid = start + ((end-start)/2);
            if(nums[mid]==target){
                result = mid;
                break;
            } else if(nums[start] <= nums[mid]){ //left side sorted 
                if(target >= nums[start] && target < nums[mid]) //item present in sorted side
                    end = mid-1;
                else {
                    start = mid+1; // we will check on the right
                }
            } else { //right sidee is sorted
                if(target > nums[mid] && target <= nums[end]){ //item present on sorted side
                    start = mid+1;
                } else { //item present on unsorted side i.e.., left side
                    end = mid-1;
                }
            }
        }
        return result;
    }


    // bs(nums, target){
    //     int start = 0;
    //     end=nums.length-1;
    //     while(start <= end){
    //         int mid = end - ((end+start)/2);
    //         if(nums[mid]==target){
    //             return mid;
    //         } else if(nums[start] <= nums[mid]){ //left side sorted 
    //             if(target >= nums[start] && target <= nums[mid-1]) //item present in sorted side
    //                 end = mid-1;
    //             else {
    //                 start = mid+1; // we will check on the right
    //             }
    //         } else { //right sidee is sorted
    //             if(target >= nums[mid+1] && target <= nums[end]){ //item present on sorted side
    //                 start = mid+1;
    //             } else { //item present on unsorted side i.e.., left side
    //                 end = mid-1;
    //             }
    //         }
    //     }
    // }
    
}