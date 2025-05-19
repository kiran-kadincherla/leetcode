class Solution {
  public boolean validPath(int n, int[][] edges, int source, int destination) {
        Map<Integer, Set<Integer>> edgeMap = new HashMap<>();


        for(int i=0;i<edges.length;i++){
            Set<Integer> existingListSource = edgeMap.getOrDefault(edges[i][0], new HashSet<>());
            existingListSource.add(edges[i][1]);
            edgeMap.put(edges[i][0], existingListSource);
            Set<Integer> existingListDestination = edgeMap.getOrDefault(edges[i][1], new HashSet<>());
            existingListDestination.add(edges[i][0]);
            edgeMap.put(edges[i][1], existingListDestination);
        }

        return checkPath(edgeMap, source, destination, new HashSet<>());

    }

    private boolean checkPath(Map<Integer, Set<Integer>> edges, int source, int destination, Set<Integer> visited){
        if(source == destination){
            return true;
        }
        if(visited.contains(source)){
            return false;
        }
        visited.add(source);
        Set<Integer> connectedEdges = edges.get(source);
        if(connectedEdges == null){
            return false;
        }
        if(connectedEdges.contains(destination)){
            return true;
        }
        for(Integer edge : connectedEdges){
            boolean res = checkPath(edges, edge, destination, visited);
            if(res){
                return true;
            }
        }
        return false;
    }
}