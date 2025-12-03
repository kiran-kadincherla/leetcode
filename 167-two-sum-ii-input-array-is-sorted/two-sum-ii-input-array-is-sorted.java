class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int smaller = 0;
        int larger = numbers.length-1;
        int result1=0;
        int result2=0;
        while(smaller < larger){
            if(numbers[smaller]+numbers[larger]==target){
                result1 = smaller;
                result2 = larger;
                break;
            } else if(numbers[smaller]+numbers[larger]>target){
                larger--;
            } else {
                smaller++;
            }
        }
        return new int[]{result1+1, result2+1};
    }
}