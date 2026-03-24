package Bit_Masking;
import java.util.*;

public class Preparing_Olympiad {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int l = sc.nextInt();
		int r = sc.nextInt();
		int x = sc.nextInt();
		int[] c = new int[n];
		for(int i = 0; i <c.length; i++) {
			c[i] = sc.nextInt();
		}

	}
	public static int Number_Way(int[] c, int l, int r, int x) {
		int n = c.length;
		for(int i = 3; i < (1 <<n); i++) {
			if(Fast_Count_SetBit(i)>=2) {
				
				
			}
		}
	}
	
	public static int Fast_Count_SetBit(int n) {
		int ans = 0;
		while (n > 0) {
			ans++;
			n = n & (n - 1);
		}
		return ans;
	}
	
	public static boolean isitpossible(int[] c, int l, int r, int x, int i) {
		int sum = 0, min = Integer.MAX_VALUE,max = Integer.MIN_VALUE, idx = 0;
		while(i > 0) {
			if((i&1) ==1) {
				sum += c[idx];
				min = Math.min(min, c[i]);
				max = Math.max(max, c[i]);
				
			}
			i>>= 1;
			idx++;
		}return sum>=l & sum <= r & max-min >=x;
	}

}
