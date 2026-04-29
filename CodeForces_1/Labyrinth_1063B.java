package CodeForces_1;
import java.util.*;


public class Labyrinth_1063B {


    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int r = sc.nextInt() - 1;
        int c = sc.nextInt() - 1;

        int x = sc.nextInt();
        int y = sc.nextInt();

        char[][] grid = new char[n][m];
        for (int i = 0; i < n; i++) {
            grid[i] = sc.next().toCharArray();
        }

        int[][] dist = new int[n][m];
        for (int[] row : dist) Arrays.fill(row, Integer.MAX_VALUE);

        Deque<int[]> dq = new ArrayDeque<>();

        dist[r][c] = 0;
        dq.addFirst(new int[]{r, c});

        while (!dq.isEmpty()) {
            int[] cur = dq.poll();
            int i = cur[0], j = cur[1];

            for (int d = 0; d < 4; d++) {
                int ni = i + dx[d];
                int nj = j + dy[d];

                if (ni < 0 || nj < 0 || ni >= n || nj >= m) continue;
                if (grid[ni][nj] == '*') continue;

                int cost = dist[i][j];

                // left move
                if (d == 2) cost++;

                if (cost < dist[ni][nj]) {
                    dist[ni][nj] = cost;

                    if (d == 2) dq.addLast(new int[]{ni, nj}); // left
                    else dq.addFirst(new int[]{ni, nj});       // up/down/right
                }
            }
        }

        int ans = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (dist[i][j] == Integer.MAX_VALUE) continue;

                int left = dist[i][j];
                int right = (j - c) + left;

                if (left <= x && right <= y) {
                    ans++;
                }
            }
        }

        System.out.println(ans);
		
		

	}

}
