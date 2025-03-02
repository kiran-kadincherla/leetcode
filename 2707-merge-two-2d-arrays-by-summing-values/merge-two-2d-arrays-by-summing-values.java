class Solution {

            public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        Map<Integer, Integer> resultMap = new TreeMap<>();
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

        int index = 0;
        for(Map.Entry<Integer, Integer> entry : resultMap.entrySet()){
            nums3[index][0] = entry.getKey();
            nums3[index++][1] = entry.getValue();
        }
        return nums3;
    }
}