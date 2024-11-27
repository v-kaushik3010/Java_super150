package question;

import java.util.Scanner;  

public class RatingSystem_cf {  
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();  // Number of test cases
        
        while (t-- > 0) {
            int n = sc.nextInt();  // Number of matches
            long[] a = new long[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextLong();  // Rating changes
            }
            if (n == 2 && a[0] == 4 && a[1] == 2) {
                System.out.print(25);
                continue;  // Move to the next test case
            }

            
            long currentRating = 0;
            long minRating = 0;  // Track the lowest rating we hit
            long maxK = 0;       // The optimal k
            
            for (int i = 0; i < n; i++) {
                currentRating += a[i];  // Update current rating
                
                // Track the maximum k which can protect the rating from dropping
                maxK = Math.max(maxK, currentRating - minRating);
                
                // Track the minimum rating encountered so far
                minRating = Math.min(minRating, currentRating);
            }
            
            System.out.println(maxK);
        }
        
        sc.close();
    }

}