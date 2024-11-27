package string;

public class Finding_CB_Number {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "81615";
		System.out.println(Lengthwise_subs(s));
		
	}
	
	public static boolean isCBnumber(long num) {
		if (num == 0 || num == 1) {
			return false;
		}
		int[] arr  = { 2,3,5,7,11,13,17,19,23,29};
		for (int i = 0; i < arr.length; i++) {
			if( num == arr[i] ) {
				return true;
			}
		}
		for(int i = 0; i < arr.length; i++) {
			if(num%arr[i]==0) {
				return false;
			}
			
		}return true;
	}
	
	public static int Lengthwise_subs(String str) {
		int c = 0;
		boolean[] visited= new boolean[str.length()];
		for(int len = 1; len <=str.length(); len++ ) {
			for(int j = len; j <= str.length(); j++) {
				int i = j - len;
				long num = Long.parseLong(str.substring(i, j));
				if(isCBnumber(num) && IsVisited(visited, i, j)) {
					c++;
					for(int k = i; k < j; k++) {
						visited[k] = true;
					}
				}
			}
		}return c;
	}
	
	public static boolean IsVisited(boolean[] visited, int i , int j ) {
		for(int k = i; k <j; k++) {
			if(visited[k]==true) {
				return false;
			}
		}return true;
	}

}
