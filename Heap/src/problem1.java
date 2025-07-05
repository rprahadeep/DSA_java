//leetcode 1046
import java.util.*;
public class problem1 {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b)->b-a); //custom comparator
        // priorityQueue is a minheap by default, so in order to make it maxheap, use custom comparator
        for(int num:stones){
            maxHeap.offer(num);
        }

        while(maxHeap.size()>1){
            int y = maxHeap.poll();
            int x = maxHeap.poll();
            if(x!=y){
                maxHeap.offer(y-x);
            }
        }

        if(maxHeap.isEmpty()) return 0;

        return maxHeap.poll();
    }
}
