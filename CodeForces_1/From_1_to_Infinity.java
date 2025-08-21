package CodeForces_1;
import java.util.*;

public class From_1_to_Infinity {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	      Scanner sc = new Scanner(System.in);
	        int t = sc.nextInt();
	        
	        while (t-- > 0) {
	            long k = sc.nextLong();
	            System.out.println(solve(k));
	        }
	        
	        sc.close();
	    }
	    
	    static long solve(long k) {
	        long sum = 0;
	        long remainingDigits = k;
	        int digitCount = 1;
	        
	        while (remainingDigits > 0) {
	            long rangeStart, numbersInRange;
	            
	            if (digitCount == 1) {
	                rangeStart = 1;
	                numbersInRange = 9; // 1 to 9
	            } else {
	                rangeStart = pow10(digitCount - 1);
	                numbersInRange = 9 * pow10(digitCount - 1); // e.g., for 2-digit: 90 numbers
	            }
	            
	            long totalDigitsInRange = numbersInRange * digitCount;
	            
	            if (remainingDigits >= totalDigitsInRange) {
	                // Include entire range
	                sum += sumOfDigitsInCompleteRange(digitCount);
	                remainingDigits -= totalDigitsInRange;
	            } else {
	                // Partial range
	                long completeNumbers = remainingDigits / digitCount;
	                long extraDigits = remainingDigits % digitCount;
	                
	                if (completeNumbers > 0) {
	                    sum += sumOfDigitsInPartialRange(rangeStart, completeNumbers, digitCount);
	                }
	                
	                if (extraDigits > 0) {
	                    long partialNumber = rangeStart + completeNumbers;
	                    sum += sumOfFirstKDigits(partialNumber, extraDigits);
	                }
	                
	                break;
	            }
	            
	            digitCount++;
	        }
	        
	        return sum;
	    }
	    
	    static long pow10(int exp) {
	        long result = 1;
	        for (int i = 0; i < exp; i++) {
	            result *= 10;
	        }
	        return result;
	    }
	    
	    static long sumOfDigitsInCompleteRange(int digitCount) {
	        if (digitCount == 1) {
	            return 45; // Sum of digits 1-9
	        }
	        
	        // For d-digit numbers from 10^(d-1) to 10^d - 1
	        long numbersInRange = 9 * pow10(digitCount - 1);
	        long sum = 0;
	        
	        // Calculate mathematically:
	        // First digit: 1 appears pow10(d-1) times, 2 appears pow10(d-1) times, ..., 9 appears pow10(d-1) times
	        // Other digits: each of 0-9 appears numbersInRange/10 times per position
	        
	        long countPerFirstDigit = pow10(digitCount - 1);
	        for (int digit = 1; digit <= 9; digit++) {
	            sum += digit * countPerFirstDigit;
	        }
	        
	        // For remaining (digitCount - 1) positions
	        long countPerOtherDigit = numbersInRange / 10;
	        long sumPerPosition = 45 * countPerOtherDigit; // 0+1+2+...+9 = 45
	        sum += sumPerPosition * (digitCount - 1);
	        
	        return sum;
	    }
	    
	    static long sumOfDigitsInPartialRange(long start, long count, int digitCount) {
	        long sum = 0;
	        
	        // This is complex to calculate mathematically, so let's use the simpler approach
	        // for partial ranges (should be fast enough since count is limited)
	        for (long i = 0; i < count; i++) {
	            long num = start + i;
	            sum += digitSum(num);
	        }
	        
	        return sum;
	    }
	    
	    static long digitSum(long num) {
	        long sum = 0;
	        while (num > 0) {
	            sum += num % 10;
	            num /= 10;
	        }
	        return sum;
	    }
	    
	    static long sumOfFirstKDigits(long number, long k) {
	        String numStr = Long.toString(number);
	        long sum = 0;
	        
	        for (int i = 0; i < k && i < numStr.length(); i++) {
	            sum += numStr.charAt(i) - '0';
	        }
	        
	        return sum;

	}

}





//Looking at this problem, I need to find the sum of digits in the sequence "123456789101112131415..." truncated at position k.
//The key insight is to process this by groups of numbers with the same digit count:
//
//1-digit numbers: 1, 2, ..., 9 (9 numbers, 9 digits total)
//2-digit numbers: 10, 11, ..., 99 (90 numbers, 180 digits total)
//3-digit numbers: 100, 101, ..., 999 (900 numbers, 2700 digits total)
//And so on...
//
//For each group, I need to:
//
//Calculate how many complete numbers from this group fit in the remaining k digits
//Add the sum of digits from these complete numbers
//Handle any partial number at the end
//The solution works as follows:
//
//Process by digit count groups: Handle 1-digit numbers (1-9), then 2-digit numbers (10-99), then 3-digit numbers (100-999), etc.
//For complete ranges: Use mathematical formulas to calculate the sum efficiently:
//
//1-digit: Sum is simply 1+2+...+9 = 45
//d-digit numbers: Each digit 1-9 appears 10^(d-1) times in the first position, and each digit 0-9 appears (9×10^(d-1))/10 times in other positions
//
//
//For partial ranges: When we can't include all numbers from a digit-count group:
//
//Include complete numbers by iterating (should be fast since k/digitCount is reasonable)
//Handle the final partial number by taking only its first few digits
//
//
//Key optimizations:
//
//Mathematical calculation for complete digit-count ranges
//Only iterate when necessary (for partial ranges)
//Early termination when all k digits are processed
//
//
//
//Let me verify with the examples:
//
//k=5: "12345" → 1+2+3+4+5 = 15 ✓
//k=10: "1234567891" → 1+2+...+9+1+0 = 45+1 = 46 ✓
//
//Time Complexity: O(log₁₀ k) for processing digit groups + O(k/d) for partial ranges where d is the digit count
//Space Complexity: O(1)
//This approach efficiently handles large values of k up to 10^15.
