package Wrapper_Class;

//Primitive Class     -   Wrapper Class
//boolean                  Boolean
//byte                     Byte
//char                     Character
//float                    Float
//int                      Integer
//long                     Long
//short                    Short
//double                   Double




public class Wrapper_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int a = 10;
		Integer a1 = 10;
		System.out.println(a1);
		System.out.println(a);
		
//		Long l = 10l;
//		Character ch = 'a';
//		Boolean c= true; 
		Integer b = a;
		
		int x= a1;
		Integer c1 = 18;
		Integer c2 = 18;
		Integer c3 = 181;
		Integer c4 = 181;
		System.out.println(c1==c2);
		System.out.println(c3==c4);
		
		Boolean b1 = false;
		Boolean b2 = false;
		System.out.println(b1==b2);
		
		Character x1 = 'z';
		Character x2 = 'z';
		System.out.println(x1 == x2);
//		Byte/Short/Integer/Long -  stored in Cache Memory |Size - 256 i.e. -128 to 127; always have same address; 

	}

}
