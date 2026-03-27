package Graph_;
import java.util.*;

public class HighScore {

    static class Edge {
        int u, v;
        long w;

        Edge(int u, int v, long w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }
    }

    static final long INF = (long)1e18;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        List<Edge> edges = new ArrayList<>();
        List<List<Integer>> rev = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            rev.add(new ArrayList<>());
        }

        // input
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            long x = sc.nextLong();

            edges.add(new Edge(a, b, -x)); // negate
            rev.get(b).add(a); // reverse graph
        }

        // Step 1: find nodes that can reach n
        boolean[] canReachN = new boolean[n + 1];
        dfs(n, rev, canReachN);

        // Step 2: Bellman-Ford
        long[] dist = new long[n + 1];
        Arrays.fill(dist, INF);
        dist[1] = 0;

        for (int i = 1; i < n; i++) {
            for (Edge e : edges) {
                if (dist[e.u] == INF) continue;

                if (dist[e.u] + e.w < dist[e.v]) {
                    dist[e.v] = dist[e.u] + e.w;
                }
            }
        }

        // Step 3: detect useful negative cycle
        for (Edge e : edges) {
            if (dist[e.u] == INF) continue;

            if (dist[e.u] + e.w < dist[e.v]) {
                if (canReachN[e.v]) {
                    System.out.println(-1);
                    return;
                }
            }
        }

        // Step 4: result
        System.out.println(-dist[n]);
    }

    static void dfs(int node, List<List<Integer>> rev, boolean[] vis) {
        vis[node] = true;
        for (int nei : rev.get(node)) {
            if (!vis[nei]) {
                dfs(nei, rev, vis);
            }
        }
    }
}