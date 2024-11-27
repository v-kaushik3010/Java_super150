package lecture_18;

public class String_Builder_Demo {
	//StringBuilder
	//StringBuffer

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder("Hello");
		System.out.println(sb.capacity());
		//
		sb.append("sdgghsdg");
		sb.append(true);
		sb.append(3);
		sb.append("a");
		System.out.println(sb);
		System.out.println(sb.length());
		System.out.println(sb.charAt(2));
		System.out.println(sb.reverse());
		System.out.println(sb.delete(1, 3));
		System.out.println(sb.substring(0, 4));
		String sh = sb.toString();
		
//		String str = "skdhsgdchsaj";
//		sb.append(str);
//		System.out.println(sb);
//		
//		System.out.println();
//		
		//StringBuilder capacity increases by 2*n+2
		
		System.out.println(sb.length());
		System.out.println(sb.capacity());
		

	}

}
