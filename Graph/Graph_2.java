package Graph;
import java.util.*;

public class Graph_2 {

	
		private HashMap<Integer, HashMap<Integer, Integer>> map;

		public Graph_2(int v) {
			// TODO Auto-generated constructor stub
			map = new HashMap<>();
			for (int i = 1; i <= v; i++) {
				map.put(i, new HashMap<>());
			}
		}

		public void AddEdge(int v1, int v2, int cost) {
			map.get(v1).put(v2, cost);
			map.get(v2).put(v1, cost);
		}
	
	
	
	public boolean BFS(int src, int des) {
		Queue<Integer> q  = new LinkedList<>();
		HashSet<Integer> visited = new HashSet<>();
		q.add(src);
		while(!q.isEmpty()) {
			//1.Remove
			int r = q.poll();
			
			//Ignore if already Visited
			if(visited.contains(r)) continue;
			
			//3.Marked visited
			visited.add(r);
			
			//4.self work
			if(r==des) return true;
			
			//5. Add unvisited nbr
			for(int nbrs:map.get(r).keySet()) {
				if(!visited.contains(nbrs)) q.add(nbrs);
			}
		}return false;
	}
	
	//DFS uses stack
	
	public boolean DFS(int src, int des) {
		Stack<Integer> st  = new Stack<>();
		HashSet<Integer> visited = new HashSet<>();
		st.push(src);
		while(!st.isEmpty()) {
			//1.Remove
			int r = st.pop();
			
			//Ignore if already Visited
			if(visited.contains(r)) continue;
			
			//3.Marked visited
			visited.add(r);
			
			//4.self work
			if(r==des) return true;
			
			//5. Add unvisited nbr
			for(int nbrs:map.get(r).keySet()) {
				if(!visited.contains(nbrs)) st.push(nbrs);
			}
		}return false;
	}
	
	
	public void BFT() {
		Queue<Integer> q  = new LinkedList<>();
		HashSet<Integer> visited = new HashSet<>();
		
		for(int src : map.keySet()) {
			if(visited.contains(src)) continue;
			//c++;   // if wanted to count all components/edges.
			
		q.add(src);
		while(!q.isEmpty()) {
			//1.Remove
			int r = q.poll();
			
			//Ignore if already Visited
			if(visited.contains(r)) continue;
			
			//3.Marked visited
			visited.add(r);
			
			//4.self work
			System.out.println(r + " ");
			
			//5. Add unvisited nbr
			for(int nbrs:map.get(r).keySet()) {
				if(!visited.contains(nbrs)) q.add(nbrs);
			}
		  }System.out.println();
		}
	}
	
	public boolean DFT(int src, int des) {
		Stack<Integer> st  = new Stack<>();
		HashSet<Integer> visited = new HashSet<>();
		
		for(int src: map.keySet()) {
			if(visited.contains(src)) continue;
		
		st.push(src);
		while(!st.isEmpty()) {
			//1.Remove
			int r = st.pop();
			
			//Ignore if already Visited
			if(visited.contains(r)) continue;
			
			//3.Marked visited
			visited.add(r);
			
			//4.self work
			System.out.println(r + " ");
			
			//5. Add unvisited nbr
			for(int nbrs:map.get(r).keySet()) {
				if(!visited.contains(nbrs)) st.push(nbrs);
			}
		}
		}System.out.println();
	}

}
