class Solution {
        public int networkDelayTime(int[][] times, int n, int k) {
        Node[] nodes = new Node[n];
        List<Map<Integer, Integer>> adjList = new ArrayList<>();
        MinHeap<Node> nodesInQueue = new MinHeap<>();
        Set<Integer> processedNodes = new HashSet<>();
        int maxValue = Integer.MIN_VALUE;

        int index = 0;
        for(int i=0;i<n;i++){
            adjList.add(new HashMap<>());
            if(i == k-1){
                nodes[index++] = new Node(i+1, 0, i);
            } else {
                nodes[index++] = new Node(i+1, Integer.MAX_VALUE, i);
            }
        }
        adjList.add(new HashMap<>());
        for(int[] time : times){
            Map<Integer, Integer> adj = adjList.get(time[0]);
            adj.put(time[1], time[2]);
            adjList.set(time[0], adj);
        }

        nodesInQueue.addNode(nodes[k-1]);

        while (!nodesInQueue.getHeap().isEmpty()){
            Node currentNode = nodesInQueue.removeNode();
            processedNodes.add(currentNode.getValue());
            Map<Integer, Integer> currentAdjList = adjList.get(currentNode.getValue());
            for(Integer key : currentAdjList.keySet()){
                //if(!processedNodes.contains(key)) {
                    if(nodes[key-1].getShortestDistance() > (currentNode.getShortestDistance() +  adjList.get(currentNode.getValue()).get(key))) {
                        nodes[key-1].setPreviousNode(currentNode.getValue());
                        nodes[key-1].setShortestDistance(currentNode.getShortestDistance() +  adjList.get(currentNode.getValue()).get(key));
                        nodesInQueue.addNode(nodes[key-1]);
                    }
                //}
            }
        }
        //System.out.println("number of processed Nodes " + processedNodes.size() + " .. " + maxValue);
        if(processedNodes.size() != n){
            return -1;
        } else {
            for(Node node : nodes) {
                if(node.getShortestDistance() > maxValue){
                    maxValue = node.getShortestDistance();
                }
            }
            return maxValue;
        }
    }

    static class Node implements Comparable<Node> {
        int shortestDistance;
        int value;
        int previousNode;

        Node(int value, int shortestDistance, int previousNode){
            this.value = value;
            this.shortestDistance = shortestDistance;
            this.previousNode = previousNode;
        }

        public int getShortestDistance() {
            return shortestDistance;
        }

        public void setShortestDistance(int shortestDistance) {
            this.shortestDistance = shortestDistance;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public int getPreviousNode() {
            return previousNode;
        }

        public void setPreviousNode(int previousNode) {
            this.previousNode = previousNode;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.shortestDistance, o.shortestDistance);
        }
    }

    static class MinHeap<T extends Comparable<T>> {
        List<T> heap = new ArrayList<>();

        public void addNode(T node){
            heap.add(node);
            int currentIndex = heap.size() - 1;
            while (currentIndex > 0 && heap.get(currentIndex).compareTo(heap.get(getParentIndex(currentIndex))) < 0) {
                swapValues(currentIndex, getParentIndex(currentIndex));
                currentIndex = getParentIndex(currentIndex);
            }
        }

        public T removeNode() {
            if (heap.isEmpty()) return null;

            T minValue = heap.get(0);
            if (heap.size() == 1) {
                heap.remove(0);
            } else {
                heap.set(0, heap.remove(heap.size() - 1));
                sinkDown();
            }
            return minValue;
        }

        private void sinkDown() {
            int currentIndex = 0;
            while (true) {
                int left = getLeftChildIndex(currentIndex);
                int right = getRightChildIndex(currentIndex);
                int smallest = currentIndex;

                if (left < heap.size() && heap.get(left).compareTo(heap.get(smallest)) < 0) {
                    smallest = left;
                }
                if (right < heap.size() && heap.get(right).compareTo(heap.get(smallest)) < 0) {
                    smallest = right;
                }
                if (smallest == currentIndex) break;

                swapValues(currentIndex, smallest);
                currentIndex = smallest;
            }
        }

        private void swapValues(int i, int j) {
            T temp = heap.get(i);
            heap.set(i, heap.get(j));
            heap.set(j, temp);
        }

        private int getParentIndex(int index) {
            return (index - 1) / 2;
        }

        private int getLeftChildIndex(int index) {
            return 2 * index + 1;
        }

        private int getRightChildIndex(int index) {
            return 2 * index + 2;
        }

        public List<T> getHeap() {
            return heap;
        }
    }
    
}