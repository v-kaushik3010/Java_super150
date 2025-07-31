package CodeForces_1;
import java.util.*;

public class skibudus_and_rizz {

	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while (t-- > 0) {
            int n = sc.nextInt();  // Number of 0s
            int m = sc.nextInt();  // Number of 1s
            int k = sc.nextInt();  // Required max balance-value
            
            int diff = Math.abs(n - m);
            
            if (diff > k) {
                System.out.println("-1");
                continue;
            }
            
            StringBuilder sb = new StringBuilder();
            
            if (diff == k) {
                // Just append all 0s and then all 1s (or vice versa)
                for (int i = 0; i < n; i++) sb.append('0');
                for (int i = 0; i < m; i++) sb.append('1');
            } else {
                // Interleaving pattern
                int min = Math.min(n, m);
                int max = Math.max(n, m);
                char first = (n >= m) ? '0' : '1';
                char second = (n >= m) ? '1' : '0';

                // Place `min` alternating pairs
                for (int i = 0; i < min; i++) {
                    sb.append(first).append(second);
                }

                // Add remaining `max - min` of the larger character
                for (int i = 0; i < (max - min); i++) {
                    sb.append(first);
                }
            }
            
            System.out.println(sb.toString());
        }
        
        sc.close();
    }
}


	