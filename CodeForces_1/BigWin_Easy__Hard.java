package CodeForces_1;

//G1. Big Wins! (easy version)
//time limit per test4 seconds
//memory limit per test256 megabytes
//This is the easy version of the problem. The difference between the versions is that in this version ai≤min(n,100)
//.
//
//You are given an array of n
// integers a1,a2,…,an
//.
//
//Your task is to find a subarray a[l,r]
// (a continuous sequence of elements al,al+1,…,ar
//) for which the value of the expression med(a[l,r])−min(a[l,r])
// is maximized.
//
//Here:
//
//med
// — the median of the subarray, which is the element at position ⌈k+12⌉
// after sorting the subarray, where k
// is its length;
//min
// — the minimum element of this subarray.
//For example, consider the array a=[1,4,1,5,3,3]
// and choose the subarray a[2,5]=[4,1,5,3]
//. In sorted form, it looks like [1,3,4,5]
//.
//
//med(a[2,5])=4
//, since ⌈4+12⌉=
// the third element in the sorted subarray is 4
//;
//min(a[2,5])=1
//, since the minimum element is 1
//.
//In this example, the value med−min=4−1=3
//.
//
//Input
//The first line contains an integer t
// (1≤t≤104
//) — the number of test cases.
//
//The first line of each test case contains one integer n
// (1≤n≤2⋅105
//) — the length of the array.
//
//The second line of each test case contains n
// integers a1,a2,…,an
// (1≤ai≤min(n,100)
//) — the elements of the array.
//
//It is guaranteed that the sum of n
// across all test cases does not exceed 2⋅105
//.
//
//Output
//For each test case, output a single integer — the maximum possible value of med−min
// among all subarrays of the array.
//
//Example
//InputCopy
//5
//5
//3 2 5 3 1
//4
//4 1 1 3
//7
//6 1 3 4 6 2 7
//4
//4 2 3 1
//5
//1 2 3 4 5
//OutputCopy
//3
//3
//5
//2
//2
//Note
//In the first example, consider the array: a=[3, 2, 5, 3, 1]
// you can choose the subarray a[2, 3]
//, which consists of the elements [2, 5]
//.
//
//The length of the subarray is 2
//.
//The median is the element at position ⌈32⌉=2
// in the sorted subarray. After sorting, we get [2, 5]
//, med=5
//.
//The minimum element of the subarray: min=2
//.
//Therefore, med−min=5−2=3
//, which is the maximum answer.
//
//In the second test, the array: a=[4, 1, 1, 3]
// you can choose the subarray a[1, 2]
//, which consists of the elements [4, 1]
//.
//
//The length of the subarray is 2
//.
//The median is the element at position ⌈32⌉=2
// in the sorted subarray. After sorting, we get [1, 4]
//, med=4
//.
//The minimum element of the subarray: min=1
//.
//Therefore, med−min=4−1=3
//.
//
//It can be proven that both of these subarrays are optimal and yield the maximum value of the expression med−min
//.
//
//

//
//import java.io.*;
//import java.util.*;
//
//
//public class BigWin_Easy__Hard {
//
//	   static final int NEG_INF = Integer.MIN_VALUE / 2;
//	    static int[] a;
//	    static boolean[] present;
//
//	    public static void main(String[] args) throws IOException {
//	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//	        StringBuilder out = new StringBuilder();
//	        int t = Integer.parseInt(br.readLine().trim());
//
//	        while (t-- > 0) {
//	            int n = Integer.parseInt(br.readLine().trim());
//	            a = new int[n];
//
//	            StringTokenizer st = new StringTokenizer(br.readLine());
//	            int maxAi = 0;
//	            present = new boolean[101];
//
//	            for (int i = 0; i < n; i++) {
//	                a[i] = Integer.parseInt(st.nextToken());
//	                if (a[i] <= 100) present[a[i]] = true;
//	                maxAi = Math.max(maxAi, a[i]);
//	            }
//
//	            int answer = 0;
//	            // Try each possible minimum value v that appears
//	            for (int v = 1; v <= maxAi; v++) {
//	                if (!present[v]) continue;
//	                // Binary search the largest d so that there's a subarray
//	                // with min=v and median >= v+d
//	                int lo = 0, hi = maxAi - v;
//	                while (lo < hi) {
//	                    int mid = (lo + hi + 1) >>> 1;
//	                    if (existsSubarray(n, v, v + mid)) {
//	                        lo = mid;
//	                    } else {
//	                        hi = mid - 1;
//	                    }
//	                }
//	                answer = Math.max(answer, lo);
//	            }
//
//	            out.append(answer).append('\n');
//	        }
//
//	        System.out.print(out);
//	    }
//
//	    // Check if there's a contiguous segment where all values >= v,
//	    // that contains at least one == v, and has median >= x.
//	    static boolean existsSubarray(int n, int v, int x) {
//	        int i = 0;
//	        while (i < n) {
//	            // skip values < v
//	            while (i < n && a[i] < v) i++;
//	            if (i >= n) break;
//	            int j = i;
//	            while (j < n && a[j] >= v) j++;
//	            // segment [i..j-1] has all >= v
//	            if (checkSegmentDP(i, j - 1, v, x)) {
//	                return true;
//	            }
//	            i = j;
//	        }
//	        return false;
//	    }
//
//	    // In a[l..r], all a[k] >= v.  We need a subarray that
//	    // includes at least one a[k]==v and whose median >= x.
//	    // Map val = +1 if a[k]>=x, else -1.
//	    // Median >= x <=> sum over subarray >= 0.
//	    // We maintain dp0 = best sum ending here without any v,
//	    //               dp1 = best sum ending here with at least one v.
//	    static boolean checkSegmentDP(int l, int r, int v, int x) {
//	        int dp0 = 0;
//	        int dp1 = NEG_INF;
//
//	        for (int k = l; k <= r; k++) {
//	            int val = (a[k] >= x ? 1 : -1);
//	            if (a[k] == v) {
//	                // we must include this v if it appears here
//	                int newDp1 = dp1 + val;             // extend an existing v‐inclusive subarray
//	                newDp1 = Math.max(newDp1, dp0 + val); // take a subarray with no v so far, now include this v
//	                newDp1 = Math.max(newDp1, val);       // start fresh at this v
//	                dp1 = newDp1;
//	                dp0 = NEG_INF;                       // can't have "no‐v" subarray ending here
//	            } else {
//	                // no new v, so only extend
//	                dp1 = dp1 + val; 
//	                dp0 = Math.max(dp0 + val, val);
//	            }
//	            // if at any point a v‐inclusive subarray has non‐negative sum, median ≥ x
//	            if (dp1 >= 0) {
//	                return true;
//	            }
//	        }
//	        return false;
//	    }
//
//	}





