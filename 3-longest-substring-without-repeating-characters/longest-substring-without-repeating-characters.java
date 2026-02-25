class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> subStr = new HashMap<>();
        int longestSubStr = Integer.MIN_VALUE;
        for(int i=0;i<s.length();i++){
            if(subStr.containsKey(s.charAt(i))){
                longestSubStr = Math.max(longestSubStr, subStr.size());
                Integer index = subStr.get(s.charAt(i));
                subStr = new HashMap<>();
                for(int j=index;j<i;j++){
                    subStr.put(s.charAt(j), j);
                }
            }
            subStr.put(s.charAt(i), i);
        }
        longestSubStr = Math.max(longestSubStr, subStr.size());
        return longestSubStr;
    }
}