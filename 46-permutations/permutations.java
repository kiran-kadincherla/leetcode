class Solution {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        generatePermutation(nums, new ArrayList<>());
        return result;
    }

    public void generatePermutation(int[] nums, List<Integer> currentPermutation){
        if(currentPermutation.size() == nums.length){
            result.add(new ArrayList<>(currentPermutation));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(currentPermutation.contains(nums[i])){
                continue;
            }
            currentPermutation.add(nums[i]);
            generatePermutation(nums, currentPermutation);
            currentPermutation.remove(currentPermutation.size()-1);
        }
        
    }
}