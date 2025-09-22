class Solution {
    public int lengthOfLongestSubstring(String s) {
        int p1 = 0;
        int p2 = 0;
        int longestStrLen = 0;
        Set<Character> uniqueChars = new HashSet<>();
        while(p2<s.length()){
            if(uniqueChars.contains(s.charAt(p2))){
                longestStrLen = Math.max(longestStrLen, p2-p1);
                for(int i=p1;i<p2;i++){
                    if(s.charAt(i)==s.charAt(p2)){
                        p1=i+1;
                        break;
                    }
                }
            } else{
                uniqueChars.add(s.charAt(p2));
            }
            p2++;
        }
        longestStrLen = Math.max(longestStrLen, p2-p1);
        return longestStrLen;
    }
}