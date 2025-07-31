package OOPS;
//import Student;  //no need to import as same package

public class student_client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student s = new Student();
		System.out.println(s.name);
		System.out.println(s.age);
		s.Intro_yourSelf(); 
		
		s.name = "kaju";
		s.age = 18;
		s.Intro_yourSelf(); 
		

		Student s1 = new Student();
		s1.name = "kamlesh";
		s1.age = 20;
		
		s1.say_hi("ramesh");
		
	}

}
 