package CodeForces_1;


import java.io.*;
import java.util.*;

public class GCD_Unlucky {

	

	    public static void main(String[] args) throws IOException {
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        StringBuilder out = new StringBuilder();
	        int t = Integer.parseInt(br.readLine().trim());
	        
	        while (t-- > 0) {
	            int n = Integer.parseInt(br.readLine().trim());
	            long[] p = new long[n];
	            long[] s = new long[n];
	            
	            StringTokenizer st = new StringTokenizer(br.readLine());
	            for (int i = 0; i < n; i++) {
	                p[i] = Long.parseLong(st.nextToken());
	            }
	            
	            st = new StringTokenizer(br.readLine());
	            for (int i = 0; i < n; i++) {
	                s[i] = Long.parseLong(st.nextToken());
	            }
	            
	            boolean ok = true;
	            
	            // 1) The overall gcd from prefix and suffix must match.
	            if (p[n-1] != s[0]) {
	                ok = false;
	            }
	            
	            // 2) p must form a non-increasing chain of divisibilities:
	            //    p[i] divides p[i-1].
	            for (int i = 1; i < n && ok; i++) {
	                if (p[i-1] % p[i] != 0) {
	                    ok = false;
	                }
	            }
	            
	            // 3) s must form a non-decreasing chain of divisibilities:
	            //    s[i+1] is a multiple of s[i].
	            for (int i = 1; i < n && ok; i++) {
	                if (s[i] % s[i-1] != 0) {
	                    ok = false;
	                }
	            }
	            
	            out.append(ok ? "Yes\n" : "No\n");
	        }
	        
	        System.out.print(out);
	    }
	}
	

//input

//5
//6
//72 24 3 3 3 3
//3 3 3 6 12 144
//3
//1 2 3
//4 5 6
//5
//125 125 125 25 25
//25 25 25 25 75
//4
//123 421 282 251
//125 1981 239 223
//3
//124 521 125
//125 121 121

//output
//YES
//NO
//YES
//NO
//NO
