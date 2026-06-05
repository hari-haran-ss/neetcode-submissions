class Solution {
    public int numIslands(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int result = 0;
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                if(grid[i][j] == '1'){
                    result++;
                    bfs(grid, i, j);
                }
            }
        }
        return result;
    }

    public void bfs(char[][] grid, int row, int col){
        if(row < 0 || col < 0 || row > grid.length-1 || col > grid[0].length-1){
            return;
        }
        if(grid[row][col] == '1'){
            grid[row][col] = 'x';
            bfs(grid, row-1, col);
            bfs(grid, row+1, col);
            bfs(grid, row, col-1);
            bfs(grid, row, col+1);
        }
    }
}
