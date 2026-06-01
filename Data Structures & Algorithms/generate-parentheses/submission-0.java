class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generate(n, 0, 0, new StringBuilder(), result);
        return result;
    }

    public void generate(int n, int open, int closed, StringBuilder sb, List<String> result){
        if(sb.length() == n*2){
            result.add(sb.toString());
            return;
        }
        if(open < n){
            sb.append("(");
            generate(n, open+1, closed, sb, result);
            sb.deleteCharAt(sb.length()-1);
        }
        if(closed < open){
            sb.append(")");
            generate(n, open, closed+1, sb, result);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
