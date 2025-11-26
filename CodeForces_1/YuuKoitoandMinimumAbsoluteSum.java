package CodeForces_1;
import java.util.*;

public class YuuKoitoandMinimumAbsoluteSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];

            for (int i = 0; i < n; i++) a[i] = sc.nextInt();

            // find leftmost known value
            Integer left = null, right = null;

            for (int i = 0; i < n; i++) {
                if (a[i] != -1) {
                    left = a[i];
                    break;
                }
            }

            // find rightmost known value
            for (int i = n - 1; i >= 0; i--) {
                if (a[i] != -1) {
                    right = a[i];
                    break;
                }
            }

            // Case 1: all -1
            if (left == null) {
                System.out.println(0);
                for (int i = 0; i < n; i++) System.out.print(0 + " ");
                System.out.println();
                continue;
            }

            // answer = |right - left|
            int ans = Math.abs(right - left);

            // fill all -1 with lexicographically smallest → 0
            for (int i = 0; i < n; i++) {
                if (a[i] == -1) a[i] = 0;
            }

            // output
            System.out.println(ans);
            for (int x : a) System.out.print(x + " ");
            System.out.println();
        }
    }
}
