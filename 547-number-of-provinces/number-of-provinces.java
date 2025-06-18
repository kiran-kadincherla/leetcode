class Solution {
       public int findCircleNum(int[][] isConnected) {
        Map<Integer, List<Integer>> edges = new HashMap<>();
        Set<Integer> visitedVertices = new HashSet<>();
        int result = 0;

        for(int i=0;i<isConnected.length;i++){
            for(int j=0;j<isConnected[0].length;j++){
                if(isConnected[i][j] == 1){
                    List<Integer> existingEdges = edges.getOrDefault(i+1, new ArrayList<>());
                    existingEdges.add(j+1);
                    edges.put(i+1, existingEdges);
                }
            }
        }

        for(Integer vertice : edges.keySet()){
            if(!visitedVertices.contains(vertice)) {
                visitedVertices.addAll(bfs(edges, vertice));
                result++;
            }

        }
        return result;
    }

    private Set<Integer> bfs(Map<Integer,List<Integer>> edges, Integer startingNode) {
        Set<Integer> connected = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();

        queue.add(startingNode);
        visited.add(startingNode);

        while (!queue.isEmpty()){
            Integer node = queue.poll();
            connected.add(node);
            List<Integer> connectedEdges = edges.getOrDefault(node, new ArrayList<>());
            for(Integer edge : connectedEdges) {
                if(!visited.contains(edge)){
                    queue.add(edge);
                    visited.add(edge);
                }
            }
        }
        return connected;


    }

    private Set<Integer> dfs(Map<Integer, List<Integer>> edges, Set<Integer> visited, Integer current) {
    Set<Integer> connected = new HashSet<>();
    dfsHelper(edges, visited, current, connected);
    return connected;
}

private void dfsHelper(Map<Integer, List<Integer>> edges, Set<Integer> visited, Integer current, Set<Integer> connected) {
    if (visited.contains(current)) return;

    visited.add(current);
    connected.add(current);

    List<Integer> neighbors = edges.getOrDefault(current, new ArrayList<>());
    for (Integer neighbor : neighbors) {
        if (!visited.contains(neighbor)) {
            dfsHelper(edges, visited, neighbor, connected);
        }
    }
}
}