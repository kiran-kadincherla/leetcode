class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> repeat = new HashSet<>();
        int result = 0;
        int p1=0;
        int p2=0;
        while(p2<s.length()){
            if(repeat.contains(s.charAt(p2))) {
                result = result < p2-p1 ?  p2-p1 : result;
                System.out.println("p2.. "+p2+" p1.. "+ p1+ " .. resukt .. "+ result);
                while(!(s.charAt(p1)==s.charAt(p2))) {
                    repeat.remove(s.charAt(p1));
                    p1++;
                }
                repeat.remove(s.charAt(p1));
                p1++;
            } 
            repeat.add(s.charAt(p2));
            p2++;
        }
        result = result < p2-p1 ?  p2-p1 : result;
        return result;
    }
}