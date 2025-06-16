class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
    if (image[sr][sc] == color) return image;

    int existingColor = image[sr][sc];
    int rows = image.length;
    int cols = image[0].length;
    Set<Integer> visited = new HashSet<>();
    dfs(image, sr, sc, existingColor, color, visited, rows, cols);
    return image;
}

private void dfs(int[][] image, int row, int col, int existingColor, int newColor, Set<Integer> visited, int rows, int cols) {
    if (row < 0 || col < 0 || row >= rows || col >= cols) return;
    int index = row * cols + col;

    if (visited.contains(index) || image[row][col] != existingColor) return;

    visited.add(index);
    image[row][col] = newColor;

    dfs(image, row - 1, col, existingColor, newColor, visited, rows, cols); // up
    dfs(image, row + 1, col, existingColor, newColor, visited, rows, cols); // down
    dfs(image, row, col - 1, existingColor, newColor, visited, rows, cols); // left
    dfs(image, row, col + 1, existingColor, newColor, visited, rows, cols); // right
}

}