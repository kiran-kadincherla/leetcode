class Solution {
    
    public int numberOfSubstrings(String s) {
        Map<Character, Integer> count = new HashMap<>();
        int total = 0;
        int left = 0;
        int right = 0;

        while(right < s.length()){
            char ch = s.charAt(right);
            count.put(ch, count.getOrDefault(ch,0) + 1);
            while(containsAll(count)){
                total += s.length()-right;
                ch = s.charAt(left);
                Integer charCount = count.get(ch);
                if(charCount == 1){
                    count.remove(ch);
                } else {
                    count.put(ch, charCount-1);
                }
                left++;
            }
            right++;
        }
        return total;
    }

    private boolean containsAll(Map<Character, Integer> count){
        Set<Character> requiredKeys = Set.of('a', 'b', 'c');
        return count.keySet().containsAll(requiredKeys);

    }
}