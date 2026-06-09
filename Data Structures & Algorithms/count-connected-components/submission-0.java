class Solution {
    public int countComponents(int n, int[][] edges) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i=0; i<n; i++){
            map.put(i, new ArrayList<>());
        }
        for(int[] edge: edges){
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }
        Set<Integer> visited = new HashSet<>();
        int result = 0;
        for(int i=0; i<n; i++){
            if(visited.contains(i))
                continue;
            dfs(i, map, visited, -1);
            result++;
        }
        return result;
    }

    public void dfs(int node, Map<Integer, List<Integer>> map, Set<Integer> visited, int parent){
        if(visited.contains(node))
            return;
        visited.add(node);
        for(int ele: map.get(node)){
            if(ele == parent)
                continue;
            dfs(ele, map, visited, node);
        }
    }
}
