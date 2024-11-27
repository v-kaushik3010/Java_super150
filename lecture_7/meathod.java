package lecture_7;

public class meathod {
	static int val = 100;

	public static void main(String[] args)
	{
		
		System.out.println("Hello");
		int a =8;
		int b= 7;
		System.out.println(Add(a,b));
		System.out.println(val);
		System.out.println("bye");
		
	}
	
	public static int Add(int a, int b) {
		int c = a+b;
		int val = 90;
		meathod.val = meathod.val -5;   // access global while local is still available
		return c + sub(c,a);
		
	}
	public static int sub(int a, int b) {
		return a-b;
	}

}
