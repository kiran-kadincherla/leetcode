class Solution {
    int result = Integer.MAX_VALUE;
    public int closestCost(int[] baseCosts, int[] toppingCosts, int target) {
        for(int i=0;i<baseCosts.length;i++){
            getClosestTarget(toppingCosts, target, baseCosts[i], 0);
        }
        return result;
    }

    private void getClosestTarget(int[] toppingCosts, int target, int currentSum, int currentIndex){
        if(currentIndex >= toppingCosts.length){
            int diff = Math.abs(target-currentSum);
            int currentDiff = Math.abs(target-result);
            if(diff < currentDiff || (diff==currentDiff && currentSum < result)){
                result = currentSum;
            }
            return;
        }
        //System.out.println("index .. "+ currentIndex);
        getClosestTarget(toppingCosts, target, currentSum, currentIndex+1);
        getClosestTarget(toppingCosts, target, currentSum+toppingCosts[currentIndex], currentIndex+1);
        getClosestTarget(toppingCosts, target, currentSum+ 2 * toppingCosts[currentIndex], currentIndex+1);
    }
}