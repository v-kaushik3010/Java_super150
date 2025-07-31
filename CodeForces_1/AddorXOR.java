package CodeForces_1;
import java.io.*;
import java.util.*;

public class AddorXOR {
    static class Edge {
        int to, cost;
        Edge(int t, int c) { to = t; cost = c; }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(in.readLine().trim());
        final int MAX = 205;  // enough to cover a,b ≤100 plus detours
        StringBuilder sb = new StringBuilder();
        
        while (t-- > 0) {
            st = new StringTokenizer(in.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            // Build adjacency lists once per tes
            List<Edge>[] adj = new ArrayList[MAX + 1];
            for (int i = 0; i <= MAX; i++) {
                adj[i] = new ArrayList<>();
            }
            for (int u = 0; u <= MAX; u++) {
                if (u + 1 <= MAX) {
                    adj[u].add(new Edge(u + 1, x));
                }
                int v = u ^ 1;
                if (v >= 0 && v <= MAX) {
                    adj[u].add(new Edge(v, y));
                }
            }

            final int INF = Integer.MAX_VALUE / 2;
            int[] dist = new int[MAX + 1];
            Arrays.fill(dist, INF);
            dist[a] = 0;
            PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));
            pq.offer(new int[]{0, a});

            while (!pq.isEmpty()) {
                int[] cur = pq.poll();
                int d = cur[0], u = cur[1];
                if (d > dist[u]) continue;
                if (u == b) break;  // we found shortest for b
                for (Edge e : adj[u]) {
                    int nd = d + e.cost;
                    if (nd < dist[e.to]) {
                        dist[e.to] = nd;
                        pq.offer(new int[]{nd, e.to});
                    }
                }
            }

            int ans = dist[b] >= INF ? -1 : dist[b];
            sb.append(ans).append('\n');
        }

        System.out.print(sb.toString());
    }
}
