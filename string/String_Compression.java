package string;

public class String_Compression {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String s1 = "kunal";
		String s2 = "komal";
		
		System.out.println(s1.compareTo(s2)); // 6 = Ascii(u)-Ascii(o)
		
		String s3 = "ankit";
		String s4 = "ankita";
		
		//System.out.println(s3.compareTo(s4));// length of s3 - length of s4 (if one string is substring)
		
		System.out.println(CompareTo(s3,s4));
		
	}
	public static int CompareTo(String s1, String s2) {
		if (s1 ==s2) {
			return 0;
		}
		int n = Math.min(s1.length(), s2.length());
		for(int i =0; i <n ; i++) {
			if (s1.charAt(i) != s1.charAt(i)) {
				return s1.charAt(i)-s2.charAt(i);
			}
		}return 0;
		
	}

}
