class Solution {
    int memo[];
    public int mincostTickets(int[] days, int[] costs) {
        memo = new int[days.length];
        Arrays.fill(memo, -1);
        return getMinCost(0, days, costs);
    }

    private int getMinCost(int currentDayIndex, int[] days, int[] costs){
        if(currentDayIndex==days.length){
            return 0;
        }
        if(memo[currentDayIndex]!=-1){
            return memo[currentDayIndex];
        }
        int oneDay = costs[0]+getMinCost(currentDayIndex+1, days, costs);
        int sevenDays = costs[1]+getMinCost(getIndex(days, currentDayIndex, days[currentDayIndex]+6), days, costs);
        int thirtyDays = costs[2]+getMinCost(getIndex(days, currentDayIndex, days[currentDayIndex]+29), days, costs);
        int min = Math.min(oneDay, sevenDays);
        int result = Math.min(min, thirtyDays);
        memo[currentDayIndex] = result;
        return result;
    }

    private int getIndex(int[] days, int currentIndex, int maxValue){
        for(int i=currentIndex;i<days.length;i++){
            if(days[i]>maxValue){
                return i;
            }
        }
        return days.length;

    }

   
}