class Solution {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> adjList = new HashMap<>();

        for (int[] edge : prerequisites) {
            adjList.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(edge[1]);
        }

        return hasCycle(adjList, numCourses);
    }
     private boolean hasCycle(Map<Integer, List<Integer>> edges, int numCourses){
        int[] inDegree = new int[numCourses];
        Stack<Integer> topologicalOrder = new Stack<>();
        Set<Integer> visitedNodes = new HashSet<>();

        for(List<Integer> connectedEdges : edges.values()){
            if(connectedEdges != null){
                for(Integer connectedEdge : connectedEdges) {
                    inDegree[connectedEdge] += 1;
                }
            }
        }

        for(int i=0;i<inDegree.length;i++){
            if(inDegree[i] == 0){
                topologicalOrder.add(i);
            }
        }

        while(!topologicalOrder.isEmpty()){
            int node = topologicalOrder.pop();
            List<Integer> connectedEdges = edges.get(node);
            if(connectedEdges != null){
                for(Integer edge : connectedEdges) {
                    if(inDegree[edge] != 0) {
                        if(inDegree[edge]-1 == 0){
                            topologicalOrder.add(edge);
                        } else {
                            inDegree[edge] -= 1;
                        }
                    }
                }
            }
            visitedNodes.add(node);
        }
        return visitedNodes.size() == numCourses;
    }

}