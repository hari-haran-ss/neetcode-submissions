class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> map = new HashSet<Integer>();
        for(int i=0; i< nums.length; i++) {
            if(map.contains(nums[i]))
                return true;
            else
                map.add(nums[i]);
        }
        return false;
    }
}
