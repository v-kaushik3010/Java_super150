package Graph;
import java.util.*;

class Pair{
	int node;
	int dist;
	Pair(int n, int d){
		node = n;
		dist = d;
		
	}
}
public class GandhiMarchDijkstra {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		ArrayList<Pair>[] graph = new ArrayList[n+1];
		
		for(int i = 1; i <= n ; i++) {
			graph[i] = new ArrayList<>();
			
		}
		for(int i = 0; i <m; i++) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			int w = sc.nextInt();
			graph[u].add(new Pair(v,w));
			graph[v].add(new Pair(u,w));
		}
		
		PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> a.dist - b.dist);
		int [] dist = new int[n+1];
		Arrays.fill(dist,  Integer.MAX_VALUE);
		
		pq.add(new Pair(1,0));
		dist[1] = 0;
		
		while(!pq.isEmpty()) {
			Pair curr = pq.poll();
			int node = curr.node;
			
			for(Pair edge: graph[node]) {
				int next = edge.node;
				int weight = edge.dist;
				
				if(dist[node] + weight < dist[next]) {
					dist[next] = dist[node] + weight;
					pq.add(new Pair(next, dist[next]));
					
				}
				
			}
		}
		System.out.print(dist[n]);
	}

}
