class Solution {
    public int orangesRotting(int[][] grid) {
        int minutes = 0, m = grid.length, n = grid[0].length;
        int[][] dir = new int[][]{{-1,0}, {1,0}, {0,-1}, {0,1}};
        Queue<int[]> queue = new LinkedList<>();
        for(int i=0; i<m; i++)
            for(int j=0; j<n; j++)
                if(grid[i][j] == 2)
                    queue.add(new int[]{i,j});
        
        while(!queue.isEmpty()){
            boolean fresh = false;
            int size = queue.size();
            for(int i=0; i<size; i++){
                int[] ele = queue.poll();
                int r = ele[0], c = ele[1];
                for(int[] d: dir){
                    int row = r + d[0], col = c + d[1];
                    if(row < 0 || col < 0 || row > grid.length-1 || col > grid[0].length-1 || grid[row][col] != 1)
                        continue;
                    grid[row][col] = 2;
                    queue.add(new int[]{row, col});
                    fresh = true;
                }
            }
            if(fresh)
                minutes++;
        }
        for(int i=0; i<m; i++)
            for(int j=0; j<n; j++)
                if(grid[i][j] == 1)
                    return -1;
        return minutes;
    }
}
