package question;
import java.util.*;

public class tales_of_a_sort_cf {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		  Scanner sc = new Scanner(System.in);
	        int t = sc.nextInt();  // Number of test cases
	        
	        while (t-- > 0) {
	            int n = sc.nextInt();  // Length of the array
	            int[] a = new int[n];
	            
	            for (int i = 0; i < n; i++) {
	                a[i] = sc.nextInt();
	            }
	            
	            System.out.println(countOperations(a, n));
	        }
	        
	        sc.close();
	    }
	    
	    private static int countOperations(int[] a, int n) {
	        // Step 1: Find the last index where array is not in sorted order
	        int lastUnsorted = -1;
	        
	        for (int i = n - 1; i > 0; i--) {
	            if (a[i] < a[i - 1]) {
	                lastUnsorted = i - 1;
	                break;
	            }
	        }
	       	        
	        int max = 0;
	        for(int j = 0; j <= lastUnsorted; j++) {
	        	max= Math.max(max, a[j]);
	        }return max;

	}

}
