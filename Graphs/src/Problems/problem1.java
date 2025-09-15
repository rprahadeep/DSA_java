package Problems;
// leetcode 210
// topological sort in bfs

import java.util.*;

public class problem1 {

    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] ans = new int[numCourses];

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0;i<prerequisites.length;i++){
            int[] temp = prerequisites[i];
            adj.get(temp[1]).add(temp[0]);
        }

        int[] indegree = new int[numCourses];
        for(int i=0;i<numCourses;i++){
            for(int num:adj.get(i)){
                indegree[num]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0){
                q.offer(i);
            }
        }

        int count = 0;
        while(!q.isEmpty()){
            int node = q.poll();
            ans[count] = node;
            count++;

            for(int it:adj.get(node)){
                indegree[it]--;
                if(indegree[it]==0){
                    q.offer(it);
                }
            }
        }

        if(count == numCourses){
            return ans;
        }
        int[] arr = {};
        return arr;
    }



    public static void main(String[] args){
        int[][] prerequisites = {
                {1, 0},
                {2, 0},
                {3, 1},
                {3, 2}
        };

        int numCourses = 4;

        int[] ans = findOrder(numCourses, prerequisites);

        System.out.println(Arrays.toString(ans));
    }
}
