package Graph;
import java.util.*;

public class Longest_Cycle_in_a_Graph {
    public static void main(String[] args) {
        int[] edges = {3, 3, 4, 2, 3};
        Longest_Cycle_in_a_Graph obj = new Longest_Cycle_in_a_Graph();
        int result = obj.longestCycle(edges);
        System.out.println(result);
    }

    public int longestCycle(int[] edges){
        int [] in = new int [edges.length];
        for(int i = 0; i < edges.length; i++){
            if(edges[i] != -1){          // check for valid edge
                in[edges[i]]++;
            }            
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < in.length; i++){
            if(in[i] == 0){
                q.add(i);
            }
        }
        boolean[] visited = new boolean[edges.length];
        while(!q.isEmpty()){
            int e = q.poll();
            visited[e] = true;
          if (edges[e] != -1) {
             in[edges[e]]--;
                if (in[edges[e]] == 0) q.add(edges[e]);
                    }

        }
        
        int ans = -1;
        for(int i = 0; i < visited.length; i++){
            if(!visited[i]){
                int c = 1;
                visited[i] = true; // mark the start node as visited
                int nbrs = edges[i];
                while(nbrs != i){   // until we reach back to the start node
                    c++;            // increment cycle length
                    visited[nbrs] = true;     // mark neighbor as visited
                    nbrs = edges[nbrs];         // move to the next neighbor
                }
                ans = Math.max(ans, c);
            }
        }return ans;
    }
}
