class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == 0){
                    dfs(grid, i-1, j, 0);
                    dfs(grid, i+1, j, 0);
                    dfs(grid, i, j-1, 0);
                    dfs(grid, i, j+1, 0);
                }
            }
        }
    }

    public void dfs(int[][] grid, int i, int j, int dist){
        if(i < 0 || j < 0 || i > grid.length-1 || j > grid[0].length-1)
            return;
        if(grid[i][j] == 0 || grid[i][j] == -1)
            return;
        int old = grid[i][j];
        grid[i][j] = Math.min(grid[i][j], dist+1);
        if(old != grid[i][j]){
            dfs(grid, i-1, j, dist+1);
            dfs(grid, i+1, j, dist+1);
            dfs(grid, i, j-1, dist+1);
            dfs(grid, i, j+1, dist+1);
        }
    }

}
