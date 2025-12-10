class Solution {
    public int numIslands(char[][] grid) {
        int noOfIslands = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j]=='1'){
                    dfs(i,j,grid);
                    noOfIslands++;
                }
            }
        }
        return noOfIslands;
    }

    private List<int[]> turnIslands(List<int[]> currentLands, char[][] grid){
        if(currentLands.isEmpty() || grid.length == 0){
            return new ArrayList<>();
        }
        List<int[]> newLands = new ArrayList<>();
        for(int[] landIndex : currentLands){
            int row = landIndex[0];
            int col = landIndex[1];
            if(row-1 >= 0 && grid[row-1][col]=='1'){ //left
                grid[row-1][col]='0';
                newLands.add(new int[]{row-1, col});
            }
            if(row+1 < grid.length && grid[row+1][col]=='1'){ //right
                grid[row+1][col]='0';
                newLands.add(new int[]{row+1, col});
            }
            if(col+1 < grid[0].length && grid[row][col+1]=='1'){ //bottom
                grid[row][col+1]='0';
                newLands.add(new int[]{row, col+1});
            }
            if(col-1 >= 0 && grid[0].length-1 >= col-1 && grid[row][col-1]=='1'){ //top
                grid[row][col-1]='0';
                newLands.add(new int[]{row, col-1});
            }
        }
        return turnIslands(newLands, grid);
    }

    void dfs(int r, int c, char[][] grid) {
    if (r<0 || c<0 || r>=grid.length || c>=grid[0].length || grid[r][c]=='0') return;
    grid[r][c] = '0';
    dfs(r+1, c, grid);
    dfs(r-1, c, grid);
    dfs(r, c+1, grid);
    dfs(r, c-1, grid);
    }
}