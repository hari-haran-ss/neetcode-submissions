class Solution {
    public boolean validTree(int n, int[][] edges) {
        if(edges.length > n-1)
            return false;
        Map<Integer, List<Integer>> child = new HashMap<>();
        Set<Integer> visited = new HashSet<>();
        for(int i=0; i<n; i++)
            child.put(i, new ArrayList<>());
        for(int[] edge: edges){
            child.get(edge[0]).add(edge[1]);
            child.get(edge[1]).add(edge[0]);
        }
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, -1});
        while(!queue.isEmpty()){
            int[] ele = queue.poll();
            int node = ele[0], parent = ele[1];
            for(int edge: child.get(node)){
                if(edge == parent)
                    continue;
                if(visited.contains(edge))
                    return false;
                queue.add(new int[]{edge, node});
            }
            visited.add(node);
        }
        return visited.size() == n;
    }
}
