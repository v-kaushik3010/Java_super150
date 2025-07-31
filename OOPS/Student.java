package OOPS;

public class Student {
	 String name;
	 int age;
	
	 public void Intro_yourSelf() {
		 System.out.println("My name is "+ name + " and age is " + age);
	 }
	 
	 public void say_hi(String name) {
		 System.out.println(this.name + " say Hi " + name);
	 }
}
