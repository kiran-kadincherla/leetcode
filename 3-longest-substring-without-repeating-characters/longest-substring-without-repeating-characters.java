class Solution {
   
       public int lengthOfLongestSubstring(String s) {
        int p1 = 0;
        int p2 = 1;
        Set<Character> charSet = new HashSet<>();
        String currentLongestSubStr = "";
        if(s.length() < 2){
            return s.length();
        }


        charSet.add(s.charAt(p1));
        while(p2 < s.length()){
            char currentCharecter = s.charAt(p2);
            if(!charSet.contains(currentCharecter)){
                charSet.add(currentCharecter);
            } else {
                if(currentLongestSubStr.length() < charSet.size()){
                    currentLongestSubStr = s.substring(p1,p2);
                }
                while(s.charAt(p1) != currentCharecter){
                    charSet.remove(s.charAt(p1));
                    p1++;

                }
                p1++;
            }
            p2++;
        }

        if(currentLongestSubStr.length() < charSet.size()){
            currentLongestSubStr = s.substring(p1,p2);
        }

        return currentLongestSubStr.length();
    }

     

}