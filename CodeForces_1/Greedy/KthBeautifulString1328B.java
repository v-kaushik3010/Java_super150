package Greedy;
import java.util.*;
public class KthBeautifulString1328B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            int n = sc.nextInt();
            int k = sc.nextInt();

            int pos =1;
            while(k > pos){
                k-=pos;
                pos++;
            }
            int first = n-pos-1;
            int second = n-k;
            for(int i = 0; i < n; i++){
                if(i == first || i == second) System.out.print("b");
                else System.out.print("a");
            }System.out.println();

        }sc.close();

    }
}
