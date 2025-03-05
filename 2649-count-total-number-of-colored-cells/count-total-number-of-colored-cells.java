class Solution {
    public long coloredCells(int n) {
       int addend = 4;
       long result = 1;
       for(int i=1;i<n;i++){
            result += addend;
            addend += 4;
       }
       return result;
    }
}