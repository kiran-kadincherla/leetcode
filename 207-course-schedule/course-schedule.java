class Solution {

     public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> adjList = new HashMap<>();

        for (int[] edge : prerequisites) {
            adjList.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(edge[1]);
        }

        return isAcyclic(adjList, numCourses);
    }

    private boolean isAcyclic(Map<Integer, List<Integer>> edges, int numCourses){
        int[] inDegree = new int[numCourses];
        Stack<Integer> stack = new Stack<>();
        int noOfNodesProcessed = 0;

        for(List<Integer> connectedEdges : edges.values()){
            if(connectedEdges != null){
                for(Integer connectedEdge : connectedEdges) {
                    inDegree[connectedEdge] += 1;
                }
            }
        }

        for(int i=0;i<inDegree.length;i++){
            if(inDegree[i] == 0){
                stack.add(i);
            }
        }

        while(!stack.isEmpty()){
            int node = stack.pop();
            List<Integer> connectedEdges = edges.get(node);
            if(connectedEdges != null){
                for(Integer neighbor : connectedEdges) {
                    inDegree[neighbor]--;
                    if (inDegree[neighbor] == 0) {
                        stack.push(neighbor);
                    }
                }
            }
            noOfNodesProcessed++;
        }
        return noOfNodesProcessed == numCourses;
    }
}