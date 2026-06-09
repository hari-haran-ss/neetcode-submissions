class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> preMap = new HashMap<>();
        Set<Integer> visited = new HashSet<>();
        Set<Integer> cycle = new HashSet<>();
        List<Integer> output = new ArrayList<>();
        for(int i=0; i<numCourses; i++){
            preMap.put(i, new ArrayList<>());
        }
        for(int[] pre: prerequisites){
            preMap.get(pre[0]).add(pre[1]);
        }
        for(int i=0; i<numCourses; i++){
            if(!dfs(i, preMap, cycle, visited, output))
                return new int[0];
        }
        int[] order = new int[numCourses];
        int index = 0;
        for(int c: output)
            order[index++] = c;
        return order;
    }

    public boolean dfs(int course, Map<Integer, List<Integer>> preMap, Set<Integer> visited, Set<Integer> cycle, List<Integer> output){
        if(cycle.contains(course))
            return false;
        if(visited.contains(course))
            return true;
        cycle.add(course);
        for(int c: preMap.get(course)){
            if(!dfs(c, preMap, visited, cycle, output))
                return false;
        }
        cycle.remove(course);
        output.add(course);
        visited.add(course);
        return true;
    }
}
