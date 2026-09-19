class Solution {

    // ex: 2154300
    //alogirthm for this preobkem is 
    //1. find out the vchnaging point i.e.., strating from right try finding some point which is ////lesser than previous value
    // 1st index is the place where we saw lesser numnber from right side
    // now consider that as break point and try to find some least number in the right side and it should be greater then this i.e.., 3 whiich is at 5th index
    // swap both 1 and 3 now the resulant array is 2354100 now since we want the smallest probabaility sort the right side part of the breakpoint since the values are guaranteed increasing order just reverse them from breakpoint and the final abnswer is 2300145
    // if there's no such break pooint it means already the numnber is highest permutation so return the actual input

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