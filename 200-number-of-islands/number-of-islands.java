class Solution {
     public int numIslands(char[][] grid) {
        if(grid.length == 0){
            return 0;
        }
        char[] oneDGrid = new char[grid.length * grid[0].length];
        int oneDGridIndex = 0;
        Set<Integer> visitedVertices = new HashSet<>();
        int result = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                oneDGrid[oneDGridIndex++] = grid[i][j];
            }
        }
        for (int i = 0; i < oneDGrid.length; i++) {
            if (oneDGrid[i] == '1' && !visitedVertices.contains(i)) {
                visitedVertices.addAll(dfs(grid[0].length, oneDGrid, new Stack<Integer>(), i, new HashSet<>()));
                result++;
            }
        }
        return result;
    }

    private Set<Integer> dfs(int gridRowSize, char[] oneDGrid, Stack<Integer> verticesStack, int currentVerticeIndex, Set<Integer> visitedVertices) {
        visitedVertices.add(currentVerticeIndex);
        int connectedVertexIndex = getConnectedVertexIndex(currentVerticeIndex, visitedVertices, gridRowSize, oneDGrid);
        if (connectedVertexIndex == -1) {
            if (!verticesStack.isEmpty()) {
                return dfs(gridRowSize, oneDGrid, verticesStack, verticesStack.pop(), visitedVertices);
            }
            return visitedVertices;
        }
        verticesStack.push(currentVerticeIndex);
        return dfs(gridRowSize, oneDGrid, verticesStack, connectedVertexIndex, visitedVertices);
    }

    private int getConnectedVertexIndex(int currentVerticeIndex, Set<Integer> visitedVertices, int gridRowSize, char[] oneDGrid) {
    int col = currentVerticeIndex % gridRowSize;

    // left
    if (col > 0 && oneDGrid[currentVerticeIndex - 1] == '1' && !visitedVertices.contains(currentVerticeIndex - 1)) {
        return currentVerticeIndex - 1;
    }
    // right
    if (col < gridRowSize - 1 && oneDGrid[currentVerticeIndex + 1] == '1' && !visitedVertices.contains(currentVerticeIndex + 1)) {
        return currentVerticeIndex + 1;
    }
    // down
    if (currentVerticeIndex + gridRowSize < oneDGrid.length && oneDGrid[currentVerticeIndex + gridRowSize] == '1' && !visitedVertices.contains(currentVerticeIndex + gridRowSize)) {
        return currentVerticeIndex + gridRowSize;
    }
    // up
    if (currentVerticeIndex - gridRowSize >= 0 && oneDGrid[currentVerticeIndex - gridRowSize] == '1' && !visitedVertices.contains(currentVerticeIndex - gridRowSize)) {
        return currentVerticeIndex - gridRowSize;
    }

    return -1;
}
}