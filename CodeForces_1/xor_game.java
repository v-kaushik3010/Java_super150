package CodeForces_1;
import java.util.*;

public class xor_game {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];
            int[] b = new int[n];

            for (int i = 0; i < n; i++) a[i] = sc.nextInt();
            for (int i = 0; i < n; i++) b[i] = sc.nextInt();

            int xorA = 0, xorB = 0;

            for (int i = 0; i < n; i++) {
                xorA ^= a[i];
                xorB ^= b[i];
            }

            if (xorA > xorB)
                System.out.println("Ajisai");
            else if (xorA < xorB)
                System.out.println("Mai");
            else
                System.out.println("Tie");
        }
    }
}


