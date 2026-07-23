class Solution {
    Map<Character, Integer> s1FreqMap = new HashMap<>();
    Map<Character, Integer> s2FreqMap = new HashMap<>();

    public boolean checkInclusion(String s1, String s2) {
        int left = 0;
        int length = s1.length();

        for(int i=0;i<s1.length();i++){
            s1FreqMap.put(s1.charAt(i), s1FreqMap.getOrDefault(s1.charAt(i), 0)+1);
        }

        for(int right=0;right<s2.length();right++){
            if(right-left+1 > length){
                s2FreqMap.put(s2.charAt(left), s2FreqMap.get(s2.charAt(left))-1);
                left++;
            }
            s2FreqMap.put(s2.charAt(right), s2FreqMap.getOrDefault(s2.charAt(right),0)+1);
            if(containsAllPerm()){
                return true;
            }
        }
        return false;
    }

    boolean containsAllPerm(){
        for(Map.Entry<Character, Integer> current : s1FreqMap.entrySet()){
            if(current.getValue() != 0 && s2FreqMap.getOrDefault(current.getKey(), 0).intValue()
                != current.getValue().intValue()){
                return false;
            }
        }
        return true;
    }
}