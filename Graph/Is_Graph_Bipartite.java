package Graph;
import java.util.*;

public class Is_Graph_Bipartite {
	class Solution {
	    //1. all acyclic graph are bipertite.
	    //2. in Cyclic graph: if cycle is even length of vertices = bipertite
	    //                    if odd length cycle = never bipartite

	  

	    public boolean isBipartite(int[][] graph) {
	        
	    	Queue<BipartitePair> q = new LinkedList<>();
	    	HashMap<Integer, Integer> visited = new HashMap<>();
	    	for(int i = 0; i < graph.length; i++) { 
	    		//vtx
	    		if(visited.containsKey(i)) {
	    			continue;
	    		}
	    		q.add(new BipartitePair(i,0));
	    		while(!q.isEmpty()) {
	    		    //1. remove 
	    			BipartitePair rp = q.poll();
	    			
	    		    //2. ignore :already marked
	    			if(visited.containsKey(rp.vtx)) {
	    				if(visited.get(rp.vtx) != rp.dis) {
	    					return false;
	    				}continue;
	    			}
	    			
	    		    //3.marked visited
	    			visited.put(rp.vtx, rp.dis);
	    		    //4. self work
	    			
	    		    //5. Add unvisited nbrs : to queue
	    			for(int nbrs: graph[rp.vtx]) {
	    				if(!visited.containsKey(nbrs)) {
	    					q.add(new BipartitePair(nbrs, rp.dis +1));
	    				}
	    			}
	    		}
	    		
	    	}return true;
	    }
	}
	
	class BipartitePair{
		int vtx;
		int dis;
		public BipartitePair(int vtx, int dis) {
			this.vtx= vtx;
			this.dis= dis;
		}
		
	}
}
