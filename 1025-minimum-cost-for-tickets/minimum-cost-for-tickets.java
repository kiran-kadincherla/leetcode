class Solution {
    int[] memo;
    public int mincostTickets(int[] days, int[] costs) {
        memo = new int[days[days.length-1]];
        Arrays.fill(memo, -1);
        return getMinCost(0, days, costs);
    }

    private int getMinCost(int currentDayIndex, int[] days, int[] costs){
        if(currentDayIndex >= days.length){
            return 0;
        }
        if(memo[currentDayIndex]!=-1){
            return memo[currentDayIndex];
        }
        int oneDaypassPrice = costs[0] + getMinCost(currentDayIndex+1, days, costs);
        int sevenDayIndex = getIndex(days, days[currentDayIndex]+7);
        int sevenDayPassPrice = costs[1] + getMinCost(sevenDayIndex, days, costs);
        int thirtyDayIndex = getIndex(days, days[currentDayIndex]+30);
        int thirtyDayPassPrice = costs[2] + getMinCost(thirtyDayIndex, days, costs);
        int temp = Math.min(oneDaypassPrice, sevenDayPassPrice);
        int finalResult = Math.min(temp, thirtyDayPassPrice);
        memo[currentDayIndex] = finalResult;
        return finalResult;
    }

    private int getIndex(int[] days, int maxVal){
        int index = 0;
        while(index < days.length && days[index] < maxVal){
            index++;
        }
        return index;
    }
}