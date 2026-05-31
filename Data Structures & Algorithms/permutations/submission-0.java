class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[] check = new boolean[nums.length];
        backtrack(nums, check, new ArrayList<>(), result);
        return result;
    }

    public void backtrack(int[] nums, boolean[] check, List<Integer> list, List<List<Integer>> result){
        if(list.size() == nums.length){
            result.add(new ArrayList<>(list));
            return;
        }
        for(int i=0; i<nums.length; i++){
            if(!check[i]){
                list.add(nums[i]);
                check[i] = true;
                backtrack(nums, check, list, result);
                list.remove(list.size()-1);
                check[i] = false;
            }
        }
    }
}
