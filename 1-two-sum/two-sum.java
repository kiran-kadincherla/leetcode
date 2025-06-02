class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, List<Integer>> numMap = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            List<Integer> indexesList = numMap.getOrDefault(nums[i], new ArrayList<>());
            indexesList.add(i);
            numMap.put(nums[i], indexesList);
        }
        for(int i=0;i<nums.length;i++){
            if(numMap.containsKey(target-nums[i])) {
                List<Integer> indexesList = numMap.get(target-nums[i]);
                if(nums[i] == target-nums[i]){
                    for(Integer index : indexesList) {
                        if(index != i) {
                            return new int[]{i, index};
                        }
                    }
                } else {
                    return new int[]{i, indexesList.get(0)};
                }
            }
        }
        return new int[]{-1, -1};
    }
}