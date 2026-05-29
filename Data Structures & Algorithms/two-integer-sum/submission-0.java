class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int[] result = new int[2];
        for(int i=0; i< nums.length; i++){
            int ele = nums[i];
            int req = target - ele;
            if(map.containsKey(req)){
                result[0] = map.get(req);
                result[1] = i;
                return result;
            }
            else
                map.put(ele, i);
        }
        return result;

    }
}
