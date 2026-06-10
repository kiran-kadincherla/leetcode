class Solution {
    int maxRow;
    int maxCol;
    public int orangesRotting(int[][] grid) {
        Queue<Integer> indicesQueue = new LinkedList<>();
        List<Integer> rottenIndeces = new ArrayList<>();
        maxRow = grid.length;
        maxCol = grid[0].length;
        int result = 0;
        
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j]==2){
                    rottenIndeces.add(getOneDArrayIndexCount(i,j));
                }
            }
        }

        for(Integer index : rottenIndeces)
            indicesQueue.offer(index);
        


        while(!indicesQueue.isEmpty()){
            rottenIndeces = new ArrayList<>();
            while(!indicesQueue.isEmpty()){
                Integer index = indicesQueue.poll();
                rottenIndeces.addAll(fill(grid, index/maxCol, index%maxCol));
            }
            
            if(rottenIndeces.size()>0){
                System.out.println("resultttt."+result+" ..rottenIndeces.."+rottenIndeces);
                for(Integer index : rottenIndeces)
                    indicesQueue.offer(index);
                result++;
            }
            rottenIndeces = new ArrayList<>();
            
        }


        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j]==1){
                    return -1;
                }
            }
        }


        return result;
        
    }


    private List<Integer> fill(int[][] grid, int i, int j){
        System.out.println("rack.."+i+"..j.."+j);
        List<Integer> rottenIndeces = new ArrayList<>();
            if(i-1>=0 && grid[i-1][j]==1){ //top
                grid[i-1][j]=2;
                rottenIndeces.add(getOneDArrayIndexCount(i-1,j));
            }
            if(i+1<grid.length && grid[i+1][j]==1){ //bottom
                grid[i+1][j]=2;
                rottenIndeces.add(getOneDArrayIndexCount(i+1,j));
            }
            if(j-1>=0 && grid[i][j-1]==1){ //left
                grid[i][j-1]=2;
                rottenIndeces.add(getOneDArrayIndexCount(i,j-1));
            }
            if(j+1<grid[0].length && grid[i][j+1]==1){ //right
                grid[i][j+1]=2;
                rottenIndeces.add(getOneDArrayIndexCount(i,j+1));
            }
            return rottenIndeces;
    }

    private int getOneDArrayIndexCount(int i, int j){
            int index = (i * maxCol) + j;
            System.out.println("final index."+ index);
            return index;
    }
}