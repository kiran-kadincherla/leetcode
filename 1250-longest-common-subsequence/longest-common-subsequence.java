class Solution {
    String text1 = ""; String text2 = "";
    private int[][] memo;

    public int longestCommonSubsequence(String text1, String text2) {
        this.text1 = text1;
        this.text2 = text2;
        int m = text1.length();
        int n = text2.length();
        memo = new int[m][n];
        
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        return LCS(m-1, n-1);
    }

    private int LCS(int index1, int index2){
        if(index1 < 0 || index2 < 0){
            return 0;
        }

        if (memo[index1][index2] != -1) return memo[index1][index2];

        if(text1.charAt(index1) == text2.charAt(index2)) {
            memo[index1][index2] = 1 + LCS(index1-1, index2-1);
        }
        if(text1.charAt(index1) != text2.charAt(index2)) {
            memo[index1][index2] = Math.max(LCS(index1, index2-1), LCS(index1-1, index2));
        }
        return memo[index1][index2];
    }


}