package CodeForces_1;

import java.util.*;

public class countSubsequences {
    static final int MOD = 998244353;

    // Function to count all non-empty subsequences
    static long countSsubsequences(String s) {
        int n = s.length();
        // Calculate 2^n - 1 (total non-empty subsequences)
        return (1L << n) - 1;
    }

    // Function to flip a character at position idx in the string
    static String flipAndCompute(String s, int idx) {
        char[] arr = s.toCharArray();
        arr[idx] = arr[idx] == '0' ? '1' : '0';
        return new String(arr);
    }

    // Main solve function for the test cases
    public static void solve() {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();  // number of test cases

        while (t-- > 0) {
            // Read the binary string and number of queries
            String s = sc.next();
            int q = sc.nextInt();

            // Read the queries
            int[] queries = new int[q];
            for (int i = 0; i < q; i++) {
                queries[i] = sc.nextInt() - 1;  // adjusting to 0-based index
            }

            // Initial computation for subsequences
            long initialSubsequences = countSsubsequences(s);

            // Process each query and output the result
            for (int query : queries) {
                // Flip the character at the query index
                s = flipAndCompute(s, query);
                System.out.print(initialSubsequences + " ");  // print the result for this query
            }
            System.out.println();
        }

        sc.close();
    }

    public static void main(String[] args) {
        solve();
    }
}

