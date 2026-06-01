class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if(digits.length() < 1)
            return result;
        String[] chars = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        backtrackCombinations(chars, digits, 0, new StringBuilder(), result);
        return result;
    }

    public void backtrackCombinations(String[] chars, String digits, int index, StringBuilder sb, List<String> result){
        if(sb.length() == digits.length()){
            result.add(sb.toString());
            return;
        }
        if(index > digits.length()-1)
            return;
        int ptr = digits.charAt(index) - '0';
        String numsDigits = chars[ptr];
        for(int i=0; i<numsDigits.length(); i++){
            sb.append(numsDigits.charAt(i));
            backtrackCombinations(chars, digits, index+1, sb, result);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
