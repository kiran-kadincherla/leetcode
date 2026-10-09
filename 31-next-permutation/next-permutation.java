class Solution {


    public void nextPermutation(int[] nums) {
        int index=-1;
        for(int i=nums.length-2;i>=0;i--){
            if(nums[i]<nums[i+1]){
                index=i;
                break;
            }
        }
        System.out.print("index"+index);
        if(index!=-1){
            int smallestIndex = getSmallestNumberIndex(nums, index);
            System.out.print("smallestIndex"+smallestIndex);
            int temp = nums[smallestIndex];
            nums[smallestIndex] = nums[index];
            nums[index] = temp;
            
        }
        reverse(index,nums);
        
    }

    private int getSmallestNumberIndex(int[] nums, int index){
        int smallestIndex = -1;
        for(int i=nums.length-1;i>=index+1;i--)
        {
            if(nums[i] > nums[index]){
                smallestIndex=i;
                break;
            }
        }
        return smallestIndex;
    }

    private void reverse(int index, int[] nums){
        int left = index+1;
        int right = nums.length-1;
        while(left < right){
            int temp = nums[left];
            nums[left++]=nums[right];
            nums[right--]=temp;
        }
    }
}