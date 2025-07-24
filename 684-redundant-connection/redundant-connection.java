class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int noOfNodes = Integer.MIN_VALUE;
        for(int[] edge : edges){
            if(edge[0] > noOfNodes){
                noOfNodes = edge[0];
            }
            if(edge[1] > noOfNodes){
                noOfNodes = edge[1];
            }
        }
        int[] parent = new int[noOfNodes+1];
        for(int i=1;i<parent.length;i++){
            parent[i] = i;
        }

        for(int[] edge : edges){
            if(isCycleFormed(edge[0], edge[1], parent)){
                return edge;
            }
        }
        return null;

    }

    private int find(int node, int[] parent){
        if(parent[node] == node){
            return node;
        }
        return parent[node] = find(parent[node], parent);
    }

    private boolean isCycleFormed(int node1, int node2, int[] parent){
        int parentNode1 = find(node1, parent);
        int parentNode2 = find(node2, parent);
        if(parentNode1 == parentNode2){
            return true;
        }
        parent[parentNode2] = parentNode1;
        return false;
    }
}