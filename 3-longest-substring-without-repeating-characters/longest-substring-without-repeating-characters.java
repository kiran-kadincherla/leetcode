class Solution {

//    map(character, index)
//    int start = 0
//    int result = 0;
//    for(0<n)
//     index = map.getOrDefault(-1);
//     if(index!=-1)
//         start = index+1;
//     result = result < i - start + 1 ? i - start + 1 : result;
//     map.put(s.charAt(i), i);

//     return result;


    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> indexesMap = new HashMap<>();
        int start = 0;
        int result = 0;
        for(int i=0;i<s.length();i++){
            int index = indexesMap.getOrDefault(s.charAt(i),-1);
            if(index!=-1 && index>=start)
                start = index+1;
            result = result < i - start + 1 ? i - start + 1 : result;
            indexesMap.put(s.charAt(i), i);
        }
        return result;
    }
}