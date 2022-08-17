package Problem4;


import java.util.ArrayList;
import java.util.LinkedList;

public class Graph{

    static ArrayList<String> cityInRouteFile = new ArrayList<>();
    // No of vertices
    static int vertices = 18;
    static ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>(vertices);

    public static void createGraph( ){
        // Adjacency list for storing which vertices are connected
//        ArrayList<ArrayList<Integer>> adj =
//                new ArrayList<ArrayList<Integer>>(v);

        for (int i = 0; i < vertices; i++) {
            adj.add(new ArrayList<Integer>());
        }

        // Creating graph
        // add_edge function takes adjacency list, source
        // and destination vertex as argument and forms
        // an edge between them.
        // 13 cities each with id's
        addEdge(adj, 0, 1);
        addEdge(adj, 1, 0);
        addEdge(adj, 2, 3);
        addEdge(adj, 3, 0);
        addEdge(adj, 0, 2);
        addEdge(adj, 2, 0);
        addEdge(adj, 0, 4);
        addEdge(adj, 4, 0);
        addEdge(adj, 4, 5);
        addEdge(adj, 5, 4);
        addEdge(adj, 6, 7);
        addEdge(adj, 7, 6);
        addEdge(adj, 7, 9);
        addEdge(adj, 9, 7);
        addEdge(adj, 6, 8);
        addEdge(adj, 8, 6);
        addEdge(adj, 9, 10);
        addEdge(adj, 10, 9);
        addEdge(adj, 7, 11);
        addEdge(adj, 11, 12);
        addEdge(adj, 12, 7);
        addEdge(adj, 5, 6);
        addEdge(adj, 6, 13);
        addEdge(adj, 13, 5);
        addEdge(adj, 12, 13);

        cityInRouteFile.add("London");
        cityInRouteFile.add("Paris");
        cityInRouteFile.add("Amsterdam");
        cityInRouteFile.add("Bristol");
        cityInRouteFile.add("Johannesburg");
        cityInRouteFile.add("Perth");
        cityInRouteFile.add("Sydney");
        cityInRouteFile.add("Brisbane");
        cityInRouteFile.add("New York");
        cityInRouteFile.add("Kuala Lumpur");
        cityInRouteFile.add("California");
        cityInRouteFile.add("Delhi");
        cityInRouteFile.add("Beijing");
        cityInRouteFile.add("Melbourne");
    }

    // function to form edge between two vertices
    // source and dest
    private static void addEdge( ArrayList<ArrayList<Integer>> adj, int i, int j ){
        //add the city ids to the graph edges
        adj.get(i).add(j);
    }

    public static String printDistance(String dept, String destination){

        int source = Integer.MAX_VALUE; //state a default city infinity
        int dest = Integer.MAX_VALUE;

        for(int i = 0; i<cityInRouteFile.size(); i++){
            if(dept.equals(cityInRouteFile.get(i))){
                source = i;
            }
            if(destination.equals(cityInRouteFile.get(i))) {
                dest = i;
            }
        }
        String path=printShortestDistance(adj,source,dest,vertices);
        return path;
    }

    // Method prints path between cities
    // using the source vertex and destination vertex
    private static String printShortestDistance( ArrayList<ArrayList<Integer>> adj, int sour, int dest, int v){

        // pred[i] array stores predecessor of
        // i and dist array stores distance of i from s
        int pred[] = new int[v];
        int dist[] = new int[v];

        if (BFS(adj, sour, dest, v, pred, dist) == false) {
            String errorMesssage="Given source and destination are not connected";
            return errorMesssage;
        }

        // LinkedList to store path
        LinkedList<Integer> path = new LinkedList<Integer>();
        int crawl = dest;
        path.add(crawl);
        while (pred[crawl] != -1) {
            path.add(pred[crawl]);
            crawl = pred[crawl];
        }

        String pathFound="The route is ";

        for (int i = path.size() - 1; i >= 0; i--) {

            //System.out.println(path.get(i) + " ");
            pathFound+=(cityInRouteFile.get(path.get(i)) + " ");
        }
        return pathFound;
    }

    // BFS method stores pred of each vertex in array pred
    // and its path distance from source in array dist
    private static boolean BFS( ArrayList<ArrayList<Integer>> adj, int src,
                               int dest, int v, int[] pred, int[] distance ){
        // a queue is used to maintain vertices whose
        // adjacency list is to be scanned

        LinkedList<Integer> queue = new LinkedList<Integer>();

        // boolean array visited[] which stores the true
        // if vertex is found during breadth first search
        // its done to reduce redudancy search on an already visited city

        boolean visited[] = new boolean[v];

        // all vertices are unvisited before the search
        // visited[i] for all i is false no path is identified
        // distance[i] for all i set to infinity possible path
        for (int i = 0; i < v; i++) {

            visited[i] = false;
            distance[i] = Integer.MAX_VALUE;
            pred[i] = -1;
        }

        // next source is first to be visited and
        // distance from source to itself should be 0
        visited[src] = true;
        distance[src] = 0;
        queue.add(src);

        //go through queue linkedlist, as long queue isn't empty
        while ( !queue.isEmpty() ) {

            int u = queue.remove();
            for (int i = 0; i < adj.get(u).size(); i++) {

                if (visited[adj.get(u).get(i)] == false){
                    visited[adj.get(u).get(i)] = true;
                    distance[adj.get(u).get(i)] = distance[u] + 1;
                    pred[adj.get(u).get(i)] = u;
                    queue.add(adj.get(u).get(i));

                    // when destination is found stop while loop
                    if (adj.get(u).get(i) == dest)
                        return true;
                }
            }
        }
        return false;
    }
}
