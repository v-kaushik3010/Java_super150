package CodeForces_1;
import java.util.*;

public class The_Cunning_Seller_easy_version {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while (t-- > 0) {
            long n = sc.nextLong();
            System.out.println(solve(n));
        }
        
        sc.close();
    }
    
    static long solve(long n) {
        // Convert n to base 3 representation
        // This gives us the minimum number of deals
        long totalCost = 0;
        int position = 0;
        
        while (n > 0) {
            int digit = (int)(n % 3);
            if (digit > 0) {
                // We need 'digit' deals of type x=position
                long watermelonsPerDeal = pow3(position);
                long costPerDeal = pow3(position + 1) + (long)position * pow3(position - 1);
                totalCost += (long)digit * costPerDeal;
            }
            n /= 3;
            position++;
        }
        
        return totalCost;
    }
    
    static long pow3(int exp) {
        if (exp < 0) return 0;
        long result = 1;
        for (int i = 0; i < exp; i++) {
            result *= 3;
        }
        return result;

	}

}











//Deal with parameter x: Buy 3^x watermelons for 3^(x+1) + x * 3^(x-1) coins
//We want to buy exactly n watermelons with the least number of deals
//Among all solutions with the minimum number of deals, we want the minimum cost
//
//Let me analyze the cost formula:
//
//For x = 0: Buy 3^0 = 1 watermelon for 3^1 + 0 * 3^(-1) = 3 coins
//For x = 1: Buy 3^1 = 3 watermelons for 3^2 + 1 * 3^0 = 9 + 1 = 10 coins
//For x = 2: Buy 3^2 = 9 watermelons for 3^3 + 2 * 3^1 = 27 + 6 = 33 coins
//
//This is essentially a coin change problem where we want to minimize the number of coins (deals) first, then minimize the cost.
//The key insight is that this is similar to representing n in base 3, but we need to be careful about the greedy approach since we want minimum deals first.Watermelon Deals Problem SolutionCode import java.util.*;
//
//public class WatermelonDeals {
//    
//    static class Deal {
//        int x;
//        long watermelons;
//        long cost;
//        
//        Deal(int x) {
//            this.x = x;
//            this.watermelons = pow3(x);
//            thWait, I think I need to reconsider this approach. The problem asks for minimum number of deals first, then minimum cost. Let me think about this differently.
//Since we want the minimum number of deals, this is like representing n in a "greedy base-3" system. But we need to be more careful.Watermelon Deals Problem SolutionCode ∙ Version 2     static long solve(long n, List<Deal> deals) {
//        // Convert n to base 3 representation
//        // This gives us the minimum number of deals
//        List<Integer> base3 = new ArrayList<>();
//        long temp = n;
//        
//        while (temp Watermelon Deals Problem SolutionCode ∙ Version 3 import java.util.*;
//
//public class WatermelonDeals {
//    
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int t = sc.nextInt();
//        
//        while (t-- > 0) {
//            long n = sc.nextLong();
//  The solution works as follows:
//
//Key Insight: To minimize the number of deals, we need to represent n in base 3. This is because:
//
//Deal with x=0: Gives 1 watermelon (3^0)
//Deal with x=1: Gives 3 watermelons (3^1)
//Deal with x=2: Gives 9 watermelons (3^2)
//And so on...
//
//
//Base 3 Representation: Any number can be uniquely represented as a sum of powers of 3 with coefficients 0, 1, or 2. This gives us the minimum number of deals.
//Cost Calculation: For each position i in the base 3 representation:
//
//If the digit is d (where d > 0), we need d deals of type x=i
//Each such deal costs: 3^(i+1) + i * 3^(i-1) coins
//Total cost for position i: d * (3^(i+1) + i * 3^(i-1))
//
//
//Algorithm:
//
//Convert n to base 3
//For each non-zero digit at position i, calculate the cost contribution
//Sum all costs
//
//
//
//Let me verify with the examples:
//
//n=1: Base 3 = [1], Cost = 1 × (3^1 + 0 × 3^(-1)) = 3 ✓
//n=3: Base 3 = [0,1], Cost = 1 × (3^2 + 1 × 3^0) = 10 ✓
//n=8: Base 3 = [2,2], Cost = 2×3 + 2×10 = 26 ✓
//
//Time Complexity: O(log₃ n) per test case
//Space Complexity: O(1)
//The solution efficiently handles large inputs up to 10^9 within the given constraints.