package recursion;

public class fact {

	public static void main(String[] args) {

		int n = 5;
		System.out.println(fac(n));
		
	}
	
	public static int fac(int n) {
		
		//base case
		if(n == 0) return 1;
		
		//isse phle ka lake de recurssion
		int fn = fac(n-1);
		return fn*n;
	}

}
