class Solution {
     public int orangesRotting(int[][] grid) {
        int[] oneDGrid = new int[grid.length*grid[0].length];
        int oneDGridIndex = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                oneDGrid[oneDGridIndex++] = grid[i][j];
            }
        }
        Map<String, Object> tomatoData = getTomatoDetails(oneDGrid);
        List<Integer> rottenIndexes = (List<Integer>) tomatoData.get("rottenIndexes");
        Integer noOfFreshOranges = (Integer) tomatoData.get("noOfFreshOranges");
        int result = 0;

        while(noOfFreshOranges > 0){
            for(Integer index : rottenIndexes) {
                rot(oneDGrid, index, grid[0].length);
            }
            tomatoData = getTomatoDetails(oneDGrid);
            rottenIndexes = (List<Integer>) tomatoData.get("rottenIndexes");
            Integer tempNoOfFreshOranges = (Integer) tomatoData.get("noOfFreshOranges");
            if(noOfFreshOranges == tempNoOfFreshOranges){
                return -1;
            } else {
                noOfFreshOranges = tempNoOfFreshOranges;
            }
            result++;
        }

        return result;
    }

    private void rot(int[] oneDGrid, int index, int rowLength){
        if(index-1 >=0 && index/rowLength == ((index-1)/rowLength) && oneDGrid[index-1] == 1){ //left
            oneDGrid[index-1]=2;
        }
        if(index+1 < oneDGrid.length && index/rowLength == ((index+1)/rowLength) && oneDGrid[index+1] == 1){ //right
            oneDGrid[index+1]=2;
        }
        if(index-rowLength >=0 && oneDGrid[index-rowLength] == 1){ //top
            oneDGrid[index-rowLength]=2;
        }
        if(index+rowLength < oneDGrid.length && oneDGrid[index+rowLength] == 1){ //bottom
            oneDGrid[index+rowLength]=2;
        }

    }

    private Map<String, Object> getTomatoDetails(int[] oneDGrid) {
        List<Integer> rottenIndexes = new ArrayList<>();
        Integer noOfFreshOranges = 0;
        Map<String, Object> tomatoData = new HashMap<>();
        for(int i=0;i<oneDGrid.length;i++){
            if(oneDGrid[i] == 2){
                rottenIndexes.add(i);
            } else if(oneDGrid[i] == 1) {
                noOfFreshOranges++;
            }
        }
        tomatoData.put("rottenIndexes", rottenIndexes);
        tomatoData.put("noOfFreshOranges", noOfFreshOranges);
        return tomatoData;
    }
}