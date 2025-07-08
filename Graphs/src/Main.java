public class Main{
    public static void main(String[] args){
        Graph graph =  new Graph(4);
        graph.addEdge(0,2,2);
        graph.addEdge(1,10,2);
        graph.addEdge(1,0,3);
        graph.addEdge(2,2,0);
        graph.addEdge(2,10,1);
        graph.addEdge(2,-1,3);
        graph.addEdge(3,0,1);
        graph.addEdge(3,-1,2);

        graph.display();
    }
}