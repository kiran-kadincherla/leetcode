class Solution {
    public String longestPalindrome(String s) {
        if(s.isEmpty())
            return s;
        String result = generateSubString(s);
        return result;
    }


    private String generateSubString(String input){
        String currentPalindrome = "";
        if(input.isEmpty())
            return input;
        for(int i=0;i<input.length();i++){
            StringBuilder subString = new StringBuilder(String.valueOf(input.charAt(i)));
            for(int j=i+1;j<input.length();j++){
                subString.append(input.charAt(j));
                if (currentPalindrome.length() < subString.length()){
                    boolean result = checkPalindrome(String.valueOf(subString));
                    if(result) {
                        currentPalindrome = String.valueOf(subString);
                    }
                }
            }
        }
        return currentPalindrome.isEmpty() ? String.valueOf(input.charAt(0)) : currentPalindrome;
    }

     private boolean checkPalindrome(String word){
        int ptr1=0;
        int ptr2=word.length()-1;

        while(ptr1 < ptr2){
            if (word.charAt(ptr1) != word.charAt(ptr2)) {
               return false;
            } else {
                ptr2--;
                ptr1++;
            }
        }
        return true;
    }
}