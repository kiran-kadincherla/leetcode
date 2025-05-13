class Solution {
public int lengthAfterTransformations(String s, int t) {
    final int MOD = 1_000_000_007;

    // Store transformation rules: a → b, ..., z → "ab"
    String[] nextChar = new String[26];
    for (char c = 'a'; c < 'z'; c++) {
        nextChar[c - 'a'] = String.valueOf((char) (c + 1));
    }
    nextChar['z' - 'a'] = "ab";

    // Initialize count of characters from the input string
    long[] charCount = new long[26];
    for (char ch : s.toCharArray()) {
        charCount[ch - 'a']++;
    }

    // Apply transformations t times
    for (int i = 0; i < t; i++) {
        charCount = transform(charCount, nextChar, MOD);
    }

    // Sum all character counts modulo MOD
    long result = 0;
    for (long count : charCount) {
        result = (result + count) % MOD;
    }

    return (int) result;
}

private long[] transform(long[] currentCount, String[] nextChar, int MOD) {
    long[] newCount = new long[26];

    for (int i = 0; i < 26; i++) {
        long count = currentCount[i];
        if (count > 0) {
            String transformed = nextChar[i];
            for (char ch : transformed.toCharArray()) {
                newCount[ch - 'a'] = (newCount[ch - 'a'] + count) % MOD;
            }
        }
    }

    return newCount;
}


}