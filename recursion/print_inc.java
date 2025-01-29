package recursion;

public class print_inc {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 5;
		inc(n);
		
	}
	public static void inc(int n) {
		
		if (n==0) return;
		
		inc(n-1);
		System.out.println(n);
	}
}
