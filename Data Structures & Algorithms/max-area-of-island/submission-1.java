class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;

        int rows = grid.length;
        int cols = grid[0].length;

        for(int row = 0; row < rows; row++){
            for(int col = 0; col < cols; col++){
                if(grid[row][col] == 1){
                    int area = dfs(grid, row, col);
                    maxArea = Math.max(area, maxArea);
                }
            }
        }

        return maxArea;
    }

    private int dfs(int grid[][], int row, int col){
        int rows = grid.length;
        int cols = grid[0].length;

        if(row < 0 || row >= rows || col < 0 || col >= cols || grid[row][col] == 0){
            return 0;
        }

        grid[row][col] = 0;
        int area = 1;

        area += dfs(grid, row + 1, col);
        area += dfs(grid, row - 1, col);
        area += dfs(grid, row, col + 1);
        area += dfs(grid, row, col - 1);
        
        return area;
    }
}
