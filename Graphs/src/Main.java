public class Main{
    public static void main(String[] args){
        Graph graph = new Graph(6, true);
        graph.addEdge(3,4);
        graph.addEdge(4,2);
        graph.addEdge(5,1);
        graph.addEdge(5,2);
        graph.addEdge(6,1);
        graph.addEdge(6,3);


        System.out.println(graph.topoSort());
    }
}