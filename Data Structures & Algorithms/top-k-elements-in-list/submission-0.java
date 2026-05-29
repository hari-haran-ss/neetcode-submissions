class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i=0; i< nums.length; i++) {
            if(!map.containsKey(nums[i])){
                map.put(nums[i], 0);
            }
            int val = map.get(nums[i]);
            map.put(nums[i], val+1);
            System.out.println("Map - key - "+nums[i]+" value "+(val+1));
        }
        List<Integer>[] freq = new ArrayList[nums.length+1];
        for(int i=0; i<=nums.length; i++)
            freq[i] = new ArrayList<Integer>();
        for(Integer key: map.keySet())
            freq[map.get(key)].add(key);
        int[] result = new int[k];
        int ptr = 0;
        System.out.println("Freq is "+freq);
        for(int i=nums.length; (i>=0 && ptr<k); i--){
            for(int j=0; (j < freq[i].size() && ptr < k); j++){
                result[ptr++] = freq[i].get(j);
            }
        }
        return result;
    }
}
