class Solution {
    int totalCount = 0;
    int dp[][];
    public int uniquePaths(int m, int n) {
        dp = new int[m][n];
        for(int i=0;i<m;i++){
            Arrays.fill(dp[i], -1);
        }
        return getCount(m, n, 0, 0);
    }

    private int getCount(int m, int n, int rowIndex, int colIndex){
        if(rowIndex >= m || colIndex >= n){
            return 0;
        }
        if(dp[rowIndex][colIndex] != -1){
            return dp[rowIndex][colIndex];
        }
        if(rowIndex == m-1 && colIndex == n-1){
            return 1;
        }
        int down = getCount(m, n, rowIndex+1, colIndex);
        int right = getCount(m, n, rowIndex, colIndex+1);
        dp[rowIndex][colIndex] = down + right;
        return dp[rowIndex][colIndex];
    }
}