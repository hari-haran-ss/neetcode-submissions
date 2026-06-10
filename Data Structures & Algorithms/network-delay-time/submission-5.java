class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<Integer[]>> adj = new ArrayList<>();
        int[] maxTimes = new int[n+1];
        Arrays.fill(maxTimes, Integer.MAX_VALUE);
        for(int i=0; i<=n; i++)
            adj.add(new ArrayList<>());
        for(int[] time: times){
            adj.get(time[0]).add(new Integer[]{time[1], time[2]});
        }
        // System.out.println("Adj "+adj.toString());
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{k, 0});
        while(!queue.isEmpty()){
            int[] ele = queue.poll();
            int node = ele[0], time = ele[1];
            // System.out.println("Node "+node+" time "+time+" max "+maxTimes[node]);
            if(time >= maxTimes[node])
                continue;
            maxTimes[node] = Math.min(maxTimes[node], time);
            // System.out.println("Node "+node+" time "+time+" max "+maxTimes[node]);
            for(Integer[] child : adj.get(node)){
                if(child[1] + time >= maxTimes[child[0]] )
                    continue;
                // System.out.println("Adding node "+child[0]+" current max "+maxTimes[child[0]]+" but from parent "+node+" new val "+(child[1] + time));
                queue.add(new int[]{child[0], child[1]+time});
            }
        }
        // System.out.println(Arrays.toString(maxTimes));
        int result = 0;
        for(int i=1; i<=n; i++){
            int time = maxTimes[i];
            if(time == Integer.MAX_VALUE)
                return -1;
            result = Math.max(time, result);
        }
        return result;
    }
}
