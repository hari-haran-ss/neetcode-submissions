class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, new ArrayList<>(), result, 0);
        return result;
    }

    public void backtrack(int[] nums, List<Integer> list, List<List<Integer>> result, int index){
        result.add(new ArrayList<>(list));
        for(int i=index;i<nums.length;i++){
            list.add(nums[i]);
            backtrack(nums, list, result, i+1);
            list.remove(list.size()-1);
        }
    }
}
