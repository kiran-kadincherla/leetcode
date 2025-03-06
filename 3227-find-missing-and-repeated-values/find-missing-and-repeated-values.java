class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int length = grid.length;
        int countArrLen = (int) Math.pow(length,2)+1;
        int[] countArr = new int[countArrLen];
        int[] result = new int[2];

        for(int i=0;i<countArrLen;i++){
            countArr[i] = 0;
        }

        for(int i=0;i<length;i++){
            for(int j=0;j<length;j++){
                if(countArr[grid[i][j]] == 0){
                    countArr[grid[i][j]] = grid[i][j];
                } else {
                    result[0] = grid[i][j];
                }
            }
        }

        for(int i=1;i<countArrLen;i++){
            if(countArr[i] == 0){
                result[1] = i;
            }
        }

        return result;
    }
}