package Greedy;

import java.util.Scanner;

public class IncreasingbyModulo1168A {
    public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      int n = sc.nextInt();
      int m = sc.nextInt();
      int [] a = new int[n];
      for(int i = 0 ; i < n ; i++) {
        a[i] = sc.nextInt();
      }
      int count = -1;
      boolean sorted = false;
      while(!sorted) {
        sorted = true;
        for(int i = 0; i < n-1; i++){
            if(a[i] > a[i+1]){
                sorted = false;
                a[i] = (a[i] +1)%m;
            }
        }
        count++;
    }
    System.out.println(count);
    sc.close();
}
}