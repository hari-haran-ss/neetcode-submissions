class Solution {

    public String encode(List<String> strs) {
        int len = strs.size();
        if(len <= 0)
            return null;
        // List<String> list = new ArrayList<String>();
        StringBuilder result = new StringBuilder();
        for(int i=0; i<len; i++) {
            result.append(strs.get(i));
            if(i != len-1){
                result.append("<neetcoderandomtesthariharan>");
            }
        }
        return result.toString();

    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<String>();
        if(str == null)
            return result;
        String[] input = str.split("<neetcoderandomtesthariharan>");
        for(int i=0; i<input.length; i++){
            result.add(input[i]);
        }
        return result;
    }
}
