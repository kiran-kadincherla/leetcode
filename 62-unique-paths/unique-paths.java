class Solution {

    Integer[][] memo;
    public int uniquePaths(int m, int n) {
        memo = new Integer[m+1][n+1];
        Arrays.stream(memo).forEach(x->Arrays.fill(x, null));
        return getCount(m,n,0,0);
    }

    private int getCount(int m, int n, int top, int right){
        if(top >= m || right >= n){
            return 0;
        }
        if(top == m-1 && right == n-1){
            return 1;
        }
        if(memo[top][right]!=null){
            return memo[top][right];
        }
        int count1 = getCount(m,n,top+1, right);
        int count2 = getCount(m,n,top, right+1);
        memo[top+1][right] = count1;
        memo[top][right+1] = count2;
        return count1+count2;
    }
}