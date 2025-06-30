class Solution {
    
    
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> adjList = new HashMap<>();

        for (int[] edge : prerequisites) {
            adjList.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(edge[1]);
        }

        boolean[] visited = new boolean[numCourses];
        boolean[] onPath = new boolean[numCourses];

    
          for (int i = 0; i < numCourses; i++) {
            if (hasCycle(adjList, visited, onPath, i)) {
                return false;
            }
        }
        return true;
    }

    private boolean hasCycle(Map<Integer, List<Integer>> edges, boolean[] visited, boolean[] onPath,  int current){
        if(onPath[current]) return true;
        if(visited[current]) return false;
        List<Integer> connectedVertices = edges.get(current);

        visited[current] = true;
        onPath[current] = true;

        if(connectedVertices != null){
            for(Integer vertice : connectedVertices){
                if(hasCycle(edges, visited, onPath, vertice)){
                    return true;
                }
            }
        }

        onPath[current] = false;
        return false;
    }
}