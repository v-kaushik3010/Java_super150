package recursion;

public class generate_parenthesis {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 3; 
		parenthesis(n, 0, 0,"");
		

	}
	public static void parenthesis(int n , int closed, int open, String ans) {
		
		if(open == n && closed ==n) {
			System.out.print(ans+ " ");
			return;
			}
		
		if(open > n || closed > open) return; 
		
		
		parenthesis(n, closed, open+1, ans+"(");
		parenthesis(n, closed +1, open, ans+")");
	}

}
