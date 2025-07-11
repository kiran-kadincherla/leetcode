class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> adjList = new HashMap<>();

        for (int[] edge : prerequisites) {
            adjList.computeIfAbsent(edge[1], k -> new ArrayList<>()).add(edge[0]);
        }

        return topologicalSort(numCourses, adjList);

    }

    private int[] topologicalSort(int numCourses, Map<Integer, List<Integer>> edges){
        int[] inDegree = new int[numCourses];
        int[] result = new int[numCourses];
        Stack<Integer> stack = new Stack<>();
        int noOfNodesProcessed = 0;
        int resultIndex = 0;


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
            result[resultIndex++] = node;
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
        if(noOfNodesProcessed != numCourses){
            return new int[]{};
        } else {
            return result;
        }
    }
}