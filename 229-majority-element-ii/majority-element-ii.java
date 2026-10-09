class Solution {
    public List<Integer> majorityElement(int[] nums) {
        Map<Integer, Integer> countMap = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        Set<Integer> savedNumbers = new HashSet<>();

        int minCountRequired = (nums.length/3)+1;
        

        for(int i=0;i<nums.length;i++){
            if(!savedNumbers.contains(nums[i])){
                int count = countMap.getOrDefault(nums[i],0)+1;
                countMap.put(nums[i], count);
                if(count == minCountRequired){
                    result.add(nums[i]);
                    savedNumbers.add(nums[i]);
                }
            } 
        }

        return result;
        
    }


    


    
}