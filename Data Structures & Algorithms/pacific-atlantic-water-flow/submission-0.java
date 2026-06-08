class Solution {
    int[][] dir = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length, n = heights[0].length;
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];
        for(int i=0; i<m; i++){
            dfs(heights, i, 0, pacific);
            dfs(heights, i, n-1, atlantic);
        }
        for(int i=0; i<n; i++){
            dfs(heights, 0, i, pacific);
            dfs(heights, m-1, i, atlantic);
        }
        List<List<Integer>> result = new ArrayList<>();
        for(int i=0; i<m; i++)
            for(int j=0; j<n; j++)
                if(pacific[i][j] && atlantic[i][j])
                    result.add(Arrays.asList(i,j));
        return result;
    }

    public void dfs(int[][] heights, int r, int c, boolean[][] ocean){
        ocean[r][c] = true;
        for(int[] d: dir){
            int row = r + d[0], col = c + d[1];
            if(row < 0 || col < 0 || row > heights.length-1 || col > heights[0].length-1 || ocean[row][col] || heights[row][col] < heights[r][c])
                continue;
            dfs(heights, row, col, ocean);
        }
    }
}
