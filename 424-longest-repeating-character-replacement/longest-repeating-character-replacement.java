class Solution {
    int left = 0;
    int maxLength = 0;
    Map<Character, Integer> freq = new HashMap<>();
    int maxFreq = 0;
    public int characterReplacement(String s, int k) {
        for(int i=0;i<s.length();i++){
        freq.put(s.charAt(i), freq.getOrDefault(s.charAt(i), 0)+1);
        maxFreq = Math.max(freq.get(s.charAt(i)), maxFreq);
        int count = getNoOfReplacements(i-left+1);
        //System.out.println("count"+count);
        while(count>k){
                freq.put(s.charAt(left), freq.get(s.charAt(left))-1);
                //maxFreq = Math.max(freq.get(s.charAt(left)),maxFreq);
                left++;
                count = getNoOfReplacements(i-left+1);
                //System.out.println("count----"+count);
        }
        maxLength = Math.max(i-left+1, maxLength);
        }
        return maxLength;
    }

    int getNoOfReplacements(int totalChars){
        // if(freq!=null){
        //     Map.Entry<Character, Integer> top = freq.entrySet()
        // .stream()
        // .max(Map.Entry.comparingByValue())
        // .orElse(null);
        // return totalChars - top.getValue();
        // }
        // return 0;
       
       return totalChars-maxFreq; 
    }
    
}