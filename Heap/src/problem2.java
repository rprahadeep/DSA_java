//leetcode 215
//find kth largest in an array

import java.util.*;
public class problem2 {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k);
        for(int num:nums){
            if(minHeap.size()<k){
                minHeap.offer(num);
            } else if(num>minHeap.peek()){
                minHeap.poll();
                minHeap.offer(num);
            }
        }

        return minHeap.peek();
    }
}
