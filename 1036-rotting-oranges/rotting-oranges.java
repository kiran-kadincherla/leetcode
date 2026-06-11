class Solution {
    int maxRow;
    int maxCol;
    Queue<int[]> indicesQueue;
    public int orangesRotting(int[][] grid) {
        indicesQueue = new LinkedList<>();
        List<Integer> rottenIndeces = new ArrayList<>();
        maxRow = grid.length;
        maxCol = grid[0].length;
        int result = 0;
        
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j]==2){
                    indicesQueue.offer(new int[]{i,j});
                }
            }
        }

        while(!indicesQueue.isEmpty()){
            int size = indicesQueue.size();
            for(int i=0;i<size;i++){
                int[] index = indicesQueue.poll();
                rottenIndeces.addAll(fill(grid, index[0], index[1]));
            }
            if(!indicesQueue.isEmpty())
                result++;
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
        //System.out.println("rack.."+i+"..j.."+j);
        List<Integer> rottenIndeces = new ArrayList<>();
            if(i-1>=0 && grid[i-1][j]==1){ //top
                grid[i-1][j]=2;
                indicesQueue.offer(new int[]{i-1,j});
            }
            if(i+1<grid.length && grid[i+1][j]==1){ //bottom
                grid[i+1][j]=2;
                indicesQueue.offer(new int[]{i+1,j});
            }
            if(j-1>=0 && grid[i][j-1]==1){ //left
                grid[i][j-1]=2;
                indicesQueue.offer(new int[]{i,j-1});
            }
            if(j+1<grid[0].length && grid[i][j+1]==1){ //right
                grid[i][j+1]=2;
                indicesQueue.offer(new int[]{i,j+1});
            }
            return rottenIndeces;
    }

    private int getOneDArrayIndexCount(int i, int j){
            int index = (i * maxCol) + j;
            //System.out.println("final index."+ index);
            return index;
    }
}