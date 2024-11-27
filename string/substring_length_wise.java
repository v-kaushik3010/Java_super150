package string;

public class substring_length_wise {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "CodingBlocks";
		Printsubstring(str);
		
	}
	
	public static void Printsubstring(String str) {
		for(int len = 1; len <=str.length(); len++ ) {
			for(int j = len; j <= str.length(); j++) {
				int i = j - len;
				System.out.println(str.substring(i, j));
			}
		}
	}

}
