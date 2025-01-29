package recursion;

public class print_dec {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 5;
		dec(n);
		
	}
	public static void dec(int n) {
		System.out.println(n);
		if(n==0) return;
		
		dec(n-1);
		
	}

}
