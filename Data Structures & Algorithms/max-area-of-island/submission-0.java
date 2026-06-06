class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length, n = grid[0].length, result = 0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == 1){
                    int[] res = new int[1];
                    int area = dfs(grid, i, j, res);
                    result = Math.max(result, area);
                }
            }
        }
        return result;
    }

    public int dfs(int[][] grid, int row, int col, int[] res){
        if(row < 0 || col < 0 || row > grid.length-1 || col > grid[0].length-1)
            return res[0];
        if(grid[row][col] != 1)
            return res[0];
        grid[row][col] = -1;
        res[0]++;
        dfs(grid, row-1, col, res);
        dfs(grid, row+1, col, res);
        dfs(grid, row, col-1, res);
        dfs(grid, row, col+1, res);
        return res[0];
    }
}
