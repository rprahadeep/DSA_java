import java.util.*;
public class Main{
    public static void main(String[] args) throws Exception{
        Heap heap = new Heap();
        heap.insert(5);
        heap.insert(2);
        heap.insert(8);
        heap.insert(1);
        heap.insert(3);

        ArrayList<Integer> sorted = heap.heapsort();
        System.out.println(sorted);
    }
}