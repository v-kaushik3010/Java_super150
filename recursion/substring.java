package recursion;

public class substring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "abc";
		print(str, "");
	}
	public static void print(String ques, String ans) {
		if(ques.length() ==0 ) {
			System.out.println(ans + " ");
			return;
		}
		char ch= ques.charAt(0);
		print(ques.substring(1), ans);
		print(ques.substring(1), ans + ch);
	}

}
