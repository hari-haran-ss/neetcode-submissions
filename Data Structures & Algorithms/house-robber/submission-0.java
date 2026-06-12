class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return dfs(nums, dp, n, 0);
    }

    public int dfs(int[] nums, int[] dp, int n, int pos){
        if(pos >= n)
            return 0;
        if(dp[pos] != -1)
            return dp[pos];
        dp[pos] = Math.max(dfs(nums, dp, n, pos+1), nums[pos]+dfs(nums, dp, n, pos+2));
        return dp[pos];
    }

}
