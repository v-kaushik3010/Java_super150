package recursion;

//stop duplicate

public class permutation2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String ques = "abca";
		print(ques, "");

	}
	
	
	public static void print(String ques, String ans) {
		if (ques.length() == 0 ) {
			System.out.println(ans);
			return;
		}
		
		for(int i = 0; i < ques.length(); i++) {
			
			char ch =  ques.charAt(i);
			if(!is_valid(ques,i+1, ch)) {
			String s1 = ques.substring(0, i);
			String s2 = ques.substring(i+1);
			print(s1+s2, ans+ch);}
			}
		}
		

	public static boolean is_valid(String str, int i, char ch) {
		
		for(int j = i; j< str.length(); j++) {
			if(str.charAt(j) == ch) return true; //mil gya toh true
			
		}return false;
		
	}

	

}
