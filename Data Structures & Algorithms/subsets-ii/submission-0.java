class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        backtrackSubsets(nums, 0, new ArrayList<>(), result);
        return result;
    }

    public void backtrackSubsets(int[] nums, int index, List<Integer> list, List<List<Integer>> result){
        result.add(new ArrayList<>(list));
        for(int i=index; i<nums.length; i++){
            if(i > index && nums[i] == nums[i-1])
                continue;
            list.add(nums[i]);
            backtrackSubsets(nums, i+1, list, result);
            list.remove(list.size()-1);
        }
    }
}
