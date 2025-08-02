public class Main{
    public static void main(String[] args){
        Graph graph = new Graph(7, false);
        graph.addEdge(1,2);
        graph.addEdge(2,5);
        graph.addEdge(5,7);
        graph.addEdge(1,3);
        graph.addEdge(3,6);
        graph.addEdge(6,7);
        graph.addEdge(3,4);

        graph.bfs(1);
    }
}