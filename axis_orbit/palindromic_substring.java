package axis_orbit;

public class palindromic_substring {

	public static void main(String[] args) {
		String  s= "nitin";
		System.out.println(countPalindromeSubstring(s));


	}

//	public static int countPalindromeSubstring(String s) {
//
//		//odd count
//		int odd_count = 0;
//		
//		for(int axis = 0; axis < s.length(); axis++) {
//			for(int orbit = 0; axis - orbit >= 0 && axis + orbit < s.length(); orbit++) {
//				if(s.charAt(axis - orbit) == s.charAt(axis + orbit)) {
//					odd_count++;
//				}else {
//					break;
//				}
//			}
//		};
//
//		//even count
//		int even_count = 0;
//		for(double axis = 0.5; axis < s.length(); axis++) {
//			for(double orbit = 0.5; axis - orbit >= 0 && axis + orbit < s.length(); orbit++) {
//				if(s.charAt((int)(axis - orbit)) == s.charAt((int)(axis + orbit))) {
//					even_count++;
//				}else {
//					break;
//				}
//			}
//		}
//		return odd_count + even_count;
//	}

	
	
	
	public static int countPalindromeSubstring(String s) {
		int count = 0;
		
		for(int axis= 0; axis < s.length(); axis++) {
			count+= countsub(s, axis, axis); // odd
			count += countsub(s, axis, axis+1); // even
		}return count;
	}
	
	public static int countsub(String s, int left, int right) {
		
		int count = 0;
		while(left>=0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
			count++;
			left--;
			right++;
		}return count;
		
	}
}
