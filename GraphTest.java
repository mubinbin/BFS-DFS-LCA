public class GraphTest {
    public static void main(String[] args) {

            // Graph.showGraph();
        
            Graph.addEdge("0", "2");
            Graph.addEdge("0", "1");
            // Graph.addEdge("1", "3");
            Graph.addEdge("1", "2");
            Graph.addEdge("3", "5");
            Graph.addEdge("3", "4");
            Graph.addEdge("3", "2");
            Graph.addEdge("5", "0");
            Graph.addEdge("4", "2");
            // Graph.addEdge("4", "5");

            Graph.showGraph();

            // Graph.dfs("2", "1");

            Graph.dfsAll("2");
            System.out.println(Graph.pathMap);

            // Graph.bfs("1", "4");
            // Graph.bfsAll("0");
    }
}
