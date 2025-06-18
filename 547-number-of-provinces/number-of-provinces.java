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
                visitedVertices.addAll(dfs(edges, new HashSet<>(), vertice));
                result++;
            }

        }
        return result;
    }

    private Set<Integer> bfs(Map<Integer,List<Integer>> edges, Set<Integer> visitedVertices, Queue<Integer> connectedVertices, Integer currentVertice){
        if(visitedVertices.contains(currentVertice)){
            if(!connectedVertices.isEmpty()) {
                return bfs(edges, visitedVertices, connectedVertices, connectedVertices.poll());
            }
            else
                return visitedVertices;
        }
        visitedVertices.add(currentVertice);
        List<Integer> vertices = edges.get(currentVertice);
        if(!vertices.isEmpty()){
            connectedVertices.addAll(vertices);
            return bfs(edges, visitedVertices, connectedVertices, connectedVertices.poll());
        } else {
            return visitedVertices;
        }

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