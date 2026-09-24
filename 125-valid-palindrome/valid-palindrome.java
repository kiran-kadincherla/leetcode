class Solution {
    public boolean isPalindrome(String s) {
        String sanitizedString = getSanitizedString(s);
        //System.out.println(sanitizedString + " .. "+ new StringBuilder(sanitizedString).reverse());
        String reversed = new StringBuilder(sanitizedString).reverse().toString();
        return sanitizedString.equals(reversed);
    }

    private String getSanitizedString(String input){
        StringBuilder sanitizedString = new StringBuilder();
        for(int i=0;i<input.length();i++){
            int character = input.charAt(i);
            if ((character >= 65 && character <= 90) ||
                (character >= 97 && character <= 122) ||
                (character >= 48 && character <= 57)){
                sanitizedString.append(Character.toLowerCase(input.charAt(i)));
            }
        }
        return sanitizedString.toString();

    }
}