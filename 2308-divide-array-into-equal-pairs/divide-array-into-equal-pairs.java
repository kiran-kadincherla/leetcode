class Solution {
   public boolean divideArray(int[] nums) {
        Map<Integer, Integer> numsCount = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            numsCount.put(nums[i], numsCount.getOrDefault(nums[i], 0) + 1);
        }
        for(Integer val : numsCount.values()){
            if(val%2 == 1){
                return false;
            }
        }
        return true;
    }

    
}