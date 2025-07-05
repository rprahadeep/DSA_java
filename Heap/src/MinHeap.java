//minHeap

public class MinHeap {
    private int[] heap;
    private int size;
    private int capacity;

    public MinHeap(int capacity){
        this.capacity = capacity;
        this.size = 0;
        heap = new int[capacity];
    }

    //helper methods
    private int parent(int i) {return (i-1)/2;}
    private int left(int i) {return (i*2)+1;}
    private int right(int i) {return (i*2)+2;}
    private boolean isLeaf(int i) {return i>=size/2 && i<size;}

    //insert a new element
    public void insert(int val){
        if(size==capacity){
            throw new IllegalStateException("Heap is full");
        }

        heap[size] = val;
        int current = size;
        size++;

        while(heap[current] < heap[parent(current)]){
            swap(current, parent(current));
            current = parent(current);
        }
    }

    //remove min element
    public int removeMin(){
        if(size==0){
            throw new IllegalStateException("Heap is empty");
        }
        int min = heap[0];
        size--;
        heap[0] = heap[size];
        heapify(0);
        return min;
    }

    //heapify operation
    public void heapify(int i){
        if(isLeaf(i)) return;

        int left = left(i);
        int right = right(i);
        int smallest = i;

        if(left<size && heap[left]<heap[i]){
            smallest = left;
        }

        if(right<size && heap[right]<heap[i]){
            smallest = right;
        }

        if(smallest!=i){
            swap(i, smallest);
            heapify(smallest);
        }
    }

    //swap
    public void swap(int i, int  j){
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }
}