package lecture_4;
import java.util.*;

public class binary2dec {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int sum =0;
		int mul= 1;
		while(n>0) {
			int ram = n%10;
			sum= sum + ram*mul;
			n= n/10;
			mul = mul*2;                           // src->des   2 se multiply , des se multiply(only if 1 is 10)
		}
		System.out.println(sum);
		sc.close();
		


	}

}
