class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0)
            return 0;
        int result = 1;
        Arrays.sort(nums);
        int start = 0, end = nums.length, progress = 1;
        while(start < end-1){
            // System.out.println("start "+start+" num "+nums[start]+" prog "+progress);
            if(nums[start+1] - nums[start] <= 1){
                if(nums[start] == nums[start+1]){
                    start++;
                    continue;
                }
                progress++;
            }
            else{
                result = Math.max(result, progress);
                progress = 1;
            }
            start++;
        }
        result = Math.max(result, progress);
        return result;
    }
}
