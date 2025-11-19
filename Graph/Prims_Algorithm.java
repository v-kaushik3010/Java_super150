package Graph;
import java.util.*;

public class Prims_Algorithm {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		private HashMap<Integer, HashMap<Integer, Integer>> map;
		
		
		public Prims_Algorithm(int v) {
			map = new HashMap<>();
			for(int i = 1; i <= v; i++) {
				map.put(i, new HashMap<>());
			}
			
		}
		
		public void AddEdge(int v1, int v2, int cost) {
			map.get(v1).put(v2,  cost);
			map.get(v2).put(v1,  cost);
			
		}
		
		class PrimsPair{
			int vtx;
			int acq_vtx;
			int cost;
			public PrimsPair(int vtx, int acq_vtx, int cost) {
				this.vtx = vtx;
				this.acq_vtx = acq_vtx;
				this.cost = cost;
			}
			
		
	}
		public void PrimsAlgorithm() {
			PriorityQueue<PrimsPair> pq = new PriorityQueue<>();
			pq.add(new PrimsPair(1, 1, 0));
			while(!pq.isEmpty()) {
				//1.Remove
				PrimsPair rp = pq.poll();
				//2. Ignore if already visited
				If(visited.contains(rp.vtx)) continue;
				//3. Marked Visited
				visited.add(rp.vtx);
				
				// 4. Self Work
				System.out.println(rp);
				//5. Add nbrs
				for(int nbrs:map.get(rp.vtx).keySet()) {
					if(!visited.contains(nbrs)) {
						int cost = map.get(rp.vtx).get(nbrs);
						pq.add(new PrimsPair(nbrs,rp.vtx, cost));
					}
				}
					
				}
				
		}
}

