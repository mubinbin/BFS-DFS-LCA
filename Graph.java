import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Graph{
    
    public static HashMap<String, String> pathMap = new HashMap<String, String>();
    private static HashMap<String, ArrayList<String>> adjMap = new HashMap<String, ArrayList<String>>();
    private static ArrayList<String> visited = new ArrayList<String>();

    private static ArrayList<String> eulerList = new ArrayList<String>();
    private static ArrayList<Integer> depthList = new ArrayList<Integer>();

    public static void addEdge(String vertex1, String vertex2){
        if(adjMap.containsKey(vertex1)){
            ArrayList<String> nestedList = adjMap.get(vertex1);
            
            if(nestedList.contains(vertex2)) return;
            nestedList.add(vertex2);
        }else{
            ArrayList<String> nestedList = new ArrayList<String>();
            nestedList.add(vertex2);
            adjMap.put(vertex1, nestedList);

        }

        addEdge(vertex2, vertex1);
    }

    public static void addEdgeOneDirection(String vertex1, String vertex2){
        if(adjMap.containsKey(vertex1)){
            ArrayList<String> nestedList = adjMap.get(vertex1);
            
            if(nestedList.contains(vertex2)) return;
            nestedList.add(vertex2);
        }else{
            ArrayList<String> nestedList = new ArrayList<String>();
            nestedList.add(vertex2);
            adjMap.put(vertex1, nestedList);
        }
    }

    public static void showGraph() {
        if(adjMap.size() == 0) throw new Error("No graph exsits!");

        System.out.println(adjMap);
    }

    public static void bfs(String start, String end){
        if(start.equals(end)){
            showPath(start, end);
            return;
        } 

        visited.clear();
        if(adjMap.containsKey(start)){
            Queue<String> queue = new LinkedList<String>();
            queue.add(start);
            visited.add(start);

            while(!queue.isEmpty()){
                String currentVertex = queue.poll();

                if(currentVertex.equals(end)){
                    showPath(start, end);
                    return;
                } 

                ArrayList<String> nestedList = adjMap.get(currentVertex);
                for (String element : nestedList) {
                    if(!visited.contains(element)){
                        pathMap.put(element, currentVertex);
                        queue.add(element);
                        visited.add(element);
                    }
                }
            }

            throw new Error("No paths exist!");
        }

        throw new Error("No paths exist!");
    }

    public static void bfsAll(String start){ 

        visited.clear();
        if(adjMap.containsKey(start)){
            Queue<String> queue = new LinkedList<String>();
            queue.add(start);
            visited.add(start);

            while(!queue.isEmpty()){
                String currentVertex = queue.poll();

                ArrayList<String> nestedList = adjMap.get(currentVertex);
                for (String element : nestedList) {
                    if(!visited.contains(element)){
                        pathMap.put(element, currentVertex);
                        queue.add(element);
                        visited.add(element);
                    }
                }
            }

            System.out.println(pathMap);
            return;
        }

        throw new Error("No paths exist!");
    }


    public static void dfs(String start, String end){
        dfsImplementation(start, end);
        showPath(start, end);
    }

    public static void dfsAll(String start){
        if(adjMap.containsKey(start)){
            visited.add(start);
            
            ArrayList<String> nestedList = adjMap.get(start);
            
            for(int i =0; i < nestedList.size(); i ++){
                String element = nestedList.get(i);
                
                if(visited.contains(element) && i != nestedList.size()-1){
                    continue;
                }else if(visited.contains(element) && i == nestedList.size()-1){
                    return;
                }else{
                    pathMap.put(element, start);
                    dfsAll(element);
                }
            }
            return;
        }
        
        throw new Error("No paths exist!");
    }

    private static void dfsImplementation(String start, String end){
        if(start.equals(end)){
            visited.add(start);
            return;
        } 
        
        if(adjMap.containsKey(start)){
            visited.add(start);
            
            ArrayList<String> nestedList = adjMap.get(start);
            
            for(int i =0; i < nestedList.size(); i ++){
                String element = nestedList.get(i);
                
                if(visited.contains(element) && i != nestedList.size()-1){
                    continue;
                }else if(visited.contains(element) && i == nestedList.size()-1){
                    return;
                }else{
                    pathMap.put(element, start);
                    dfsImplementation(element, end);
                }
            }
            return;
        }
        
        throw new Error("No paths exist!");
    }

    private static void showPath(String start, String end){
        String path = "";

        if(pathMap.get(end) == null){
            throw new Error("No paths exist!");
        }

        if(start.equals(end)){
            path = start;
            System.out.print(path);
            return;
        }

        while(pathMap.get(end) != null && !pathMap.get(end).equals(start)){
            path = " -> " + end + path;
            end = pathMap.get(end);
        }

        path = start+" -> "+ end + path;
        System.out.print(path +"\n");
    }

    public static void euler(String start){
        
        int currentDepth = 0;
        eulerPrivate(start, eulerList, depthList, currentDepth);

    }

    private static void eulerPrivate(String start, ArrayList<String> eulerList, ArrayList<Integer> depthList, int currentDepth){
        eulerList.add(start);
        depthList.add(currentDepth);

        if(!adjMap.containsKey(start)){
            return;
        }

        ArrayList<String> nestedList = adjMap.get(start);


        for (int i =0; i < nestedList.size(); i++) {
            String element = nestedList.get(i);

            if(i > 0){
                eulerList.add(start);
                depthList.add(currentDepth);
            }
            
            if (i == nestedList.size()-1 && !adjMap.containsKey(element)){
                eulerList.add(element);
                depthList.add(currentDepth+1);
                eulerList.add(start);
                depthList.add(currentDepth);

                return;
            }
                
            eulerPrivate(element, eulerList, depthList, currentDepth+1);
        }
        eulerList.add(start);
        depthList.add(currentDepth);
    }
    
    public static String lca(String node1, String node2, String startNode){
        if(node1.equals(node2)) return node1;



        euler(startNode);
        
        int indexOfNode1 = eulerList.indexOf(node1) < eulerList.indexOf(node2)?  eulerList.indexOf(node1): eulerList.indexOf(node2);
        int indexOfNode2 = eulerList.indexOf(node1) > eulerList.indexOf(node2)?  eulerList.indexOf(node1): eulerList.indexOf(node2);

        int minDepthBetweenNode1AndNode2 = depthList.get(indexOfNode1);
        int indexOfMinDepth = indexOfNode1;
        for(int i = indexOfNode1; i <= indexOfNode2; i++){
            if(depthList.get(i) < minDepthBetweenNode1AndNode2){
                minDepthBetweenNode1AndNode2 = depthList.get(i);
                indexOfMinDepth = i;
            }
        }

        String lca = eulerList.get(indexOfMinDepth);
        return lca;
    }
}