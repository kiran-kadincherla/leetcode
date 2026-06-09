class Solution {
    public int numIslands(char[][] grid) {
        int result = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j]=='1'){
                    fillIsland(grid, i,j);
                    //System.out.println("..x.."+i+"..y.."+j);
                    result++;
                }
            }
        }
        return result;
    }

    private void fillIsland(char[][] grid, int x, int y){
        //System.out.println("..x.."+x+"..y.."+y);
        if((x >= 0 && x < grid.length) && (y>=0 && y<grid[0].length)){
            if(grid[x][y]=='1') {
                grid[x][y]='2';
                fillIsland(grid, x-1,y); //top
                fillIsland(grid, x,y-1); //left
                fillIsland(grid, x,y+1); //right
                fillIsland(grid, x+1,y); //left
            }
        } 
        return;
    }


}