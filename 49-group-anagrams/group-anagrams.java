class Solution {
 public List<List<String>> groupAnagrams(String[] strs) {
        String[] strsCpy = strs.clone();
        Map<String, Integer> uniqueIndexes = new HashMap<>();
        List<List<String>> result = new ArrayList<>();
        int index = 0;
        for (int i = 0; i < strs.length; i++) {
            char[] arr = strsCpy[i].toCharArray();
            Arrays.sort(arr);
            strsCpy[i] = new String(arr);
        }
        for (int i = 0; i < strs.length; i++) {
            List<String> anagaramsList = new ArrayList<>();
            if(uniqueIndexes.containsKey(strsCpy[i])){
                anagaramsList = result.get(uniqueIndexes.get(strsCpy[i]));
                anagaramsList.add(strs[i]);
                result.set(uniqueIndexes.get(strsCpy[i]), anagaramsList);

            } else {
                anagaramsList.add(strs[i]);
                result.add(anagaramsList);
                uniqueIndexes.put(strsCpy[i], index);
                index++;
            }
        }
        return result;
    }
}