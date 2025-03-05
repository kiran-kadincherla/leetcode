class Solution {
    public String mergeAlternately(String word1, String word2) {
        int len1=word1.length();
        int len2=word2.length();
        int i=0;
        int j=0;
        String concatString="";
        while(i<len1 && j<len2){
           concatString = concatString.concat(String.valueOf(word1.charAt(i++))).concat(String.valueOf(word2.charAt(j++)));
        }
        while(i<len1){
            concatString = concatString.concat(String.valueOf(word1.charAt(i++)));
        }
        while(j<len2){
            concatString = concatString.concat(String.valueOf(word2.charAt(j++)));
        }
        return concatString;
    }
}