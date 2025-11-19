package CodeForces_1;
import java.io.*;
import java.util.*;

public class For_The_Champion {
    static final int MOD = 998244353;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String[] gdata = br.readLine().split(" ");
            int n = Integer.parseInt(gdata[0]);
            int m = Integer.parseInt(gdata[1]);
            int V = Integer.parseInt(gdata[2]);
            int[] a = new int[n];
            String[] line = br.readLine().split(" ");
            for(int i=0; i<n; i++) {
                a[i] = Integer.parseInt(line[i]);
            }
            ArrayList<Integer>[] adj = new ArrayList[n];
            for(int i=0; i<n; i++) adj[i]=new ArrayList<>();
            for(int i=0; i<m; i++) {
                String[] uvs = br.readLine().split(" ");
                int u = Integer.parseInt(uvs[0]) - 1;
                int v = Integer.parseInt(uvs[1]) - 1;
                adj[u].add(v);
                adj[v].add(u);
            }
            System.out.println(solve(n, m, V, a, adj));
        }
    }

    static int solve(int n, int m, int V, int[] a, ArrayList<Integer>[] adj) {
        int[] val = new int[n];
        Arrays.fill(val, -1);
        boolean[] vis = new boolean[n];
        int free = 0;
        Queue<Integer> q = new ArrayDeque<>();
        boolean ok = true;

        for (int i = 0; i < n; i++) {
            if (vis[i]) continue;
            // Find value for this component
            int freeThis = 0;
            q.add(i);
            if (a[i] != -1) val[i] = a[i];
            else { val[i] = 0; freeThis++; }
            vis[i] = true;
            while (!q.isEmpty()) {
                int u = q.poll();
                for (int v : adj[u]) {
                    if (!vis[v]) {
                        if (a[v] != -1) {
                            val[v] = a[v];
                        } else {
                            val[v] = val[u];
                            freeThis++;
                        }
                        vis[v] = true;
                        q.add(v);
                    } else {
                        // Already visited: check cycle
                        int required = val[u] ^ val[v];
                        // Each edge forms a xor 0 constraint: val[u] ^ val[v] == 0 (for balanced paths)
                        if (required != 0) {
                            ok = false;  // Contradiction
                        }
                    }
                }
            }
            free += freeThis == 0 ? 0 : 1; // Only one free variable per component
        }
        if (!ok) return 0;
        return modPow(V, free, MOD);
    }

    public static int modPow(int a, int b, int mod) {
        long res = 1, x = a;
        while (b > 0) {
            if ((b & 1) == 1) res = (res * x) % mod;
            x = (x * x) % mod;
            b >>= 1;
        }
        return (int)res;
    }
}
