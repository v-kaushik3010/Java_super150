package CSES_platform.Graph_;
import java.util.*;

public class Labyrinth {

    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, 1, -1};
    static char[] dir = {'D', 'U', 'R', 'L'};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        char[][] grid = new char[n][m];

        for (int i = 0; i < n; i++) {
            grid[i] = sc.next().toCharArray();
        }

        boolean[][] vis = new boolean[n][m];
        int[][] parentR = new int[n][m];
        int[][] parentC = new int[n][m];
        char[][] move = new char[n][m];

        int sr = 0, sc1 = 0;

        // find A
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 'A') {
                    sr = i;
                    sc1 = j;
                }
            }
        }

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{sr, sc1});
        vis[sr][sc1] = true;

        boolean found = false;
        int endR = -1, endC = -1;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0];
            int c = cur[1];

            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if (nr < 0 || nc < 0 || nr >= n || nc >= m) continue;
                if (grid[nr][nc] == '#' || vis[nr][nc]) continue;

                vis[nr][nc] = true;

                parentR[nr][nc] = r;
                parentC[nr][nc] = c;
                move[nr][nc] = dir[i];

                if (grid[nr][nc] == 'B') {
                    found = true;
                    endR = nr;
                    endC = nc;
                    break;
                }

                q.add(new int[]{nr, nc});
            }
            if (found) break;
        }

        if (!found) {
            System.out.println("NO");
            return;
        }

        // reconstruct path
        StringBuilder path = new StringBuilder();
        int r = endR, c = endC;

        while (grid[r][c] != 'A') {
            path.append(move[r][c]);

            int pr = parentR[r][c];
            int pc = parentC[r][c];

            r = pr;
            c = pc;
        }

        path.reverse();

        System.out.println("YES");
        System.out.println(path.length());
        System.out.println(path.toString());
    }
}