class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            int num = nums[i];
            int req = target - nums[i];
            if(map.containsKey(req)){
                int[] result = new int[2];
                result[0] = map.get(req);
                result[1] = i;
                return result;
            }
            map.put(nums[i], i);
        }
        return new int[]{};
    }
}
