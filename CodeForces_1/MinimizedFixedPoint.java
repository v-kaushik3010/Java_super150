package CodeForces_1;


import java.io.*;
import java.util.*;

public class MinimizedFixedPoint {
	
    static final int MAXN = 100000;
    static boolean[] isPrime = new boolean[MAXN + 1];
    static List<Integer> primes = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        sieve(MAXN);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();

        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            int[] p = new int[n + 1];
            boolean[] used = new boolean[n + 1];

            // 1 is free—we just fix p[1]=1
            p[1] = 1;
            used[1] = true;

            // Any prime > n/2 has no other multiple ≤ n, so it must map to itself
            for (int prime : primes) {
                if (prime > n) break;
                if (prime * 2 > n) {
                    p[prime] = prime;
                    used[prime] = true;
                }
            }

            // For primes ≤ n/2, form a cycle among all of their unassigned multiples
            for (int i = primes.size() - 1; i >= 0; i--) {
                int prime = primes.get(i);
                if (prime * 2 > n) break;   // stop once prime > n/2

                // collect all multiples of 'prime' that are not yet used
                List<Integer> cycle = new ArrayList<>();
                for (int m = prime; m <= n; m += prime) {
                    if (!used[m]) {
                        cycle.add(m);
                    }
                }

                // if there's at least one multiple, cycle them
                // (in fact for prime ≤ n/2 there will be ≥2)
                int sz = cycle.size();
                for (int j = 0; j < sz; j++) {
                    int from = cycle.get(j);
                    int to   = cycle.get((j + 1) % sz);
                    p[from] = to;
                    used[from] = true;
                }
            }

            // Sanity check (debug only—remove for performance):
            // for (int i = 1; i <= n; i++) if (p[i] == 0)
            //     throw new RuntimeException("Unassigned at i=" + i);

            // Print the full permutation p[1..n]
            for (int i = 1; i <= n; i++) {
                out.append(p[i]).append(i == n ? '\n' : ' ');
            }
        }

        System.out.print(out);
    }

    // Standard Sieve of Eratosthenes
    static void sieve(int N) {
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;
        for (int i = 2; i * i <= N; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= N; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        for (int i = 2; i <= N; i++) {
            if (isPrime[i]) primes.add(i);
        }
    }


	}


