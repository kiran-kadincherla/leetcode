class Solution {
    ArrayList<Integer> heap = new ArrayList<>();

    //helper methods required -- leftChild, rightChild, parent

    public int getLeftChildIndex(int currentIndex){
        return 2 * currentIndex + 1;
    }

    public int getRightChildIndex(int currentIndex){
        return 2 * currentIndex + 2;
    }

    public int getParentIndex(int currentIndex) {
        return (currentIndex - 1) / 2;
    }

    public ArrayList<Integer> getHeap(){
        return heap;
    }

    public void swapIndex(int index1, int index2){
        int tempValue = heap.get(index1);
        heap.set(index1, heap.get(index2));
        heap.set(index2, tempValue);

    }

    public void insert(int value){
        heap.add(value);
        int currentIndex = heap.size()-1;
        while (currentIndex > 0 && heap.get(getParentIndex(currentIndex)) < heap.get(currentIndex)){
            swapIndex(currentIndex,getParentIndex(currentIndex));
            currentIndex = getParentIndex(currentIndex);
        }
    }

    public void sinkDown(int index){
        int maxvalue_index = index;

        while(true){
            int left_index = getLeftChildIndex(index);
            int right_index = getRightChildIndex(index);
            if(left_index < heap.size() && heap.get(left_index) > heap.get(maxvalue_index)) {
                maxvalue_index =  left_index;
            }
            if(right_index < heap.size() && heap.get(right_index) > heap.get(maxvalue_index)) {
                maxvalue_index =  right_index;
            }
            if(maxvalue_index != index){
                swapIndex(maxvalue_index, index);
                index = maxvalue_index;
            } else {
                return;
            }
        }
    }

    public Integer remove(){
        if(heap.isEmpty())
            return null;
        if(heap.size() == 1){
            return heap.remove(0);
        }
       int maxValue = heap.get(0);
       heap.set(0, heap.remove(heap.size()-1));
       sinkDown(0);
       return maxValue;
    }

    public int findKthLargest(int[] nums, int k) {
        Arrays.stream(nums).forEach(this::insert);
        int highestElement = 0;
        for(int i=0;i<k;i++){
            highestElement = remove();
        }
        return highestElement;
    }
}