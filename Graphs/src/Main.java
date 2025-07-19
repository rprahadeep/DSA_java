public class Main{
    public static void main(String[] args){
        Graph graph = new Graph(9, false);
        graph.addEdge(1, 2);
        graph.addEdge(1, 6);
        graph.addEdge(2, 3);
        graph.addEdge(2, 4);
        graph.addEdge(4, 5);
        graph.addEdge(5, 8);
        graph.addEdge(6, 7);
        graph.addEdge(6, 9);
        graph.addEdge(7, 8);

        graph.bfs(1);
    }
}