class Solution {
    public boolean isPalindrome(String s) {
        int i=0, j = s.length()-1;
        while(i < j) {
            char c1 = Character.toLowerCase(s.charAt(i));
            int ascii_c1 = (int)c1;
            if(!((ascii_c1 >= 97 && ascii_c1 <= 122) || (ascii_c1 >= 48 && ascii_c1 <= 57))){
                i++;
                continue;
            }
            char c2 = Character.toLowerCase(s.charAt(j));
            int ascii_c2 = (int)c2;
            if(!((ascii_c2 >= 97 && ascii_c2 <= 122) || (ascii_c2 >= 48 && ascii_c2 <= 57))){
                j--;
                continue;
            }
            // System.out.println("i - "+s.charAt(i)+" j - "+s.charAt(j));
            if(c1 != c2)
                return false;
            i++;
            j--;
        }
        return true;
    }
}
