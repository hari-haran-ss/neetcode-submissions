class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<=n; i++)
            adj.add(new ArrayList<>());
        for(int[] edge : edges){
            int i = edge[0], j = edge[1];
            adj.get(i).add(j);
            adj.get(j).add(i);
            boolean[] visited = new boolean[n+1];
            if(!dfs(i, -1, adj, visited))
                return edge;
        }
        return new int[0];
    }

    public boolean dfs(int node, int parent, List<List<Integer>> adj, boolean[] visited){
        if(visited[node])
            return false;
        visited[node] = true;
        for(int ele: adj.get(node)){
            if(ele == parent)
                continue;
            if(!dfs(ele, node, adj, visited))
                return false;
        }
        return true;
    }
}
