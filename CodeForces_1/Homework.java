package CodeForces_1;

import java.util.*;

public class Homework {

	public static void main(String[] args) {

	    Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while (t-- > 0) {
            int n = sc.nextInt();
            String a = sc.next();
            int m = sc.nextInt();
            String b = sc.next();
            String c = sc.next();
         
            StringBuilder result = new StringBuilder(a);
            
            for(int i = 0; i < m; i++) {
            	char curchar = b.charAt(i);
            	char player = c.charAt(i);
            	
            	if(player == 'V') result.insert(0,  curchar);
            	else result.append(curchar);
         
        }System.out.println(result.toString());
	}sc.close();

}
}
