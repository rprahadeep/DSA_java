import java.util.*;

public class Heap{
    private ArrayList<Integer> heap;

    public Heap(){
        heap = new ArrayList<>();
    }

    public void insert(int val){
        heap.add(val);
        upheap(heap.size()-1);
    }

    public int remove() throws Exception{
        if(heap.isEmpty()) throw new Exception("Heap Empty");

        int min = heap.get(0);
        int last = heap.remove(heap.size()-1);

        if(!heap.isEmpty()){
            heap.set(0, last);
            downheap(0);
        }

        return min;
    }

    public ArrayList<Integer> heapsort() throws Exception {
        ArrayList<Integer> result = new ArrayList<>();
        while (!heap.isEmpty()) {
            result.add(remove());
        }
        return result;
    }

    private void upheap(int i) {
        while (i > 0) {
            int parent = (i - 1) / 2;
            if (heap.get(i) < heap.get(parent)) {
                swap(i, parent);
                i = parent;
            } else {
                break;
            }
        }
    }

    private void downheap(int i) {
        int size = heap.size();
        while (true) {
            int left = 2 * i + 1;
            int right = 2 * i + 2;
            int smallest = i;

            if (left < size && heap.get(left) < heap.get(smallest)) smallest = left;
            if (right < size && heap.get(right) < heap.get(smallest)) smallest = right;

            if (smallest != i) {
                swap(i, smallest);
                i = smallest;
            } else {
                break;
            }
        }
    }

    private void swap(int i, int j) {
        int temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }
}