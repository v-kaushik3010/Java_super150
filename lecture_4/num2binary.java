package lecture_4;
import java.util.*;

public class num2binary {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc  = new Scanner(System.in);
		int n = sc.nextInt();
		
		int sum =0;
		int mul= 1;
		while(n>0) {
			int ram = n%2;
			sum= sum + ram*mul;
			n= n/2;
			mul = mul*10;
		}
		System.out.println(sum);
		sc.close();
		

	}

}
