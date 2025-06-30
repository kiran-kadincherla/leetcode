class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // Build adjacency list
        List<Integer>[] graph = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] edge : prerequisites) {
            graph[edge[0]].add(edge[1]);
        }
        
        boolean[] visited = new boolean[numCourses];
        boolean[] onPath = new boolean[numCourses];
        
        for (int i = 0; i < numCourses; i++) {
            if (!visited[i] && hasCycle(graph, i, visited, onPath)) {
                return false;
            }
        }
        return true;
    }
    
    private boolean hasCycle(List<Integer>[] graph, int current, 
                           boolean[] visited, boolean[] onPath) {
        if (onPath[current]) return true;  // Cycle detected
        if (visited[current]) return false; // Already processed
        
        visited[current] = true;
        onPath[current] = true;
        
        for (int neighbor : graph[current]) {
            if (hasCycle(graph, neighbor, visited, onPath)) {
                return true;
            }
        }
        
        onPath[current] = false; // Backtrack
        return false;
    }
}