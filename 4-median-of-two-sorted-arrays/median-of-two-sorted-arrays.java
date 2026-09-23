class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        return getMedian(nums1, nums2);
    }

    private double getMedian(int[] nums1, int[] nums2){
        int totalLength = nums1.length+nums2.length;
        boolean isNum1Smaller = nums1.length <= nums2.length;
        int l1=1;
        int l2=1;
        int r1=0;
        int r2=0;
        int low1=0;
        int low2=0;
        int high1=nums1.length;
        int high2=nums2.length;
        double result = 0;
        int noOFItemsRequired = 0;
        int leftSize = 0;
        
        while(low1 <= high1 && low2 <= high2){
            int mid=0;
            if(isNum1Smaller){
                mid=low1+((high1-low1)/2);
                if(mid==0){
                    l1 = Integer.MIN_VALUE;
                } else {
                    l1 = nums1[mid-1];
                }
                if(nums1.length-1 >= mid ){
                    r1 = nums1[mid];
                } else {
                    r1 = Integer.MAX_VALUE;
                }
                leftSize = (totalLength + 1) / 2;
                noOFItemsRequired = leftSize - mid;
                if (noOFItemsRequired > 0) {
                    l2 = nums2[noOFItemsRequired - 1];
                } else {
                    l2 = Integer.MIN_VALUE;
                }
                if (noOFItemsRequired < nums2.length) {
                    r2 = nums2[noOFItemsRequired];
                } else {
                    r2 = Integer.MAX_VALUE;
                }
            } else {
                mid=low2+((high2-low2)/2);
                if(mid==0){
                    l1 = Integer.MIN_VALUE;
                } else {
                    l1 = nums2[mid-1];
                }
                if(nums2.length-1 >= mid ){
                    r1 = nums2[mid];
                } else {
                    r1 = Integer.MAX_VALUE;
                }
                leftSize = (totalLength + 1) / 2;
                noOFItemsRequired = leftSize - mid;
                if (noOFItemsRequired > 0) {
                    l2 = nums1[noOFItemsRequired - 1];
                } else {
                    l2 = Integer.MIN_VALUE;
                }
                if (noOFItemsRequired < nums1.length) {
                    r2 = nums1[noOFItemsRequired];
                } else {
                    r2 = Integer.MAX_VALUE;
                }
            }
            // System.out.println("l1. "+l1 + " l2.."+ l2 + " r1 "+r1 + " r2 " + r2 +" noOFItemsRequired "+ noOFItemsRequired + "mid..");
            if(l1 <= r2 && l2 <= r1){
                if(totalLength%2==0){
                    //System.out.println("test..."+ Math.max(l1,l2) + " Math.min(r1,r2) " + Math.min(r1,r2));
                    double leftMax = Math.max(l1,l2);
                    double rightMin = Math.min(r1,r2);
                    double total = leftMax+rightMin;
                    result = total/2;
                    //System.out.println("result..."+ result +" total "+total);
                } else {
                    result = l1 > l2 ? l1 : l2;
                }
                break;
            } else if( l1 > r2) {
                if(isNum1Smaller){
                    high1 = mid-1;
                }
                else{
                    high2 = mid-1;
                }
            } else {
                if(isNum1Smaller){
                    low1 = mid+1;
                }
                else{
                    low2 = mid+1;
                }
            }
        }
        return result;



    }
}