class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length <= 0)
            return 0;
        Arrays.sort(nums);
        int max = 1, tempMax = 1, prev = 0;
        for(int i=1; i< nums.length; i++) {
            // System.out.println("Current "+nums[i]+" and prev "+nums[prev]+" tempMax "+tempMax+" max "+max);
            if(nums[i] - nums[prev] == 0) {
                continue;
            }
            else if(nums[i] - nums[prev] == 1){
                tempMax ++;
                prev = i;
            }
            else {
                max = Math.max(max, tempMax);
                tempMax = 1;
                prev = i;
            }
        }
        max = Math.max(max, tempMax);
        return max;
    }
}
