package question;

import java.util.*;

public class Divisibility_problem_cf {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-- >0) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			if(a%b == 0) {
				System.out.println(0);
			}else {
			
			int move = b - (a%b);
			System.out.println(move);}
		}sc.close();

	}

}
