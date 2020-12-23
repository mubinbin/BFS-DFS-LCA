public class GraphTest {
    public static void main(String[] args) {

            // Graph.showGraph();
        
            Graph.addEdgeOneDirection("1", "2");
            Graph.addEdgeOneDirection("1", "3");
            Graph.addEdgeOneDirection("1", "4");
            Graph.addEdgeOneDirection("2", "5");
            Graph.addEdgeOneDirection("2", "6");
            Graph.addEdgeOneDirection("3", "7");
            Graph.addEdgeOneDirection("4", "8");
            Graph.addEdgeOneDirection("4", "9");
            Graph.addEdgeOneDirection("4", "10");
            Graph.addEdgeOneDirection("5", "11");
            Graph.addEdgeOneDirection("11", "12");
            Graph.addEdgeOneDirection("11", "13");
            Graph.addEdgeOneDirection("7", "14");
            Graph.addEdgeOneDirection("7", "15");
            Graph.addEdgeOneDirection("15", "16");
            Graph.addEdgeOneDirection("15", "17");
            Graph.addEdgeOneDirection("15", "18");

            // Graph.addEdgeOneDirection("1", "2");
            // Graph.addEdgeOneDirection("1", "3");
            // Graph.addEdgeOneDirection("2", "4");
            // Graph.addEdgeOneDirection("2", "5");
            // Graph.addEdgeOneDirection("2", "6");
            // Graph.addEdgeOneDirection("3", "7");
            // Graph.addEdgeOneDirection("3", "8");



            // Graph.addEdgeOneDirection("1", "2");
            // Graph.addEdgeOneDirection("1", "3");
            // Graph.addEdgeOneDirection("1", "4");
            // Graph.addEdgeOneDirection("2", "5");
            // Graph.addEdgeOneDirection("2", "6");
            // Graph.addEdgeOneDirection("3", "7");
            // Graph.addEdgeOneDirection("4", "8");
            // Graph.addEdgeOneDirection("4", "9");
            // Graph.addEdgeOneDirection("4", "10");
            // Graph.addEdgeOneDirection("5", "11");
            // Graph.addEdgeOneDirection("11", "12");
            // Graph.addEdgeOneDirection("11", "13");
            // Graph.addEdgeOneDirection("7", "14");
            // Graph.addEdgeOneDirection("7", "15");
            // Graph.addEdgeOneDirection("15", "16");
            // Graph.addEdgeOneDirection("15", "17");
            // Graph.addEdgeOneDirection("15", "18");

            Graph.showGraph();
            // Graph.euler("1");
            Graph.lca("9", "12", "1");

            // Graph.dfs("1", "5");

            // Graph.dfsAll("2");
            // System.out.println(Graph.pathMap);

            // Graph.bfs("1", "4");
            // Graph.bfsAll("0");
    }
}
