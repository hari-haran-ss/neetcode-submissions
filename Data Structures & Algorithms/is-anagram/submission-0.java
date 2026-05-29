class Solution {
    public boolean isAnagram(String s, String t) {
        if(s == null || t == null)
            return false;
        if(s != null && t != null && s.length() != t.length())
            return false;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for(int i=0; i< s.length(); i++){
            char c = s.charAt(i);
            if(map.containsKey(c)){
                int count = map.get(c);
                map.put(c, count+1);
            }
            else {
                map.put(c, 1);
            }
        }
        for(int i=0; i< t.length(); i++){
            char c = t.charAt(i);
            if(!map.containsKey(c))
                return false;
            else {
                int count = map.get(c);
                if(count == 1) {
                    map.remove(c);
                }
                else{
                    map.put(c, count-1);
                }
            }
        }
        if(map.size() > 0)
            return false;
        return true;

    }
}
