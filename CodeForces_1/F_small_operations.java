package CodeForces_1;

import java.io.*;
import java.util.*;

public class F_small_operations {
	

	    // Function to find all divisors of a number
	    private static List<Integer> getDivisors(int n) {
	        List<Integer> divisors = new ArrayList<>();
	        for (int i = 1; i * i <= n; i++) {
	            if (n % i == 0) {
	                divisors.add(i);
	                if (i * i != n) {
	                    divisors.add(n / i);
	                }
	            }
	        }
	        return divisors;
	    }

	    // BFS function to calculate distances using only division
	    private static Map<Integer, Integer> bfs(int startNode, int k) {
	        Map<Integer, Integer> dist = new HashMap<>();
	        Queue<Integer> queue = new LinkedList<>();

	        dist.put(startNode, 0);
	        queue.add(startNode);

	        while (!queue.isEmpty()) {
	            int u = queue.poll();

	            // Find neighbors by division
	            List<Integer> divisors = getDivisors(u);
	            for (int d : divisors) {
	                if (d > 1 && d <= k) {
	                    int v = u / d;
	                    if (!dist.containsKey(v)) {
	                        dist.put(v, dist.get(u) + 1);
	                        queue.add(v);
	                    }
	                }
	            }
	             // We can also get to 1 by dividing by the number itself if allowed
	            if (u > 1 && u <= k) {
	                 if (!dist.containsKey(1)) {
	                    dist.put(1, dist.get(u) + 1);
	                    queue.add(1);
	                 }
	            }
	        }
	        return dist;
	    }

	    public static void main(String[] args) {
	        FastReader sc = new FastReader();
	        PrintWriter out = new PrintWriter(System.out);
	        int t = sc.nextInt();
	        while (t-- > 0) {
	            int x = sc.nextInt();
	            int y = sc.nextInt();
	            int k = sc.nextInt();

	            if (x == y) {
	                out.println(0);
	                continue;
	            }
	            if (k == 1) {
	                out.println(-1);
	                continue;
	            }

	            // Phase 1: BFS from x downwards (division only)
	            Map<Integer, Integer> distFromX = bfs(x, k);

	            // Phase 2: BFS from y downwards (equivalent to multiplication from m to y)
	            Map<Integer, Integer> distFromY = bfs(y, k);

	            long minOps = Long.MAX_VALUE;

	            // Find the best meeting point m
	            for (Map.Entry<Integer, Integer> entry : distFromX.entrySet()) {
	                int meetingNode = entry.getKey();
	                int opsFromX = entry.getValue();

	                if (distFromY.containsKey(meetingNode)) {
	                    int opsFromY = distFromY.get(meetingNode);
	                    minOps = Math.min(minOps, (long) opsFromX + opsFromY);
	                }
	            }
	            
	            // A special case: transforming x to 1, then 1 to y
	            if (x <= k && y != 1) {
	                // Path: x -> 1 -> y. Cost is 1 + distFromY.get(1)
	                if(distFromY.containsKey(1)){
	                     minOps = Math.min(minOps, 1L + distFromY.get(1));
	                }
	            }
	            if (y <= k && x != 1) {
	                 // Path: x -> 1 -> y. Cost is distFromX.get(1) + 1
	                 if(distFromX.containsKey(1)){
	                     minOps = Math.min(minOps, 1L + distFromX.get(1));
	                 }
	            }
	            if (x <=k && y <= k && x!=1 && y!=1){
	                 minOps = Math.min(minOps, 2L); // x -> 1 -> y
	            }


	            if (minOps == Long.MAX_VALUE) {
	                out.println(-1);
	            } else {
	                out.println(minOps);
	            }
	        }
	        out.flush();
	    }

	    // Fast I/O template
	    static class FastReader {
	        BufferedReader br;
	        StringTokenizer st;

	        public FastReader() {
	            br = new BufferedReader(new InputStreamReader(System.in));
	        }

	        String next() {
	            while (st == null || !st.hasMoreElements()) {
	                try {
	                    st = new StringTokenizer(br.readLine());
	                } catch (IOException e) {
	                    e.printStackTrace();
	                }
	            }
	            return st.nextToken();
	        }

	        int nextInt() {
	            return Integer.parseInt(next());
	        }
	    }
	

}
