import java.util.*;

public class Graph{
    private final int vertices;
    private final boolean directed;
    ArrayList<ArrayList<Integer>> graph;

    Graph(int v, boolean d){
        vertices = v;
        directed = d;
        graph = new ArrayList<>();
        for(int i=0;i<v;i++){
            graph.add(new ArrayList<>());
        }
    }

    public void addEdge(int source, int destination){
        graph.get(source-1).add(destination);
        if(!directed){
            graph.get(destination-1).add(source);
        }
    }

    public void display(){
        for(int i=0;i<vertices;i++){
            System.out.println((i+1) + " - " + graph.get(i));
        }
    }

    public void bfs(int startNode){
        ArrayList<Integer> ans = new ArrayList<>();
        boolean[] visited = new boolean[vertices];
        visited[startNode - 1] = true;

        Queue<Integer> q = new LinkedList<>();
        q.offer(startNode);

        while(!q.isEmpty()){
            int current = q.poll();
            ans.add(current);
            for(int node:graph.get(current-1)){
                if(!visited[node-1]){
                    q.offer(node);
                    visited[node-1] = true;
                }
            }
        }
        System.out.println(ans);
    }

    public void dfs(int startNode){
        boolean[] visited = new boolean[vertices];
        ArrayList<Integer> ans = new ArrayList<>();
        dfshelper(startNode, visited, ans);
        System.out.println(ans);
    }

    private void dfshelper(int current, boolean[] visited, ArrayList<Integer> ans){
        ans.add(current);
        visited[current - 1] = true;
        for(int node:graph.get(current-1)){
            if(!visited[node-1]){
                dfshelper(node, visited, ans);
            }
        }
    }

    //CYCLE DETECTION IN UNDIRECTED GRAPH

    //using bfs
    public boolean hasCycleBFS(){
        boolean[] visited = new boolean[vertices];

        for(int i=1;i<=vertices;i++){
            if(!visited[i-1]){
                if(bfsCycleCheck(i, visited)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean bfsCycleCheck(int start, boolean[] visited){
        visited[start - 1] = true;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {start, -1});

        while(!q.isEmpty()){
            int[] temp = q.poll();
            int current = temp[0];
            int parent = temp[1];

            for(int neighbor:graph.get(current-1)){
                if(!visited[neighbor-1]){
                    visited[neighbor-1] = true;
                    q.offer(new int[] {neighbor, current});
                }else if(neighbor!=parent){
                    return true;
                }
            }
        }
        return false;
    }

    //using dfs
    public boolean hasCycleDFS(){
        boolean[] visited = new boolean[vertices];

        for(int i=1;i<=vertices;i++){
            if(!visited[i-1]){
                if(dfsCycleCheck(i, -1, visited)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfsCycleCheck(int current, int parent, boolean[] visited){
        visited[current-1] = true;
        for(int neighbor:graph.get(current-1)){
            if(!visited[neighbor-1]){
                if(dfsCycleCheck(neighbor, current, visited)){
                    return true;
                }
            }else if(neighbor!=parent){
                return true;
            }
        }
        return false;
    }

    //TOPOLOGICAL SORTING
    //directed acyclic graph - using DFS
    public ArrayList<Integer> topoSort(){
        boolean[] visited = new boolean[vertices];
        Stack<Integer> st = new Stack<>();
        for(int i=1;i<=vertices;i++){
            if(!visited[i-1]){
                topoDFS(i, visited, st);
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();
        while(!st.isEmpty()){
            ans.add(st.pop());
        }
        return ans;
    }

    private void topoDFS(int node, boolean[] visited, Stack<Integer> st){
        visited[node - 1] = true;
        for(int neighbor:graph.get(node-1)){
            if(!visited[neighbor-1]){
                topoDFS(neighbor, visited, st);
            }
        }
        st.push(node);
    }

}