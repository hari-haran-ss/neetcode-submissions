class Solution {
    public boolean isAnagram(String s, String t) {
        int len = s.length();
        if(len != t.length())
            return false;
        int[] freq = new int[26];
        for(int i=0; i<len; i++){
            freq[s.charAt(i) - 'a']++;
            freq[t.charAt(i) - 'a']--;
        }
        for(int c: freq)
            if(c != 0)
                return false;
        return true;
    }
}
