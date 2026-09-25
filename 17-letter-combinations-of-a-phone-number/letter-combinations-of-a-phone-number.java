class Solution {
    public List<String> letterCombinations(String digits) {
        Map<String, List<String>> keypad = Map.ofEntries(
            Map.entry("2", List.of("a", "b", "c")),
            Map.entry("3", List.of("d", "e", "f")),
            Map.entry("4", List.of("g", "h", "i")),
            Map.entry("5", List.of("j", "k", "l")),
            Map.entry("6", List.of("m", "n", "o")),
            Map.entry("7", List.of("p", "q", "r", "s")),
            Map.entry("8", List.of("t", "u", "v")),
            Map.entry("9", List.of("w", "x", "y", "z"))
        );

        List<List<String>> combinationList = new ArrayList<>();
        String[] individualDigits = digits.split("");
        List<String> result = new ArrayList<>();


        for(int i=0;i<individualDigits.length;i++){
            combinationList.add(keypad.get(individualDigits[i]));
        }

        // for(int i=0;i<combinationList.size();i++){
            
        // }
        generateCombinations(combinationList, 0, new String(), result);
        return result;
    
        
    }

    void generateCombinations(
        List<List<String>> combinationList,
        int currentIndex,
        String currentString,
        List<String> result) {

    if (currentIndex == combinationList.size()) {
        result.add(currentString);
        return;
    }

    for (String letter : combinationList.get(currentIndex)) {
        generateCombinations(
            combinationList,
            currentIndex + 1,
            currentString + letter,
            result
        );
    }
}
}