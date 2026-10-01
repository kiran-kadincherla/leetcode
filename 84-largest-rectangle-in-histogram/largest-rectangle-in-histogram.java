class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> indexes = new Stack<>();
        int result = -1;
        for(int i=0;i<heights.length;i++){
            if(indexes.isEmpty() || heights[i] > heights[indexes.peek()]){
                indexes.push(i);
            } else {
                while(indexes.size() > 0 && heights[i] < heights[indexes.peek()]){
                    result = Math.max(result, calculateArea(indexes, i, heights));
                }
                indexes.push(i);
            }
        }
        while (!indexes.isEmpty()) {
                result = Math.max(result, calculateArea(indexes, heights.length, heights));
        }
        return result;
        
    }

    public int calculateArea(Stack<Integer> indexes, int right, int[] heights){
        int current = indexes.pop();
        int left = indexes.isEmpty() ? -1 : indexes.peek();
        int numberOfElements = right - left - 1;
        return numberOfElements * heights[current];
    }
}