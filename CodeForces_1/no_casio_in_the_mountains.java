package CodeForces_1;
import java.io.*;
import java.util.*;

public class no_casio_in_the_mountains {
	    public static void main(String[] args) throws IOException {
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        StringTokenizer st = new StringTokenizer(br.readLine());
	        int t = Integer.parseInt(st.nextToken());
	        StringBuilder sb = new StringBuilder();

	        while (t-- > 0) {
	            st = new StringTokenizer(br.readLine());
	            int n = Integer.parseInt(st.nextToken());
	            int k = Integer.parseInt(st.nextToken());

	            st = new StringTokenizer(br.readLine());
	            // Build prefix sum of rainy days
	            int[] prefix = new int[n + 1];
	            for (int i = 1; i <= n; i++) {
	                prefix[i] = prefix[i - 1] + Integer.parseInt(st.nextToken());
	            }

	            int ans = 0;
	            int i = 0;
	            // Greedily schedule hikes
	            while (i <= n - k) {
	                // If the window [i, i+k-1] has no rain
	                if (prefix[i + k] - prefix[i] == 0) {
	                    ans++;
	                    // Skip the k days plus one rest day
	                    i += k + 1;
	                } else {
	                    i++;
	                }
	            }

	            sb.append(ans).append('\n');
	        }

	        System.out.print(sb);
	    }
	}


