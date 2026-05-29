class Solution {
    public int findDuplicate(int[] nums) {
        boolean[] check = new boolean[nums.length];
        int n = nums.length;
        for(int i=0; i<n; i++){
            if(check[nums[i]] == true)
                return nums[i];
            check[nums[i]] = true;
        }
        return 0;
    }
}
