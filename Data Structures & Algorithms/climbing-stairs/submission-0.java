class Solution {
    public int climbStairs(int n) {
        if(n <= 2)
            return n;
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        return dfs(dp, n, 0);
    }

    public int dfs(int[] dp, int n, int pos){
        if(pos >= n)
            return pos == n ? 1 : 0;
        if(dp[pos] != -1)
            return dp[pos];
        dp[pos] = dfs(dp, n, pos+1) + dfs(dp, n, pos+2);
        return dp[pos];
    }
}
