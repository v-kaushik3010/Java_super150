package Greedy;
import java.util.*;

public class MaximumSum1946B {
    static final long MOD = 1_000_000_007;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t  = sc.nextInt();
        while(t-->0){
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[] a = new int[n];
            for(int i=0;i<n;i++) a[i] = sc.nextInt();
            
            // Compute original sum (true value, may be negative)
            long originalSum = 0;
            for (int x : a) originalSum += x;

            // Kadane's algorithm for max subarray sum (0 if all negative)
            long maxSub = 0, cur = 0;
            for (int x : a) {
                cur = Math.max(0, cur + x);
                maxSub = Math.max(maxSub, cur);
            }

            long ans;
            if (maxSub == 0) {
                // No benefit from operations — apply mathematical mod to originalSum
                ans = ((originalSum % MOD) + MOD) % MOD;
            } else {
                // Final sum = originalSum + maxSub * (2^k - 1)
                // = originalSum + maxSub * 2^k - maxSub
                // All computed mod MOD
                long pow2k = modPow(2, k, MOD);
                long contribution = (maxSub % MOD) * ((pow2k - 1 + MOD) % MOD) % MOD;
                ans = ((originalSum % MOD) + MOD + contribution) % MOD;
            }
            
            sb.append(ans).append('\n');
        }
        System.out.print(sb);
        sc.close();
    }

    static long modPow(long base, long exp, long mod) {
        long result = 1;
        base %= mod;
        while (exp > 0) {
            if ((exp & 1) == 1) result = result * base % mod;
            base = base * base % mod;
            exp >>= 1;
        }
        return result;
    }
}
