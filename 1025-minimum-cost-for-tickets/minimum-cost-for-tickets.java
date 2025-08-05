class Solution {
        Integer[] memo1;
    public int mincostTickets(int[] days, int[] costs) {
        memo1 = new Integer[days.length];
        return getMinCost(0, days, costs);
    }

   private int getMinCost(int currentIndex, int[] days, int[] costs) {

        if(currentIndex >= days.length){
            return 0;
        }
        if(memo1[currentIndex] != null){
            System.out.println("getting from memo");
            return memo1[currentIndex];
        }
        int oneDayPass =  Integer.MAX_VALUE, sevenDaysPass =  Integer.MAX_VALUE, oneMonthPass = Integer.MAX_VALUE;

        if(currentIndex <= days.length-1) {
            oneDayPass = costs[0] + getMinCost(currentIndex+1, days, costs);
        }

        int seventhDay = days[currentIndex] + 6;
        int thirthythDay = days[currentIndex] + 29;


        int indexAfterSeventhDay = currentIndex;
        while(indexAfterSeventhDay < days.length && days[indexAfterSeventhDay]<=seventhDay){
            indexAfterSeventhDay++;
        }

        sevenDaysPass = costs[1] + getMinCost(indexAfterSeventhDay, days, costs);

        int indexAfterthirtythDay = currentIndex;
        while(indexAfterthirtythDay < days.length && days[indexAfterthirtythDay]<=thirthythDay){
            indexAfterthirtythDay++;
        }

        oneMonthPass = costs[2] + getMinCost(indexAfterthirtythDay, days, costs);
        int result = Math.min(oneDayPass, Math.min(sevenDaysPass, oneMonthPass));
        memo1[currentIndex] = result;
        return result;
    }

}