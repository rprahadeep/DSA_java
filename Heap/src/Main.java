import java.util.*;
public class Main{
    public static void main(String[] args) throws Exception{
        MinHeap heap = new MinHeap(5);
        heap.insert(5);
        heap.insert(2);
        heap.insert(6);
        heap.insert(3);

        System.out.println(heap.removeMin());
        System.out.println(heap.removeMin());
    }
}