class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] dir = new int[][]{{1,0}, {-1, 0}, {0, 1}, {0,-1}};
        Queue<int[]> queue = new LinkedList<>();
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == 0)
                    queue.add(new int[]{i, j});
            }
        }
        while(!queue.isEmpty()){
            int[] current = queue.poll();
            int row = current[0], col = current[1];
            for(int i=0; i<dir.length;i++){
                int[] d = dir[i];
                int newrow = row + d[0], newcol = col + d[1];
                if(newrow < 0 || newcol < 0 || newrow > grid.length-1 || newcol > grid[0].length-1 || grid[newrow][newcol] != Integer.MAX_VALUE)
                    continue;
                queue.add(new int[]{newrow, newcol});
                grid[newrow][newcol] = grid[row][col]+1;
            }
        }
    }
}