import java.io.*;
import java.util.*;

public class BigWin_Easy__Hard {
    static final int NEG_INF = Integer.MIN_VALUE / 2;
    static int[] a;
    static int n, d;

    public static void main(String[] args) throws IOException {
        FastReader in = new FastReader();
        PrintWriter out = new PrintWriter(System.out);

        int t = in.nextInt();
        while (t-- > 0) {
            n = in.nextInt();
            a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = in.nextInt();
            }

            // Binary search for the largest d so that check(d) is true.
            int lo = 0, hi = n;
            while (lo < hi) {
                int mid = (lo + hi + 1) >>> 1;
                d = mid;
                if (existsSubarrayWithMedMinusMinAtLeastD()) {
                    lo = mid;
                } else {
                    hi = mid - 1;
                }
            }
            out.println(lo);
        }

        out.flush();
    }

    // Returns true if there is some subarray [L..R] with med – min >= d.
    static boolean existsSubarrayWithMedMinusMinAtLeastD() {
        // Compute next‐smaller‐to‐left (LS) and to‐right (RS) for each index.
        int[] LS = new int[n], RS = new int[n];
        Deque<Integer> st = new ArrayDeque<>();

        // LS: previous index with a[LS[i]] < a[i]
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && a[st.peek()] >= a[i]) st.pop();
            LS[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }

        st.clear();
        // RS: next index with a[RS[i]] < a[i]
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && a[st.peek()] > a[i]) st.pop();
            RS[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }
        st.clear();

        // For each j, we know the segment [L..R] = [LS[j]+1 .. RS[j]-1]
        // in which a[j] is the minimum.  We test each j by a linear pass over that segment.
        // We bail out immediately once any j succeeds.

        for (int j = 0; j < n; j++) {
            int L = LS[j] + 1, R = RS[j] - 1;
            if (checkSegment(L, R, j)) {
                return true;
            }
        }
        return false;
    }

    // In the segment [L..R], a[j] is the unique minimum.
    // We ask: is there a subarray of [L..R] that crosses j
    // and has at least half its elements >= a[j]+d?
    // Equivalently, turn each element i into +1 if a[i]>=a[j]+d, else -1,
    // and ask if there's a crossing‐j subarray with sum >= 1.
    static boolean checkSegment(int L, int R, int j) {
        int v = a[j], threshold = v + d;

        // 1) Build best suffix sum ending at j from the left
        int bestLeft = NEG_INF, sum = 0;
        for (int i = j; i >= L; i--) {
            sum += (a[i] >= threshold ? +1 : -1);
            bestLeft = Math.max(bestLeft, sum);
        }
        // If we can already do it purely on the left side, great.
        if (bestLeft >= 1) return true;

        // 2) Walk from j to R accumulating
        sum = 0;
        for (int i = j; i <= R; i++) {
            sum += (a[i] >= threshold ? +1 : -1);
            // Any crossing‐j subarray = (suffix from [L..j]) + (prefix from [j..i])
            // has sum = bestLeft + sum, so check ≥ 1.
            if (sum + bestLeft >= 1) {
                return true;
            }
        }

        return false;
    }

    // Fast IO
    static class FastReader {
        final BufferedInputStream in = new BufferedInputStream(System.in);
        final byte[] buf = new byte[1<<20];
        int ptr = 0, len = 0;

        int read() throws IOException {
            if (ptr >= len) {
                len = in.read(buf);
                ptr = 0;
                if (len < 0) return -1;
            }
            return buf[ptr++];
        }

        int nextInt() throws IOException {
            int c, x = 0;
            do { c = read(); } while (c != -1 && c <= ' ');
            boolean neg = false;
            if (c == '-') {
                neg = true;
                c = read();
            }
            for (; c >= '0' && c <= '9'; c = read()) {
                x = x * 10 + (c - '0');
            }
            return neg ? -x : x;
        }
    }
}