class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, new ArrayList<>(), result, 0);
        return result;
    }

    public void backtrack(int[] nums, List<Integer> list, List<List<Integer>> result, int index){
        if(index == nums.length){
            result.add(new ArrayList<>(list));
            return;
        }
        list.add(nums[index]);
        backtrack(nums, list, result, index+1);
        list.remove(list.size()-1);
        backtrack(nums, list, result, index+1);
    }
}
