package Algorithms;

//https://www.geeksforgeeks.org/problems/implementing-dijkstra-set-1-adjacency-matrix/1

import java.util.*;

public class Dijkstra {
    public static void main(String[] args){
        int v = 3;
        int[][] edges = {
                {0, 1, 1},
                {1, 2, 3},
                {0, 2, 6}
        };
        int src = 2;

        int[] ans = dijkstra(v, edges, src);
        System.out.println(Arrays.toString(ans));
    }


    static class Edge{
        int node;
        int weight;

        Edge(int node, int weight){
            this.node = node;
            this.weight = weight;
        }
    }

    public static int[] dijkstra(int v, int[][] edges, int src){

        ArrayList<ArrayList<Edge>> adj = new ArrayList<>();
        int[] dis = new int[v];
        for(int i=0;i<v;i++){
            adj.add(new ArrayList<>());
            dis[i] = Integer.MAX_VALUE;
        }

        for(int[] edge:edges){
            adj.get(edge[0]).add(new Edge(edge[1], edge[2]));
            adj.get(edge[1]).add(new Edge(edge[0], edge[2]));
        }

        PriorityQueue<Edge> pq = new PriorityQueue<>((a,b)->a.weight-b.weight);
        dis[src] = 0;
        pq.offer(new Edge(src, 0));

        while(!pq.isEmpty()){
            Edge edge = pq.poll();
            int node = edge.node;
            int weight = edge.weight;

            for(Edge nei:adj.get(node)){
                int nnode = nei.node;
                int distance = nei.weight;
                // If we find a shorter path to a neighboring node, update the distance and add the node to the priority queue
                if(dis[nnode] > weight + distance){
                    dis[nnode] = weight + distance;
                    pq.offer(new Edge(nnode, dis[nnode]));
                }
            }
        }


        return dis;
    }
}
