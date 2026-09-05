class Solution {
    public int maxArea(int[] height) {
        //since it is greedy approach our aim is to always look for better result after updating the resut we will be moving the pointer whose value is lesser
        int left = 0;
        int right = height.length-1;
        int result = 0;
        while(left<right){
            int tempResult = Math.min(height[left], height[right]) * (right-left);
            //System.out.print("tempResult "+ tempResult);
            result = Math.max(tempResult, result);
            if(height[left] < height[right]){
                left++;
            } else {
                right--;
            }
        }
        return result;

    }
}