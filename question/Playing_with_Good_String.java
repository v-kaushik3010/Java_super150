package question;

public class Playing_with_Good_String {

	public static void main(String[] args) {
	
		String S = "cbaeicde";
		System.out.println(Good_String(S));
		
	}
	
	public static int Good_String(String S) {
		int ans = 0;
		int c = 0;
		for (int i = 0; i < S.length(); i++ ) {
			char ch = S.charAt(i);
			if(isvowels(ch)) {
				c++;
			}else {
				ans = Math.max(ans,c);
				c = 0;
				
			}
		}ans = Math.max(ans, c);
		return ans;
	}
	
	public static boolean isvowels(char ch) {
		if (ch =='a'||ch =='e'||ch =='i'||ch =='o'||ch =='u') {
			return true;
		}else {		
			return false;
	}

}
}