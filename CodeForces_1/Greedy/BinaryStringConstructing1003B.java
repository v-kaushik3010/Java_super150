package Greedy;
import java.util.*;

public class BinaryStringConstructing1003B {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();
        int x = sc.nextInt();

        StringBuilder sb = new StringBuilder();

        char first = (a > b) ? '0' : '1';
        char second = (first == '0') ? '1' : '0';

        for(int i = 0; i <= x; i++){
            if(i % 2 == 0){
                sb.append(first);
                if(first == '0') a--;
                else b--;
            } else {
                sb.append(second);
                if(second == '0') a--;
                else b--;
            }
        }

        if(first == '0'){
            while(b-- > 0) sb.insert(1,'1');
            while(a-- > 0) sb.insert(0,'0');
        } else {
            while(a-- > 0) sb.insert(1,'0');
            while(b-- > 0) sb.insert(0,'1');
        }

        System.out.println(sb);
        sc.close();
    }
}
