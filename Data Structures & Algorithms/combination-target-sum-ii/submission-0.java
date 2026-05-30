class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList();
        Arrays.sort(candidates);
        backtrackSum(candidates, target, new ArrayList<>(), 0, result);
        return result;
    }

    public void backtrackSum(int[] candidates, int remaining, List<Integer> list, int index, List<List<Integer>> result){
        if(remaining == 0){
            result.add(new ArrayList<>(list));
            return;
        }
        if(remaining < 0)
            return;
        for(int i=index; i<candidates.length; i++){
            if(candidates[i] > remaining)
                break;
            if(i > index && candidates[i] == candidates[i-1])
                continue;
            list.add(candidates[i]);
            backtrackSum(candidates, remaining-candidates[i], list, i+1, result);
            list.remove(list.size()-1);

        }
    }
}
