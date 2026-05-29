class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String str: strs){
            sb.append(str.length()).append(",");
        }
        sb.append("#");
        for(String str: strs){
            sb.append(str);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        int start = 0;
        List<String> result = new ArrayList<>();
        List<Integer> sizes = new ArrayList<>();
        if(str.length() == 0)
            return new ArrayList<>();
        while(start < str.length() && str.charAt(start) != '#'){
            StringBuilder len = new StringBuilder();
            while(str.charAt(start) != ',')
                len.append(str.charAt(start++));
            sizes.add(Integer.parseInt(len.toString()));
            start++;
        }
        int newStart = start+1;
        for(int l: sizes){
            result.add(str.substring(newStart, newStart+l));
            newStart += l;
        }
        // for(int i=0; i<str.length(); i++){
        //     char c = str.charAt(i);
        //     if(c == '#'){
        //         int len = Integer.valueOf(str.charAt(++i));
        //         String s = str.substring(start, i-1);
        //         result.add(s);
        //         start = i+1;
        //     }
        // }
        return result;
    }
}
