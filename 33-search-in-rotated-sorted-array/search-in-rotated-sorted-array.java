class Solution {
    int target;
    public int search(int[] nums, int target) {
        this.target = target;
        return binarySearch(nums, 0, nums.length-1);
    }

    private int binarySearch(int[] arr, int low,int high){
        int mid = (low+high)/2;
        if(arr[mid] == target){
            return mid;
        }
        if(low == high){
            return -1;
        }
        if(arr[mid] >=  arr[low] && (target>=arr[low] && target<arr[mid] )){ //left half is sorted
            return binarySearch(arr, low, mid-1);
        } else if(arr[mid] <=  arr[high] && (target>arr[mid] && target<=arr[high])) { //right half is sorted
            return binarySearch(arr, mid+1, high);
        } else {
            if(arr[mid] >=  arr[low]){
                return binarySearch(arr, mid+1, high);
            } else {
                return binarySearch(arr, low, mid-1);
            }
        }
    }
}