class Solution {
     public long coloredCells(int n) {
        //since we are adding 1 + 1*4 + 2*4 + 3*4 --------- + n-1*4. so we can apply sum of natural numbers formula
        //1+4(n*(n-1)/2)= 1+2*n*(n-1)

        return 1 + 2L *n*(n-1);
    }
}