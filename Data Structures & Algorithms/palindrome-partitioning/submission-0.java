class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        backtrack(s, 0, new ArrayList<>(), result);
        return result;
    }

    public void backtrack(String s, int index, List<String> list, List<List<String>> result){
        if(index == s.length()){
            result.add(new ArrayList<>(list));
            return;
        }
        for(int i=index; i<s.length(); i++){
            if(isPalindrome(s, index, i)){
                list.add(s.substring(index, i+1));
                backtrack(s, i+1, list, result);
                list.remove(list.size()-1);
            }
        }
    }

    public boolean isPalindrome(String s, int i, int j){
        while(i <= j){
            if(s.charAt(i) != s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }
}