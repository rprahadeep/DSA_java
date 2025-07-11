import java.util.*;

//using adjacency list
public class Graph {
    private int vertices;
    ArrayList<Edge>[] graph;

    public class Edge{
        int source;        
        int destination;
        int weight;

        Edge(int s, int w, int d) {
            this.source = s;
            this.weight = w;
            this.destination = d;
        }
    }

    public void addEdge(int source, int weight, int destination){
        graph[source].add(new Edge(source, weight, destination));
    }

    public void display(){
        for(int i=0;i<vertices;i++){
            for(Edge e:graph[i]){
                System.out.print(e.source + "->" + e.destination + " - Weight = " + e.weight + ", ");
            }
            System.out.println();
        }
    }

    Graph(int v){
        this.vertices = v;
        graph = new ArrayList[v];
        for (int i = 0; i < v; i++) {
            graph[i] = new ArrayList<>();
        }
    }
}
