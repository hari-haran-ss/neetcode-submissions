class Solution {
    public int lengthOfLongestSubstring(String s) {
        int len = s.length(), result = 0, start = 0;
        Map<Character, Integer> charMap = new HashMap<>();
        for(int i=0; i<len; i++){
            char c = s.charAt(i);
            if(charMap.containsKey(c)){
                int index = charMap.get(c);
                result = Math.max(result, i-start);
                for(int j=start; j<=index; j++)
                    charMap.remove(s.charAt(j));
                charMap.put(c, i);
                start = index+1;
            }
            else{
                charMap.put(c, i);
            }
        }
        result = Math.max(result, len-start);
        return result;
    }
}
