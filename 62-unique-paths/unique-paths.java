class Solution {

    int[][] memo;
    public int uniquePaths(int m, int n) {
        memo = new int[m][n];
        Arrays.stream(memo).forEach(x->Arrays.fill(x, -1));
        return getCount(m,n,0,0);
    }

    private int getCount(int m, int n, int top, int right){
        if(top >= m || right >= n){
            return 0;
        }
        if(top == m-1 && right == n-1){
            return 1;
        }
        if(memo[top][right]!=-1){
            return memo[top][right];
        }
        int count1 = getCount(m,n,top+1, right);
        int count2 = getCount(m,n,top, right+1);
        memo[top][right] = count1+count2;
        return count1+count2;
    }
}