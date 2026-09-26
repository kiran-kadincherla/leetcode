class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        generatePermutation(nums, new ArrayList<>(), new HashSet<>());
        return result;
    }

    public void generatePermutation(
            int[] nums,
            List<Integer> currentPermutation,
            Set<Integer> indexes) {

        if (currentPermutation.size() == nums.length) {
            result.add(new ArrayList<>(currentPermutation));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (indexes.contains(i)) {
                continue;
            }
            if (i > 0 && nums[i] == nums[i - 1] && !indexes.contains(i - 1)) {
                continue;
            }

            currentPermutation.add(nums[i]);
            indexes.add(i);
            generatePermutation(nums, currentPermutation, indexes);
            currentPermutation.remove(currentPermutation.size() - 1);
            indexes.remove(i);

        }

    }
}