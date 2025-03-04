class Solution {
    public boolean checkPowersOfThree(int n) {
                int maxPow = (int) (Math.log(n)/Math.log(3));

        return checkPowersOfThree(n,0,maxPow);
    }

       public boolean checkPowersOfThree(int n, int pow, int maxPow){
        if(n==0) {
            return true;
        }
        if(pow > maxPow) {
            return false;
        }
        boolean skipCase = checkPowersOfThree(n, pow+1, maxPow);
        boolean passCase = checkPowersOfThree(n-(int)Math.pow(3,pow), pow+1, maxPow);

        return skipCase || passCase;
    }
}