class Solution {
    public boolean isPalindrome(String s) {
        int len = s.length();
        int start = 0, end = len-1;
        while(start < end){
            char st = s.charAt(start);
            char e = s.charAt(end);
            if(!Character.isLetterOrDigit(st)){
                start++;
                continue;
            }
            else if(!Character.isLetterOrDigit(e)){
                end--;
                continue;
            }
            else{
                if(Character.toLowerCase(st) != Character.toLowerCase(e))
                    return false;
                start++;
                end--;
            }
        }
        return true;
    }
}
