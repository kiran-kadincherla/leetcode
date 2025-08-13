class Solution {
    Set<String> dictionary;
    String s;
    Map<String, Boolean> memo = new HashMap<>();
    public boolean wordBreak(String s, List<String> wordDict) {
        this.s=s;
        dictionary = new HashSet<>(wordDict);
        return isValid(0);
    }
    private boolean isValid(int position){
        if(position == s.length()){
            return true;
        }
        if(memo.containsKey(s.substring(position,s.length()-1))){
            System.out.println("getting from memo" + s.substring(position, s.length()-1));
            return memo.get(s.substring(position, s.length()-1));
        }
        String newWord = "";
        for(int i=position;i<s.length();i++){
            newWord += String.valueOf(s.charAt(i));
            if(dictionary.contains(newWord) && isValid(i+1)){
                memo.put(s.substring(i, s.length()-1), true);
                return true;
            }
        }
        memo.put(s.substring(position, s.length()-1), false);
        return false;
    }
}