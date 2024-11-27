package string;

public class String_demo_1 {

	public static void main(String[] args) {

		String s1 = "hello";  //create inside pool
		String s2 = "hello";
		String s3 = new String("hello");  // create outside the pool
		String s4 = new String("hello");
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);
		System.out.println(s4);
		System.out.println(s1 == s2); // same address
		System.out.println(s1 == s3);
		System.out.println(s4 == s3);
		s1 = s1 + "bye";  // first create copy outside pool and add "bye" in it
//		s1 = s1.concat("bye");
		
		String s5 = "hello" + "bye"; //2nd meathod to create inside pool
		String s6 = "hello" + "bye";
		System.out.println(s5 == s6);
	}

}
