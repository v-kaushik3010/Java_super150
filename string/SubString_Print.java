package string;

public class SubString_Print {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String s = "hello";
		PrintSubString(s);
		
	}
	
	public static void PrintSubString(String s) {
		for(int j = 0; j< s.length(); j++) {
			String str = "";
		for(int i = j; i < s.length(); i++) {
			str = str + s.charAt(i);
			System.out.println(str);					
		}
		}
	}

}
