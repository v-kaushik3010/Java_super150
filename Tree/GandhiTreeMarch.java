package Tree;

import java.util.*;

public class GandhiTreeMarch {
    static int idx;
    static Map<Integer, int[]> map;

    static void dfs(String s, int col) {

        char ch = s.charAt(idx++);

        if (ch == '.') return;

        map.computeIfAbsent(col, k -> new int[26])[ch - 'a']++;

        idx++; // skip '('

        dfs(s, col - 1);
        dfs(s, col + 1);

        idx++; // skip ')'
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {

            int C = sc.nextInt();
            String s = sc.next();

            map = new HashMap<>();
            idx = 0;

            dfs(s, 0);

            if (!map.containsKey(C)) {
                System.out.println("Common Gandhijee!");
            } 
            else {

                int[] freq = map.get(C);
                StringBuilder ans = new StringBuilder();

                for (int i = 0; i < 26; i++) {
                    while (freq[i]-- > 0) {
                        ans.append((char)('a' + i));
                    }
                }

                System.out.println(ans.toString());
            }
        }sc.close();
    }
}
