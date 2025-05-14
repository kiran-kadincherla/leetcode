class Solution {
public int lengthAfterTransformations(String s, int t) {
        Map<Character, String> nextChar = new HashMap<>();
        Map<Character, Long> charCountPrimary = new HashMap<>();
        Long[] charCountArr = new Long[26];
        for (char c = 'a'; c < 'z'; c++) {
            nextChar.put(c, String.valueOf((char)(c + 1)));
        }
        nextChar.put('z', "ab");

        for (char c = 'a'; c <= 'z'; c++) {
            charCountArr[c-'a'] = 0L;
        }

        for(char value : s.toCharArray()){
            charCountArr[value-'a'] = (charCountArr[value-'a'] + 1);
        }

        for(int i=0;i<t;i++){
            charCountArr = getCharCount(nextChar, charCountArr);
        }

        long result = 0;
        final int MOD = 1_000_000_007;
        for(int i=0;i<charCountArr.length;i++){
            result = (result + charCountArr[i]) % MOD;
        }

        return (int) result;
    }

    private Long[] getCharCount(Map<Character, String> nextChar, Long[] currentCount){
        Long[] charCountArr = new Long[26];
        final int MOD = 1_000_000_007;

        for (char c = 'a'; c <= 'z'; c++) {
            charCountArr[c-'a'] = 0L;
        }

        for(int i=0;i<currentCount.length;i++){
            if(currentCount[i] > 0){
                String value = nextChar.get((char)(i+'a'));
                for(char c : value.toCharArray()){
                    int index = c - 'a';
                    Long count = currentCount[i] + charCountArr[index];
                    charCountArr[index] = count % MOD;
                }
            }
        }
        return charCountArr;
    }
}