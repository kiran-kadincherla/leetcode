class Solution {
     public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        int[] inDegree = new int[numCourses];

        Arrays.fill(inDegree, 0);

        for(int i=0;i<prerequisites.length;i++){
            int[] j = prerequisites[i];
            List list = adjList.getOrDefault(j[1], new ArrayList<Integer>());
            list.add(j[0]);
            adjList.put(j[1], list);
            inDegree[j[0]] = inDegree[j[0]]+1;
        }

        System.out.println("** adjList ** "+ adjList);
        
        for (int i=0;i<inDegree.length;i++) {
            System.out.println("indegree.. "+ inDegree[i]);
        }

        return !isLinked(adjList, inDegree);
        
    }

    private boolean isLinked(Map<Integer, List<Integer>> adjList, 
                            int[] inDegree){
        Stack<Integer> itemsToBeRemoved = new Stack<>();
        for (int i=0;i<inDegree.length;i++) {
            if(inDegree[i]==0){
                itemsToBeRemoved.push(i);
            }
        }

        while(!itemsToBeRemoved.isEmpty()){
            int poppedIndex = itemsToBeRemoved.pop();
            List<Integer> adj = adjList.getOrDefault(poppedIndex, new ArrayList<>());
            
            if(!adj.isEmpty()){
                
                for(Integer index : adj){
                    inDegree[index]=inDegree[index]-1;
                    System.out.println(" .. adjList .. "+ adj + " .. inDegree[index] "+ inDegree[index] + " index " + index);
                    if(inDegree[index]==0){
                        itemsToBeRemoved.push(index);
                    }
                }
            }
        }

        for (int i=0;i<inDegree.length;i++) {
            System.out.println("indegree**** "+ inDegree[i]);
            if(inDegree[i]>0){
                return true;
            }
        }

        return false;

    }
}