import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class GraphTraversal {

    public static List<List<Integer>> adjList;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        adjList = new ArrayList<>();
        intializeAjacencyList();
        System.out.println("Input 1 to get BFS traversal of graph or 2 to get DFS traversal");
        int i =Integer.parseInt(br.readLine());
        if(i==1) {
            traverseGraphUsingBFS();
        }
        // else if(i==2) {
        //     traverseGraphUsingDFS();
        // }
    }

    public static void traverseGraphUsingBFS() {
        Queue<Integer> queue= new LinkedList<>();
        queue.add(0);
        boolean[] visited =new boolean[adjList.size()];
        while(!queue.isEmpty()) {
            int node = queue.remove();
            if(visited[node]) {
                continue;
            }
            visited[node] = true;
            System.out.print(node+" ");
            for(int i: adjList.get(node)) {
                if(!visited[i]) {
                    queue.add(i);
                }
            }
        }
    }

    private static void intializeAjacencyList() {
        adjList.add(new ArrayList<Integer>(){
            {   
                add(1);
                add(2);
                add(5);
            }
        });
        adjList.add(new ArrayList<Integer>(){
            {   
                add(0);
                add(3);
            }
        });
        adjList.add(new ArrayList<Integer>(){
            {   
                add(0);
                add(4);
            }
        });
        adjList.add(new ArrayList<Integer>(){
            {   
                add(1);
                add(5);
            }
        });
        adjList.add(new ArrayList<Integer>(){
            { 
                add(2);
                add(5);
            }
        });
        adjList.add(new ArrayList<Integer>(){
            { 
                add(0);
                add(3);
                add(5);
            }
        });
    }
}