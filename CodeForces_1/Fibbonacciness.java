package CodeForces_1;

import java.util.*;

public class Fibbonacciness {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); 
        
 
        while (t-- > 0) {
            int a1 = sc.nextInt();
            int a2 = sc.nextInt();
            int a4 = sc.nextInt();
            int a5 = sc.nextInt();
            
            int maxFibo = 0;


            for (int a3 = -100; a3 <= 100; a3++) {
                int count = 0;
 
                if (a3 == a1 + a2) count++;
                if (a4 == a2 + a3) count++;
                if (a5 == a3 + a4) count++;

                maxFibo = Math.max(maxFibo, count);
            }

            System.out.println(maxFibo);
        }

        sc.close();
    }
}
