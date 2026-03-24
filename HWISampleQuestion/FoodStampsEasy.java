package HWISampleQuestion;
import java.util.*;

public class FoodStampsEasy {

    public static class Pair{
        long di;
        long taste;
        public Pair(long di, long taste){
            this.di = di;
            this.taste = taste;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long m = sc.nextInt();
        long[] v = new long[n];
        long [] d = new long[n];
        long ans = 0;


        for (int i = 0; i < n; i++) {
            v[i] = sc.nextInt();
        }
        for(int i = 0; i < n ; i++){
            d[i] = sc.nextInt();
        }
        PriorityQueue <Pair> pq = new PriorityQueue<>((a,b) -> Long.compare(b.taste,a.taste));

        for(int i = 0; i < n ; i++){
            pq.add(new Pair(d[i],v[i]));
        }

        while(m-->0 &&!pq.isEmpty()){;
            Pair curr  = pq.poll();
            ans+=curr.taste;
            pq.add(new Pair(curr.di, curr.taste-curr.di));
        }
        System.out.println(ans);
        sc.close();

    }
}
