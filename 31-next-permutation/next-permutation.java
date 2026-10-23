import java.util.*;

public class Solution {
    public void nextPermutation(int[] nums) {
        int pivot=nums.length-2;
        while(pivot>=0 && nums[pivot]>=nums[pivot+1]){
            pivot--;
        }
        if(pivot != -1){
            int right = nums.length-1;
            while(right>pivot && nums[pivot]>=nums[right]){
                right--;
            }
            int temp = nums[pivot];
            nums[pivot]=nums[right];
            nums[right]=temp;
        }
        int start = pivot+1;
        int end = nums.length-1;
        int temp = -1;
            while(start<end){
                temp = nums[start];
                nums[start++] = nums[end];
                nums[end--] = temp;
            }
    }
}
