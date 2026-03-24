package CSES_platform.Graph_;

import java.util.*;
public class CountingRooms {

    public static void markedNbrsDfs(char[][] grid, boolean[][] visited, int r, int c){
        int n = grid.length;
        int m = grid[0].length;
        if(r>=n || c >=m || r<0 || c<0 || grid[r][c] == '#' || visited[r][c]) return;
        visited[r][c] = true;
        markedNbrsDfs(grid, visited, r+1, c);
        markedNbrsDfs(grid, visited, r-1, c);        //DFS gives StackOverflow for large input n =1000, m=1000
        markedNbrsDfs(grid, visited, r, c+1);
        markedNbrsDfs(grid, visited, r, c-1);

    }

    public static void markedNbrsBfs(char[][] grid, boolean[][] visited, int r, int c){
        int n = grid.length;
        int m = grid[0].length;
        int [] dr = {1, -1, 0, 0};
        int [] dc = {0, 0, 1, -1};
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{r, c});
        visited[r][c] = true;

        while (!q.isEmpty()) {
            int[]cur = q.poll();
            int cr = cur[0];;
            int cc = cur[1];
            for(int i = 0; i < 4 ; i++){
                int nr = cr + dr[i];
                int nc = cc + dc[i];
                if(nr>=n || nc >=m || nr<0 || nc<0 || grid[nr][nc] == '#' || visited[nr][nc]) continue;
                visited[nr][nc] = true;
                q.add(new int[]{nr, nc});
            }
        }

    }

    public static void main(String[] args) {
            
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int m = sc.nextInt();
    char [][] grid = new char[n][m];

    boolean [][] visited = new boolean[n][m];

    for(int i =0;i < n ; i++){
        grid[i] = sc.next().toCharArray();
    }
    int count = 0;
    for(int i = 0; i < n ; i++){
        for(int j = 0; j < m ; j++){
            if(grid[i][j] == '.' && !visited[i][j]){
                count++;
                markedNbrsBfs(grid, visited, i, j);
            }
        }

    }
    System.out.println(count);
    sc.close();
    }}

