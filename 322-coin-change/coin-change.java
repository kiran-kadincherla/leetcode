class Solution {
    int[] coins;
    int memo12[][] = new int[12][10001];
    public int coinChange(int[] coins, int amount) {
        if(amount >=1){
            this.coins = coins;
            for(int i=0;i<12;i++){
                Arrays.fill(memo12[i], -2);
            }
            int minCoins = getMinCoins(0, amount);
            if(minCoins == Integer.MAX_VALUE){
                return -1;
            }
            return minCoins;
        } else {
            return 0;
        }
        
    }

     private int getMinCoins(int index, int balanceAmount){
        if (balanceAmount == 0) return 0;
        if(balanceAmount < 0){
            return Integer.MAX_VALUE;
        }
        if(memo12[index][balanceAmount] != -2){
            //System.out.println("getting from memo");
            return memo12[index][balanceAmount];
        }
        if(balanceAmount-coins[index] == 0){
            return 1;
        }
        int min = Integer.MAX_VALUE;

        for(int i=0;i<coins.length;i++){
            int result = getMinCoins(i, balanceAmount-coins[i]);
            if (result != Integer.MAX_VALUE) { // ✅ prevent overflow
                min = Math.min(min, result + 1);
            }
        }
        memo12[index][balanceAmount] = min;
        return min;

    }
}