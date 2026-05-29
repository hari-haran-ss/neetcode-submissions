class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        Map<Integer, List<String>> map = new HashMap<Integer, List<String>>();
        for(int i=0; i<strs.length; i++) {
            int charsum = getSum(strs[i]);
            if(map.containsKey(charsum)) {
                List<String> list = map.get(charsum);
                list.add(strs[i]);
                map.put(charsum, list);
            }
            else {
                List<String> list = new ArrayList<String>();
                list.add(strs[i]);
                map.put(charsum, list);
            }
        }
        List<List<String>> result = new ArrayList<List<String>>();
        for(Integer key: map.keySet()) {
            result.add(map.get(key));
        }
        return result;
    }

    public int getSum(String s) {
        if(s == null)
            return 0;
        int result = 0;
        for(int i=0; i< s.length(); i++) {
            result += (int) s.charAt(i);
        }
        return result;
    }
}
