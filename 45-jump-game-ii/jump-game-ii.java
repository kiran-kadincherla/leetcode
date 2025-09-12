class Solution {
    int dp12[];
    public int jump(int[] nums) {
        dp12 = new int[nums.length];
        Arrays.fill(dp12, -1);
        return noOfSteps(nums, 0);
    }

    private int noOfSteps(int[] nums, int currentIndex){
        if(currentIndex >= nums.length-1){
            return 0;
        }
        if(dp12[currentIndex]!=-1){
            //System.out.println("getting from dp");
            return dp12[currentIndex];
        }
        int value = nums[currentIndex];
        int[] tempRes = new int[value+1];
        int minValue = Integer.MAX_VALUE;
        int minValIndex = -1;
        for(int i=1;i<=value;i++){
            tempRes[i] = noOfSteps(nums, currentIndex+i);
        }
        for(int i=1;i<=value;i++){
            if(tempRes[i] < minValue){
                minValue = tempRes[i];
                minValIndex = i;
            }
        }
        if(minValIndex != -1){
            dp12[currentIndex] = 1+minValue;
            return 1 + minValue;
        } else {
            return Integer.MAX_VALUE;
        }
    }
}