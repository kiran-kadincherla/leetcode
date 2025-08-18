class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        return binarySearch(matrix, target);
    }

    private boolean binarySearch(int[][] matrix, int target){
        int low=0;
        int high=(matrix.length*matrix[0].length)-1;
        
        while(low <= high){
            int mid = (low+high)/2;
            int row = mid/matrix[0].length;
            int col = mid%matrix[0].length;
            System.out.println("row .."+ row + " .. "+ col + " ..mid .. " + mid);
            if(matrix[row][col] == target){
                return true;
            } else if(matrix[row][col] < target) {
                low = mid+1;
            } else {
                high = mid-1;
            }
        }
        return false;

    }
}