class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> subStr = new HashMap<>();
        int longestSubStr = Integer.MIN_VALUE;
        int prevRepetetion = 0;
        for(int i=0;i<s.length();i++){
            if(subStr.containsKey(s.charAt(i))){
                longestSubStr = Math.max(longestSubStr, subStr.size());
                Integer index = subStr.get(s.charAt(i));
                for(int j=prevRepetetion;j<=index;j++){
                    subStr.remove(s.charAt(j));
                }
                prevRepetetion = index+1;
            }
            subStr.put(s.charAt(i), i);
        }
        longestSubStr = Math.max(longestSubStr, subStr.size());
        return longestSubStr;
    }
}