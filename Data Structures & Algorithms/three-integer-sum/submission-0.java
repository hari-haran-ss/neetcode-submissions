class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        int len = nums.length;
        Arrays.sort(nums);
        for(int i=0; i<len-2; i++){
            if(i >= 1 && nums[i] == nums[i-1]) continue;
            int st = i+1, end = len-1;
            while(st < end){
                int sum = nums[i] + nums[st] + nums[end];
                if(sum < 0)
                    st++;
                else if(sum > 0)
                    end--;
                else{
                    results.add(Arrays.asList(nums[i], nums[st], nums[end]));
                    st++;
                    end--;
                    while(st < len && nums[st] == nums[st-1])
                        st++;
                }
            }
        }
        return results;
    }
}
