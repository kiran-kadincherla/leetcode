class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a,b) -> b.getValue()-a.getValue());
        Map<Integer, Integer> frequency = new HashMap<>();
        int[] topKElements = new int[k];
        for(int i=0;i<nums.length;i++){
            frequency.put(nums[i], frequency.getOrDefault(nums[i], 0)+1);
        }
        pq.addAll(frequency.entrySet());
        for(int i=0;i<k;i++){
            topKElements[i] = pq.remove().getKey();
        }
        return topKElements;

    }
}