package Greedy;

import java.util.Scanner;

public class MixingWater1359C {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {

            long h = sc.nextLong();
            long c = sc.nextLong();
            long t = sc.nextLong();

            if (t >= h) {
                System.out.println(1);
                continue;
            }

            if (2 * t <= h + c) {
                System.out.println(2);
                continue;
            }

            long k = (h - t) / (2 * t - h - c);

            long cups1 = 2 * k + 1;
            long cups2 = 2 * (k + 1) + 1;

            double temp1 = ((k + 1) * h + k * c) / (double) cups1;
            double temp2 = ((k + 2) * h + (k + 1) * c) / (double) cups2;

            double diff1 = Math.abs(temp1 - t);
            double diff2 = Math.abs(temp2 - t);

            if (diff1 <= diff2)
                System.out.println(cups1);
            else
                System.out.println(cups2);
        }

        sc.close();
    }
}
