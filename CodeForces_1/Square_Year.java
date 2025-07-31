package CodeForces_1;
import java.util.*;
public class Square_Year {
     public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
    
            int t = sc.nextInt();  // Number of test cases
            sc.nextLine(); // Consume the remaining newline
    
            while (t-- > 0) {
                String s = sc.nextLine(); // 4-digit year as string
                int year = Integer.parseInt(s); // Convert to integer
    
                boolean found = false;
    
                for (int a = 0; a <= 99; a++) {
                    for (int b = 0; b <= 99; b++) {
                        int sum = a + b;
                        if (sum * sum == year) {
                            System.out.println(a + " " + b);
                            found = true;
                            break;
                        }
                    }
                    if (found) break;
                }
    
                if (!found) {
                    System.out.println("-1");
                }
            }
        }
}
