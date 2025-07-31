package CodeForces_1;

import java.io.*;
import java.util.*;

public class MEX {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        // Process each test case
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] freq = new int[n + 1];

            // Read array and build frequencies for values in [0..n]
            for (int i = 0; i < n; i++) {
                int x = sc.nextInt();
                if (x <= n) {
                    freq[x]++;
                }
            }

            // diff array for interval-add over k = 0..n
            int[] diff = new int[n + 2];

            // We'll scan mex = m from 0..n.
            // Maintain prefixValid = true as long as all 0..m-1 exist.
            boolean prefixValid = true;
            for (int m = 0; m <= n; m++) {
                if (m > 0 && freq[m - 1] == 0) {
                    prefixValid = false;
                }
                if (!prefixValid) {
                    break;
                }

                // To achieve MEX = m:
                //   * remove all occurrences of m  ⇒  L = freq[m]
                //   * keep at least one of each < m    ⇒  k ≤ n - m
                int L = freq[m];
                int R = n - m;
                if (L <= R) {
                    diff[L]++;
                    diff[R + 1]--;
                }
            }

            // Build the answer by prefix-summing diff
            int[] ans = new int[n + 1];
            int curr = 0;
            for (int k = 0; k <= n; k++) {
                curr += diff[k];
                ans[k] = curr;
            }

            // Output n+1 values for k = 0..n
            StringBuilder sb = new StringBuilder();
            for (int k = 0; k <= n; k++) {
                if (k > 0) sb.append(' ');
                sb.append(ans[k]);
            }
            System.out.println(sb);
        }
    }

	}


