package Bit_Masking;

public class Subsequence_Without_Recurssion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "abc";
		Subsequence(s);
	}
	public static void Subsequence(String s) {
		int n = s.length();
		for(int i = 0; i < (1<<n); i++) {
			Pattern(s,i);
		}
	}
	public static void Pattern(String s , int i) {
		int idx = 0;
		String ans  = "";
		while(i>0) {
			if((i&1)==1) {
				ans = ans + s.charAt(idx);
			}i>>=1;
		idx++;
		}
	}

}
