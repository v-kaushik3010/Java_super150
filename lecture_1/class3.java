package lecture_1;
import java.util.*;
public class class3 {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
        int n = sc.nextInt();
        int c = 0;
        
        for(int a = 2;a < n; a++) {
        	if (n% a==0) {
        		System.out.println("not prime number");
        		c++;
        		break;
        	}
        }
        	
        if(c==0) {
        	System.out.print("prime number");
        }
               

		

	}

}
