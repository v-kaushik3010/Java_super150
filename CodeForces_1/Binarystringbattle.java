package CodeForces_1;
import java.util.*;

public class Binarystringbattle {

	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        int t = sc.nextInt();
	        
	        while (t-- > 0) {
	            int n = sc.nextInt();
	            int k = sc.nextInt();
	            String s = sc.next();
	            
	            System.out.println(winner(n, k, s));
	        }
	    }
	    
	    static String winner(int n, int k, String s) {
	        // Collect positions of all the '1's
	        List<Integer> ones = new ArrayList<>();
	        for (int i = 0; i < n; i++) {
	            if (s.charAt(i) == '1') {
	                ones.add(i);
	            }
	        }
	        
	        int m = ones.size();
	        
	        // 1) Alice can clear all 1's in her first move?
	        if (m <= k) {
	            return "Alice";
	        }
	        
	        // 2) Check for any window of k consecutive 1's fitting in length k
	        //    If so, Bob can always reestablish them as a contiguous block.
	        for (int i = 0; i + k - 1 < m; i++) {
	            int left  = ones.get(i);
	            int right = ones.get(i + k - 1);
	            if (right - left + 1 <= k) {
	                return "Bob";
	            }
	        }
	        
	        // 3) Otherwise Alice’s ability to pick ANY k positions
	        //    eventually eradicates all 1's.
	        return "Alice";
	    }
	}

		
