package Assignment_recurssion;

import java.util.Scanner;

public class viveks_game {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for (int t = 0; t < T; t++) {
            int N = sc.nextInt();
            int[] arr = new int[N];
            for (int i = 0; i < N; i++) {
                arr[i] = sc.nextInt();
            }
            System.out.println(game(arr, 0, N - 1));
        }

        sc.close();
    }

    public static int game(int[] arr, int start, int end) {
        if (start >= end) return 0;

        int count = 0;
        int sum1 = 0;
        int sum2 = 0;

        for(int mid = start; mid<end; mid++){

            for(int i = start; i <= mid; i++){
                sum1 += arr[i];
            }

            
            for(int j = mid; j < end; j++){
                sum1 += arr[j];
            }

            if (sum1 == sum2){
                count++;
                game(arr, mid, end);
            }
        }return count;
    }   

}
