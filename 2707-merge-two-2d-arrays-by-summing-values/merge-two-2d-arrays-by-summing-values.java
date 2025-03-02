class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        Map<Integer, Integer> resultMap = new HashMap();
        for (int i = 0; i < nums1.length; i++) {
            resultMap.put(nums1[i][0], nums1[i][1]);
        }

        for (int i = 0; i < nums2.length; i++) {
            if (resultMap.containsKey(nums2[i][0])) {
                Integer currentValue = resultMap.get(nums2[i][0]);
                resultMap.put(nums2[i][0], currentValue + nums2[i][1]);
            } else {
                resultMap.put(nums2[i][0], nums2[i][1]);
            }

        }

        int[][] nums3 = new int[resultMap.size()][2];

        int[] keys = new int[resultMap.size()];
        int index = 0;
        for(Integer key : resultMap.keySet()){
            keys[index++] = key;
        }
        Arrays.sort(keys);
        for (int i=0;i<keys.length;i++){
            nums3[i][0] = keys[i];
            nums3[i][1] = resultMap.get(keys[i]);
        }
        return nums3;
    }
}