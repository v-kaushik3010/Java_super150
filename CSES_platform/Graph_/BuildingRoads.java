package Graph_;
import java.util.*;
public class BuildingRoads {
    static List<List<Integer>> graph;
    static boolean[] vis;

    static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        vis[start] = true;

        while (!q.isEmpty()) {
            int node = q.poll();

            for (int neigh : graph.get(node)) {
                if (!vis[neigh]) {
                    vis[neigh] = true;
                    q.add(neigh);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        vis = new boolean[n + 1];
        List<Integer> reps = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            if (!vis[i]) {
                reps.add(i);
                bfs(i);
            }
        }

        System.out.println(reps.size() - 1);

        for (int i = 1; i < reps.size(); i++) {
            System.out.println(reps.get(i - 1) + " " + reps.get(i));
        }

        sc.close();
    }

}
