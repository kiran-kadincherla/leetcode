class Solution {

    Integer dp[][];
    public int longestPalindromeSubseq(String s) {
        dp = new Integer[s.length()][s.length()];
        return getLongestPalindrome(s, 0, s.length()-1);
    }

    private int getLongestPalindrome(String s, int left, int right){
        if (left > right) return 0;                    
        if (left == right) return 1;  
        if(dp[left][right] != null){
            return dp[left][right];
        } 
        if(s.charAt(left)==s.charAt(right)){
            dp[left][right] = 2 + getLongestPalindrome(s, left + 1, right - 1);
        } else {
            dp[left][right] = Math.max(
                getLongestPalindrome(s, left + 1, right),
                getLongestPalindrome(s, left, right - 1)
            );
        }
        return dp[left][right];

    }
}