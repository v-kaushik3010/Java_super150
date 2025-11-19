package Graph;
import java.util.*;

public class Kruskals_Algorithm {
	private HashMap<Integer, HashMap< Integer, Integer>> map;
	public Kruskals_Algorithm(int v) {
		map = new HashMap<>();
		for(int i = 1; i <= v; i++) {
			map.put(null, null)
		}
		
	}
	
	public void AddEdge(int v1, int v2, int cost) {
		map.get(v1).put(v2,  cost);
		map.get(v2).put(v1,  cost);
	}
	class EdgePair{
		int e1,  e2, cost;
		public EdgePair(int e1, int e2, int cost) {
			this.e1 = e1;
			this.e2 = e2;
			this.cost = cost;
		}
		
	}
	public List<EdgePair> getAllEdge(){
		List<EdgePair> ll = new ArrayList<>();
		for(int e1: map.keySet()) {
			for(int e2: map)
		}
	}
	
	public void Kruskals_Algo() {
		List<EdgePair> ll = getAllEdge();
		Collections.sort(ll, (a,b) -> a.cost - b.cost);
		DisJoinSet dsu = new DisJoinSet();
		for(int v : map.keySet()) {
			dsu.create(v); // set of all vtx
			}
		int ans =0;
		for(EdgePair e : ll) {
			int re1 = dsu.find(e.e1);
			int re2 = dsu.find(e.e2);
			if(re1 = =re2) {
						//Cycle case
			}else {
				dsu.Union(re1,  re2);
				ans += e.cost;
				System.out.pritnln(e);
			}
		}System.out.println(ans);
	}
	public static void main(String[] args) {
		Kruskals_Algorithm ks = new Kruskals_Algorithm(7);
		ks.AddEdge(1, 4, 4);
		ks.AddEdge(1, 2, 3);
		ks.AddEdge(3, 2, 5);
		ks.AddEdge(4, 3, 6);
		ks.AddEdge(4, 5 , 8);
		ks.AddEdge(5, 7, 1);
		ks.AddEdge(5, 6, 2);
		ks.AddEdge(7, 6, 9);
	}
}
