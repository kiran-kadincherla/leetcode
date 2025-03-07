class Solution {
    public boolean[] sieve(int right){
        boolean[] isPrime= new boolean[right+1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;
        for(int i=2;i*i<=right;i++){
            if(isPrime[i]){
                for(int j=i*i;j<=right;j+=i){
                    isPrime[j] = false;
                }
            }
        }
        return isPrime;
    }

    public int[] closestPrimes(int left, int right) {
        boolean[] isPrime = sieve(right);
        List<Integer> primeNumberList = getPrimeNumbers(isPrime, left);
        if(primeNumberList.size() < 2 ){
            return new int[]{-1,-1};
        }
        return minDifference(primeNumberList);
    }
    public List<Integer> getPrimeNumbers(boolean[] isPrime, int left){
        List<Integer> primeNumberList= new ArrayList<>();
        for(int i=left;i<isPrime.length;i++){
            if(isPrime[i]){
                primeNumberList.add(i);
            }
        }
        return primeNumberList;

    }

    private int[] minDifference(List<Integer> numbers){
        int tempNum1 = 0;
        int tempNum2 = 0;
        int[] result = new int[2];
        int currentDiff = Integer.MAX_VALUE;
        for(int i=1;i<numbers.size();i++){
            tempNum1 = numbers.get(i-1);
            tempNum2 = numbers.get(i);
            if(tempNum2-tempNum1 < currentDiff){
                result = new int[]{tempNum1, tempNum2};
                currentDiff = tempNum2-tempNum1;
            }
        }
        return result;

    }
}