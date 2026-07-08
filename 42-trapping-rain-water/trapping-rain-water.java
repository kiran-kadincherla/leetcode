class Solution {
    public int trap(int[] height) {
        int[] prefixMax = new int[height.length];
        int[] postfixMax = new int[height.length];
        int prev = height[0];
        int result = 0;

        for(int i=0;i<height.length;i++){
            if(height[i]>prev){
                prefixMax[i]=height[i];
                prev=height[i];
            } else {
                prefixMax[i]=prev;
            }
        }
        prev = height[height.length-1];
        for(int i=height.length-1;i>=0;i--){
            if(height[i]>prev){
                postfixMax[i]=height[i];
                prev=height[i];
            } else {
                postfixMax[i]=prev;
            }
        }

        for(int i=0;i<height.length;i++){
            //System.out.println("i.. "+i+" prefixMax[i].. "+prefixMax[i]+" .. postfixMax[i] .. "+postfixMax[i]);
            result += Math.min(prefixMax[i], postfixMax[i])-height[i];
        }

        return result;


    
    }
}