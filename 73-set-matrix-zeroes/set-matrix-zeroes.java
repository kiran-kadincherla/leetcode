class Solution {
    
        public void setZeroes(int[][] matrix) {
        List<Integer> zeroRows = new ArrayList<>();
        List<Integer> zeroColumns = new ArrayList<>();
        int columnNumber = 0;
        for(int[] row : matrix){
            for(int i=0;i<row.length;i++){
                if(row[i] == 0){
                    zeroRows.add(i);
                    zeroColumns.add(columnNumber);
                }
            }
            columnNumber++;
        }
        columnNumber = 0;
        for(Integer index : zeroRows){
            int column = zeroColumns.get(columnNumber++);
            for(int i=0;i<matrix.length;i++){
                matrix[i][index] = 0;
            }
            for(int i=0;i<matrix[column].length;i++){
                matrix[column][i] = 0;
            }
        }

        //System.out.println(Arrays.deepToString(matrix));


    }
}