class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int largestNumber = Integer.MIN_VALUE;
        List<Boolean> result= new ArrayList<>();


        for(int i=0;i<candies.length;i++){
            if(candies[i] > largestNumber){
                largestNumber = candies[i];
            }
        }

        for(int i=0;i<candies.length;i++){
            if(candies[i]+extraCandies >= largestNumber){
                result.add(true);
            } else {
                result.add(false);
            }
        }

        return result;

    }
}