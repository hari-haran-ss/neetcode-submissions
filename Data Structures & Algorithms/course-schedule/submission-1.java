class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> preReqMap = new HashMap<>();
        Set<Integer> visited = new HashSet<>();
        for(int i=0; i<numCourses; i++)
            preReqMap.put(i, new ArrayList<>());
        for(int[] pre: prerequisites){
            preReqMap.get(pre[0]).add(pre[1]);
        }
        for(int i=0; i<numCourses; i++){
            if(!dfs(i, preReqMap, visited))
                return false;
        }
        return true;
    }

    public boolean dfs(int course, Map<Integer, List<Integer>> preReqMap, Set<Integer> visited){
        if(visited.contains(course))
            return false;
        if(preReqMap.get(course).isEmpty())
            return true;
        visited.add(course);
        for(int c: preReqMap.get(course)){
            if(!dfs(c, preReqMap, visited))
                return false;
        }
        visited.remove(course);
        preReqMap.put(course, new ArrayList<>());
        return true;
    }
}
