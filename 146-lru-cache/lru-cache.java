class LRUCache {
      int lruCacheSize;
    Map<Integer, Node> lruCacheMap = new HashMap<>();
    DLL dll;
    int currentCacheSize = 0;

    public LRUCache(int capacity) {
        dll = new DLL(capacity);
        this.lruCacheSize=capacity;
    }

    public int get(int key) {
        if(!lruCacheMap.containsKey(key)){
            return -1;
        }
        dll.updateNode(lruCacheMap.get(key));
        return lruCacheMap.get(key).getValue().get(key);
    }

    public void updateNode(Node node, int value){
        node.updateValue(value);
    }

    public void put(int key, int value) {
        if(lruCacheMap.containsKey(key)){
            updateNode(lruCacheMap.get(key), value);
            dll.updateNode(lruCacheMap.get(key));
        } else {
            if(currentCacheSize == lruCacheSize){
                Node deletedNode = dll.deleteTail();
                lruCacheMap.remove(deletedNode.getKey());
            } else {
                currentCacheSize++;
            }
            Node node = dll.addNode(key, value);
            lruCacheMap.put(key, node);
        }

    }

}

class Node{
    Map<Integer,Integer> nodeValue = new HashMap<>();
    int key;
    Node next;
    Node prev;

    Map<Integer,Integer> getValue(){
        return this.nodeValue;
    }

    Node(int key, int value){
        this.nodeValue.put(key,value);
        this.key=key;
    }

    Integer getKey(){
        return this.key;
    }

    void updateValue(int value){
        nodeValue.put(key, value);
    }
}


class DLL{
    int lruCacheCapacity;
    Node head = new Node(-1, -1);
    Node tail = new Node(-1, -1);
    int currentSize = 0;

    public DLL(int size) {
        this.lruCacheCapacity = size;
        head.next=tail;
        head.prev=null;
        tail.prev=head;
        tail.next=null;
    }

    public Node deleteTail(){
        Node tailNode = tail.prev;
        tailNode.prev.next = tailNode.next;
        tail.prev = tailNode.prev;
        return tailNode;
    }

    public Node addNode(int key, int value) {
        Node tempNode = head.next;
        Node newNode = new Node(key, value);
        head.next = newNode;
        newNode.next = tempNode;
        tempNode.prev = newNode;
        newNode.prev = head;
        return newNode;
    }

    public void updateNode(Node latestNode){
        Node prev = latestNode.prev;
        Node next = latestNode.next;
        prev.next = next;
        next.prev = prev;
        Node tempNode = head.next;
        head.next = latestNode;
        latestNode.next = tempNode;
        tempNode.prev = latestNode;
        latestNode.prev = head;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */