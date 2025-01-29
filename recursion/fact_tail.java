package recursion;

public class fact_tail {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 5;
		System.out.println(fac(n, 1));
		
	}
	
//	public static int fac(int n) {
//		
//		//base case
//		if(n == 0) return 1;
//
//		
//		return fac(n-1)*n;      // head recurssion phle fact(n-1) hoga tb multiply hoga
//
//	}

	
	//tails recussion
	public static int fac(int n, int ans) {
		
		//base case
		if(n == 0) return ans;

		
		return fac(n-1, ans*n);      

	}

}
