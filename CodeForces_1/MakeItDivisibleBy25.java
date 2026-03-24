package CodeForces_1;

import java.util.*;

public class MakeItDivisibleBy25 {
	public static int solve(String s, char a, char b) {
		int n = s.length();
		int posA = -1, posB =-1;
		for(int i = n-1; i >=0; i--) {
			if(posB ==-1&& s.charAt(i) == b) {
				posB = i;
			}else if(posB != -1 && s.charAt(i) == a) {
				posA = i;
				return (n-posA -2);
			}
		}return Integer.MAX_VALUE;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0) {
		String n = sc.next();
		int ans = Math.min(Math.min(solve(n, '0', '0'), solve(n,'2', '5')), Math.min(solve(n, '5', '0'), solve(n, '7', '5')));
		System.out.println(ans);
		}sc.close();
	}

}
