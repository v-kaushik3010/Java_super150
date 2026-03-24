package Greedy;
import java.util.*;
public class TeamsForming1092B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for(int i=0;i<n;i++) a[i] = sc.nextInt();
        int ans = 0;
        Arrays.sort(a);
        for(int i = 0; i < n-1; i+=2){
            ans+=a[i+1]-a[i];
        }
        System.out.println(ans);
    sc.close();
    }
}
