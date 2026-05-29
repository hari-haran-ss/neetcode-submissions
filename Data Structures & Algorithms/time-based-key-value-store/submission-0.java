class TimeMap {

    Map<String, List<Data>> timeMap;
    public TimeMap() {
        this.timeMap = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        timeMap.putIfAbsent(key, new ArrayList<Data>());
        timeMap.get(key).add(new Data(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
        List<Data> pairs = timeMap.get(key);
        if(pairs == null || pairs.size() < 1)
            return "";
        String result = "";
        int start = 0, end = pairs.size()-1;
        while(start <= end){
            int mid = (start + end)/2;
            Data pair = pairs.get(mid);
            if(pair.time == timestamp)
                return pair.value;
            else if(pair.time < timestamp){
                result = pair.value;
                start = mid+1;
            }
            else
                end = mid-1;
        }
        return result;
    }
}

class Data{
    int time;
    String value;

    public Data(int time, String value){
        this.time = time;
        this.value = value;
    }
}