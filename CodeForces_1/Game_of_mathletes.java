package CodeForces_1;

import java.util.*;

public class Game_of_mathletes {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[] arr = new int[n];
            
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            

            Arrays.sort(arr);
            
            int left = 0;
            int right = n - 1;
            int ans = 0;

            while (left < right) {
                int sum = arr[left] + arr[right];
                
                if (sum == k) {
                    ans++;
                    left++;
                    right--;
                } else if (sum < k) {
                    left++;
                } else {
                    right--;
                }
            }
            

            System.out.println(ans);
        }
        sc.close();
    }
}
