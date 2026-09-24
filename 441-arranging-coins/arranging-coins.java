class Solution {
    public int arrangeCoins(int n) {
        int start = 0;
        int end = (n/2)+1;
        int result = -1;
        while(start<=end){
            int mid = start + (end - start) / 2;
            if(isPossible(mid, n)){
                result = mid;
                start = mid+1;
            } else {
                end = mid-1;
            }
        }
        return result;
    }

    private boolean isPossible(int num, int totalCoins){
        return ((long) num * (num + 1) / 2) <= totalCoins;
    }

}