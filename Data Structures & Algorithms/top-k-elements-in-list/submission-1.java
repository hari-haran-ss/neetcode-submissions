class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num: nums){
            map.put(num, map.getOrDefault(num, 0)+1);
        }
        System.out.println(map);
        PriorityQueue<Pair> queue = new PriorityQueue<>((a,b) -> a.y - b.y);
        for(int num: map.keySet()){
            int val = map.get(num);
            queue.add(new Pair(num, val));
            if(queue.size() > k){
                queue.poll();
            }
        }
        int[] result = new int[k];
        int index = 0;
        for(Pair pair : queue){
            result[index++] = pair.x;
        }
        return result;
    }

    public class Pair{
        int x;
        int y;
        public Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
