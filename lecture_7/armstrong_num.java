package lecture_7;
import java.util.*;

public class armstrong_num {

	
		    public static void main(String args[]) {
				Scanner sc = new Scanner(System.in);
				int n = sc.nextInt();
				sc.close();
				
				System.out.println(armstrong(n));

		    }

			public static int count(int n){
				int c = 0;
				while( n > 0){
					n= n/10;
					c++;
				}
				return c;
			}
			public static boolean armstrong(int n){
				int original = n;
				int cod= count(n);
				int sum  = 0;
				while (n>0){
					int rem = n%10;
					sum = (int)(sum + Math.pow(rem, cod));
					n = n/10;
					}
					return sum == original;

			}
		}
	


