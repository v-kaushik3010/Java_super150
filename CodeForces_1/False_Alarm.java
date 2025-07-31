package CodeForces_1;

import java.util.*;

public class False_Alarm {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();  
        while (t-- > 0) {
            int n = sc.nextInt();
            int x = sc.nextInt();
            int[] arr = new int[n];

            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

            System.out.println(check(arr, x));
        }sc.close();
    }

    public static String check(int[] arr, int x) {
        int first = -1, last = -1;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                if (first == -1) first = i;
                last = i;
            }
        }

        int timeNeeded = last - first + 1;

        return timeNeeded <= x ? "YES" : "NO";
    }
}
