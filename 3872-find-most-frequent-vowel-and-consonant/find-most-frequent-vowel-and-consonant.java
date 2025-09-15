class Solution {
    public int maxFreqSum(String s) {
        Set<Character> vowelSet = new HashSet<>();
        vowelSet.add('a');
        vowelSet.add('e');
        vowelSet.add('i');
        vowelSet.add('o');
        vowelSet.add('u');
        Map<Character, Integer> vowelsCountMap = new HashMap<>();
        Map<Character, Integer> consonentCountMap = new HashMap<>();
        PriorityQueue<Map.Entry<Character, Integer>> vowelsCount = new PriorityQueue<>((a,b) -> b.getValue() - a.getValue());
        PriorityQueue<Map.Entry<Character, Integer>> consonentCount = new PriorityQueue<>((a,b) -> b.getValue() - a.getValue());

        for(int i=0;i<s.length();i++){
            if(vowelSet.contains(s.charAt(i))){
                vowelsCountMap.put(s.charAt(i), vowelsCountMap.getOrDefault(s.charAt(i), 0)+1);
            } else {
                consonentCountMap.put(s.charAt(i), consonentCountMap.getOrDefault(s.charAt(i), 0)+1);
            }
        }

        vowelsCount.addAll(vowelsCountMap.entrySet());
        consonentCount.addAll(consonentCountMap.entrySet());
        int count =0;

        if(!vowelsCount.isEmpty()){
            count += vowelsCount.remove().getValue();
        }
        if(!consonentCount.isEmpty()){
            count += consonentCount.remove().getValue();
        }

        return count;
        
    }
}