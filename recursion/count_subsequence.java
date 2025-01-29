package recursion;

public class count_subsequence {

		public static void main(String[] args) {
			// TODO Auto-generated method stub
			String str = "abc";
//			print(str, "");
			
			System.out.print(count_sub(str,""));
			
			
			// System.out.println("\n"+count);
			
		}
//		static int count =0;
		
		
		public static int count_sub(String ques, String ans) {
			if(ques.length() ==0 ) {
				System.out.println(ans + " ");
				return 1;
			}
			char ch= ques.charAt(0);
			int a = count_sub(ques.substring(1), ans);
			int b = count_sub(ques.substring(1), ans + ch);
			return a+b;
			
		}
		
		
//		public static void print(String ques, String ans) {
//			if(ques.length() ==0 ) {
//				System.out.println(ans + " ");
//				return;
//			}
//			char ch= ques.charAt(0);
//			print(ques.substring(1), ans);
//			print(ques.substring(1), ans + ch);
//		}

}
