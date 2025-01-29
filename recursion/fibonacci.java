package recursion;

public class fibonacci {

	public static void main(String[] args) {
		
		int n = 6;
		System.out.println(fib(n));
		
	}
	
	public static int fib(int n) {
		if(n==0 || n ==1) return n;
		
		int i1 = fib(n-1);
		int i2 = fib(n-2);
		return i1 + i2;
	}
	}
