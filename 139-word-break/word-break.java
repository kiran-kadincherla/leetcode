class Solution {
    Boolean[] memo;
    public boolean wordBreak(String s, List<String> wordDict) {
        memo = new Boolean[s.length()+1];
        Set<String> wordDictSet = new HashSet<>(wordDict);
        Arrays.fill(memo, null);
        return isPossible(s, wordDictSet, 0);
    }

    private boolean isPossible(String s, Set<String> wordDict, int currentIndex){
        if(currentIndex == s.length()){
            return true;
        }
        if(memo[currentIndex]!=null){
            return memo[currentIndex];
        }
        StringBuilder sb = new StringBuilder();
        List<Integer> indexes = new ArrayList<>();
        for(int i=currentIndex;i<s.length();i++){
            sb.append(s.charAt(i));
            if(wordDict.contains(sb.toString())){
                indexes.add(i);
            }
        }
        if(indexes.isEmpty()){
            return false;
        } else {
            for(Integer index : indexes){
                boolean result = isPossible(s, wordDict, index+1);
                memo[index+1] = result;
                if(result == true){
                    return true;
                }
            }
        }
        return false;
    }
}