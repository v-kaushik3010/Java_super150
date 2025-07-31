package CodeForces_1;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;


public class tournament {
	  public static void main(String[] args) throws IOException {
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        StringBuilder out = new StringBuilder();
	        
	        int t = Integer.parseInt(br.readLine().trim());
	        while (t-- > 0) {
	            StringTokenizer st = new StringTokenizer(br.readLine());
	            int n = Integer.parseInt(st.nextToken());
	            int j = Integer.parseInt(st.nextToken()) - 1;  // zero‐based index
	            int k = Integer.parseInt(st.nextToken());
	            
	            st = new StringTokenizer(br.readLine());
	            int max = 0, aj = 0;
	            for (int i = 0; i < n; i++) {
	                int v = Integer.parseInt(st.nextToken());
	                if (i == j) {
	                    aj = v;
	                }
	                if (v > max) {
	                    max = v;
	                }
	            }
	            
	            // If we only keep 1 player, j must be strongest to survive.
	            if (k == 1) {
	                out.append(aj == max ? "YES\n" : "NO\n");
	            } 
	            // If we keep 2 or more, j can always avoid elimination by simply
	            // never being drawn into a match (there is always a pair of others).
	            else {
	                out.append("YES\n");
	            }
	        }
	        
	        System.out.print(out);
	    }
	}


