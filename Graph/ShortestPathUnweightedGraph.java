import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ShortestPathUnweightedGraph {
    public static List<List<Integer>> adjList;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        adjList = new ArrayList<>();
        intializeAjacencyList();
        int[] shortestDistanceMap = new int[adjList.size()+1]; 
        int node =Integer.parseInt(br.readLine());
        traverseGraphAndUpdateShortestDistance(node,shortestDistanceMap);
        for(int i=0;i<shortestDistanceMap.length;i++) {
            if(shortestDistanceMap[i]!=0) {
                System.out.println("Node: "+i+" Distance: "+shortestDistanceMap[i]);
            }
        }
    }

    private static void traverseGraphAndUpdateShortestDistance(int node,int[] shortestDistanceMap) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited =new boolean[adjList.size()+1];
        visited[node] =true;
        queue.add(node);
        queue.add(null);
        int distance =0;
        while(!queue.isEmpty()) {
            Integer curr = queue.remove();
            if(curr == null) {
                distance++;
                if(!queue.isEmpty()) {
                    queue.add(null);
                }
                continue;
            }
            shortestDistanceMap[curr] =distance;
            for(int child: adjList.get(curr)) {
                if(!visited[child]) {
                    visited[child]=true;
                    queue.add(child);
                }
            }
        }
    }

    private static void intializeAjacencyList() {
        adjList.add(new ArrayList<Integer>(){
            {   
                add(1);
                add(2);
                add(4);
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
                add(3);
                add(4);
            }
        });
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
                add(2);
                add(5);
            }
        });
        adjList.add(new ArrayList<Integer>(){
            { 
                add(3);
                add(4);
            }
        });
    }
    
}
