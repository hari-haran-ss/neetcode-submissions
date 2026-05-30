class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrackSum(nums, target, new ArrayList<>(), 0, result);
        return result;
    }

    public void backtrackSum(int[] nums, int remaining, List<Integer> list, int index, List<List<Integer>> result){
        if(remaining < 0)
            return;
        if(remaining == 0){
            result.add(new ArrayList<>(list));
            return;
        }
        for(int i=index; i<nums.length; i++){
            list.add(nums[i]);
            backtrackSum(nums, remaining-nums[i], list, i, result);
            list.remove(list.size()-1);
        }
    }
}
