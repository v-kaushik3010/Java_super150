package recursion;

public class Board_path {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 4;
		path(n, 0, "");
	}
	
	public static void path(int n, int curr, String ans) {
		if(curr == n) {
			System.out.println(ans);
			return;
		}
		if(curr > n) return;
		
		for( int dice  =1; dice <= 3; dice++) {
			path(n, curr+dice, ans+dice);
		}
		
//		path(n, curr+1, ans+1);
//		path(n, curr+2, ans+2);
//		path(n, curr+3, ans+3);
	}

}
