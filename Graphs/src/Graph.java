import java.util.*;

// Graph using adjacency list
// 1 based indexing
public class Graph {
    private int vertices;
    private boolean directed;
    ArrayList<ArrayList<int[]>> graph;

    Graph(int v, boolean d) {
        this.vertices = v;
        this.directed = d;
        graph = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            graph.add(new ArrayList<>());
        }
    }

    public void addEdge(int source, int destination) {
        graph.get(source - 1).add(new int[]{source, destination});

        if (!directed) {
            graph.get(destination - 1).add(new int[]{destination, source});
        }
    }

    public void display() {
        for (int i = 0; i < vertices; i++) {
            for (int[] edge : graph.get(i)) {
                System.out.print(edge[0] + " -> " + edge[1] + ", ");
            }
            System.out.println();
        }
    }

    public void bfs(int startNode){
        ArrayList<Integer> ans = new ArrayList<>();
        boolean[] visited = new boolean[this.vertices];
        Queue<Integer> q = new LinkedList<>();
        q.offer(startNode);
        visited[startNode - 1] = true;

        while(!q.isEmpty()){
            int current = q.poll();
            ans.add(current);
            for(int[] edge:graph.get(current-1)){
                int node = edge[1];
                if(!visited[node-1]){
                    q.offer(node);
                    visited[node-1] = true;
                }
            }
        }
        System.out.println(ans);
    }

    public void dfs(int startNode) {
        boolean[] visited = new boolean[this.vertices];
        ArrayList<Integer> ans = new ArrayList<>();
        dfsHelper(startNode, visited, ans);
        System.out.println(ans.toString());
    }

    private void dfsHelper(int current, boolean[] visited, ArrayList<Integer> ans) {
        visited[current - 1] = true;
        ans.add(current);

        for (int[] edge : graph.get(current - 1)) {
            int neighbor = edge[1];
            if (!visited[neighbor - 1]) {
                dfsHelper(neighbor, visited, ans);
            }
        }
    }

    public boolean hasCycleBFS() {
        boolean[] visited = new boolean[vertices];

        for (int i = 1; i <= vertices; i++) {
            if (!visited[i - 1]) {
                if (bfsCycleCheck(i, visited)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean bfsCycleCheck(int start, boolean[] visited) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{start, -1}); // {currentNode, parentNode}
        visited[start - 1] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int node = current[0];
            int parent = current[1];

            for (int[] edge : graph.get(node - 1)) {
                int neighbor = edge[1];

                if (!visited[neighbor - 1]) {
                    visited[neighbor - 1] = true;
                    queue.offer(new int[]{neighbor, node});
                } else if (neighbor != parent) {
                    return true; // found a back-edge, hence a cycle
                }
            }
        }

        return false;
    }

    public boolean hasCycleDFS() {
        boolean[] visited = new boolean[vertices];

        for (int i = 1; i <= vertices; i++) {
            if (!visited[i - 1]) {
                if (dfsCycleCheck(i, -1, visited)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean dfsCycleCheck(int current, int parent, boolean[] visited) {
        visited[current - 1] = true;

        for (int[] edge : graph.get(current - 1)) {
            int neighbor = edge[1];

            if (!visited[neighbor - 1]) {
                if (dfsCycleCheck(neighbor, current, visited)) {
                    return true;
                }
            } else if (neighbor != parent) {
                return true; // visited, but not parent => back edge → cycle
            }
        }

        return false;
    }

}
