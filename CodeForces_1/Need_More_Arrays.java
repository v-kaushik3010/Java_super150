package CodeForces_1;
import java.util.*;

public class Need_More_Arrays {

	 public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        int t = sc.nextInt();
	        
	        while (t-- > 0) {
	            int n = sc.nextInt();
	            int[] a = new int[n];
	            
	            for (int i = 0; i < n; i++) {
	                a[i] = sc.nextInt();
	            }
	            
	            if (n == 0) {
	                System.out.println(0);
	                continue;
	            }
	            
	            int arrays = 1;
	            int lastKept = a[0];
	            
	            for (int i = 1; i < n; i++) {
	                if (a[i] > lastKept + 1) {
	                    arrays++;
	                    lastKept = a[i];
	                }
	            }
	            
	            System.out.println(arrays);
	        }
	        
	        sc.close();
	    }
}
		
