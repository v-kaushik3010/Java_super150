package CodeForces_1;
import java.util.*;

public class Square_set {

		 public static void main(String[] args) {
		        Scanner sc = new Scanner(System.in);

		        int t = sc.nextInt();  
		        sc.nextLine();

		        while (t-- > 0) {
		            String s = sc.nextLine();
		            int year = Integer.parseInt(s); 
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
		        }sc.close();
		    }

	}


