class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        Set<Character> brokenCharacters = brokenLetters.chars().mapToObj(e -> (char)e).collect(Collectors.toSet());
        String[] words = text.split(" ");
        int count = 0; 
        for(String word : words){
            boolean broken = false;
            for(int i=0;i<word.length();i++){
                if(brokenCharacters.contains(word.charAt(i))){
                    broken = true;
                    break;
                }
            }
            if(broken == false){
                count++;
            }
        }

        return count;
        
    }
}