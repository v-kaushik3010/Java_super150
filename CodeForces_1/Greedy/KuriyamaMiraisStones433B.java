package Greedy;
import java.util.*;
public class KuriyamaMiraisStones433B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);;
        int n = sc.nextInt();
        long [] ui = new long[n];
        for(int i=0;i<n;i++) ui[i] = sc.nextLong();

        long[] uipref = new long[n+1];
        for(int i=1;i<=n;i++) uipref[i] = uipref[i-1]+ui[i-1];

        long[] vi = ui.clone();
        Arrays.sort(vi);
        long[] vipref = new long[n+1];
        for(int i=1;i<=n;i++) vipref[i] = vipref[i-1]+vi[i-1];
        
        
        int m = sc.nextInt();
        while(m-->0){
            int type = sc.nextInt();;
            int l = sc.nextInt();
            int r = sc.nextInt();
            if(type==1) System.out.println(uipref[r] - uipref[l-1]);
            else System.out.println(vipref[r] - vipref[l-1]);
        }
        sc.close();
    }
    
}
