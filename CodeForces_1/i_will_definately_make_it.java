package CodeForces_1;


import java.io.*;
import java.util.*;

public class i_will_definately_make_it {
	
	    static class Tower {
	        int h, idx;
	        Tower(int h, int idx) {
	            this.h = h;
	            this.idx = idx;
	        }
	    }

	    public static void main(String[] args) throws IOException {
	        BufferedReader br = new BufferedReader(
	            new InputStreamReader(System.in));
	        StringTokenizer st = new StringTokenizer(br.readLine());
	        int t = Integer.parseInt(st.nextToken());
	        StringBuilder sb = new StringBuilder();
	        
	        while (t-- > 0) {
	            st = new StringTokenizer(br.readLine());
	            int n = Integer.parseInt(st.nextToken());
	            int k = Integer.parseInt(st.nextToken()) - 1; // zero-based

	            // read heights and find maximum
	            int[] h = new int[n];
	            int Hmax = 0;
	            st = new StringTokenizer(br.readLine());
	            for (int i = 0; i < n; i++) {
	                h[i] = Integer.parseInt(st.nextToken());
	                if (h[i] > Hmax) {
	                    Hmax = h[i];
	                }
	            }
	            
	            // if we already start on a max-height tower → YES
	            if (h[k] == Hmax) {
	                sb.append("YES\n");
	                continue;
	            }
	            
	            // sort towers by height
	            Tower[] arr = new Tower[n];
	            for (int i = 0; i < n; i++) {
	                arr[i] = new Tower(h[i], i);
	            }
	            Arrays.sort(arr, Comparator.comparingInt(tw -> tw.h));
	            
	            // build adjacency: only connect consecutive in sorted list
	            @SuppressWarnings("unchecked")
	            List<Integer>[] adj = new ArrayList[n];
	            for (int i = 0; i < n; i++) {
	                adj[i] = new ArrayList<>();
	            }
	            for (int i = 0; i + 1 < n; i++) {
	                int u = arr[i].idx, v = arr[i+1].idx;
	                int hu = arr[i].h, hv = arr[i+1].h;
	                // static threshold: max(h_u,h_v) <= 2*min(h_u,h_v) - 1
	                int mn = Math.min(hu, hv), mx = Math.max(hu, hv);
	                if (mx <= 2L * mn - 1) {
	                    adj[u].add(v);
	                    adj[v].add(u);
	                }
	            }
	            
	            // Dijkstra: dist[i] = earliest arrival time at tower i
	            final long INF = Long.MAX_VALUE / 4;
	            long[] dist = new long[n];
	            Arrays.fill(dist, INF);
	            dist[k] = 0;
	            PriorityQueue<long[]> pq = new PriorityQueue<>(
	                Comparator.comparingLong(a -> a[0])
	            );
	            pq.offer(new long[]{0, k});
	            boolean canReach = false;
	            
	            while (!pq.isEmpty()) {
	                long[] cur = pq.poll();
	                long t0 = cur[0];
	                int i0 = (int) cur[1];
	                if (t0 > dist[i0]) continue;
	                
	                // if this is a max-height tower, we succeeded
	                if (h[i0] == Hmax) {
	                    canReach = true;
	                    break;
	                }
	                
	                // try all adjacent towers
	                for (int j0 : adj[i0]) {
	                    int hi = h[i0], hj = h[j0];
	                    int diff = Math.abs(hi - hj);
	                    // dynamic bound: t0 <= 2*min(hi,hj) - max(hi,hj) - 1
	                    long bound = 2L * Math.min(hi, hj) - Math.max(hi, hj) - 1;
	                    if (bound < 0 || t0 > bound) {
	                        continue;
	                    }
	                    long t1 = t0 + diff;
	                    // must survive on tower j0 at arrival
	                    if (t1 > (long)hj - 1) {
	                        continue;
	                    }
	                    if (t1 < dist[j0]) {
	                        dist[j0] = t1;
	                        pq.offer(new long[]{t1, j0});
	                    }
	                }
	            }
	            
	            sb.append(canReach ? "YES\n" : "NO\n");
	        }
	        
	        System.out.print(sb);
	    }
	}


