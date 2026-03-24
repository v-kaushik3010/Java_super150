package CodeForces_1;

import java.util.Scanner;

public class VasilijeInCacak {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0) {
			long n = sc.nextLong();
			long k = sc.nextLong();
			long x = sc.nextLong();

            long minSum = k * (k + 1) / 2;
            long maxSum = k * (2*n - k + 1) / 2;
			
//			long minposs = 0;
//			long maxpos = 0;
			
//			for(long i = 1; i <= k; i++) {
//				minposs += i;
//			}
			//System.out.println("min " + minposs);
//			for(long i = n; i>n-k; i--) {
//				maxpos+=i;
//			}
			//System.out.println("max " + maxpos);
			if(x>=minSum && x<=maxSum) System.out.println("Yes");
			else System.out.println("No");
		}
		

	}

}
