package CodeForces_1;
import java.util.*;

public class The_Secret_Number {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		   Scanner sc = new Scanner(System.in);
	        int t = sc.nextInt();
	        
	        while (t-- > 0) {
	            long n = sc.nextLong();
	            List<Long> validX = new ArrayList<>();
	            
	            // Try different numbers of zeros k
	            // We need x * (1 + 10^k) = n
	            // So x = n / (1 + 10^k)
	            
	            long power = 10; // 10^k, starting with k=1
	            
	            while (power <= n) {
	                long divisor = 1 + power;
	                
	                if (n % divisor == 0) {
	                    long x = n / divisor;
	                    
	                    // Check if x is valid (positive and has fewer digits than n)
	                    if (x > 0 && countDigits(x) < countDigits(n)) {
	                        validX.add(x);
	                    }
	                }
	                
	                // Avoid overflow
	                if (power > Long.MAX_VALUE / 10) {
	                    break;
	                }
	                power *= 10;
	            }
	            
	            // Sort the results
	            Collections.sort(validX);
	            
	            if (validX.isEmpty()) {
	                System.out.println(0);
	            } else {
	                System.out.println(validX.size());
	                for (int i = 0; i < validX.size(); i++) {
	                    System.out.print(validX.get(i));
	                    if (i < validX.size() - 1) {
	                        System.out.print(" ");
	                    }
	                }
	                System.out.println();
	            }
	        }
	        
	        sc.close();
	    }
	    
	    private static int countDigits(long num) {
	        if (num == 0) return 1;
	        int count = 0;
	        while (num > 0) {
	            count++;
	            num /= 10;
	        }
	        return count;

	}

}




//
//Looking at this problem, I need to find all numbers x such that when we append some zeros to x to get y, we have x + y = n.
//Let me analyze the mathematical relationship:
//
//If x has d digits and we append k zeros, then y = x × 10^k
//So we need: x + x × 10^k = n
//This gives us: x × (1 + 10^k) = n
//Therefore: x = n / (1 + 10^k)
//
//For x to be valid:
//
//x must be a positive integer
//n must be divisible by (1 + 10^k)
//x must have fewer digits than n (since we're appending zeros)
//
//Let me trace through the first example:
//
//n = 1111
//k = 1: x = 1111 / (1 + 10) = 1111 / 11 = 101 ✓
//k = 2: x = 1111 / (1 + 100) = 1111 / 101 = 11 ✓
//Vadim's Number Problem SolutionCode import java.util.*;
//
//public class VadimNumberProblem {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int t = sc.nextInt();
//        
//        while (t-- > 0) {
//            long n = sc.nextLong();
//    The solution works as follows:
//
//Mathematical Analysis:
//
//If we append k zeros to x, we get y = x × 10^k
//The equation becomes: x + x × 10^k = n
//Simplifying: x × (1 + 10^k) = n
//Therefore: x = n / (1 + 10^k)
//
//
//Algorithm:
//
//Try different values of k (number of zeros to append)
//For each k, calculate divisor = 1 + 10^k
//Check if n is divisible by divisor
//If yes, calculate x = n / divisor
//Validate that x is positive and has fewer digits than n
//
//
//Validation:
//
//x > 0: Must be positive
//countDigits(x) < countDigits(n): Ensures we're actually appending zeros, not just adding
//
//
//Edge Cases:
//
//Handle overflow when calculating powers of 10
//Sort results in ascending order
//Output format: count first, then all valid x values
//
//
//
//Time Complexity: O(log n) per test case (limited by the number of possible powers of 10)
//Space Complexity: O(log n) for storing valid results
//The solution correctly handles all example cases:
//
//1111 → finds x = 11, 101
//12 → no valid solutions
//55 → finds x = 5
//Large numbers are handled efficiently within the constraints
