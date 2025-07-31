package Stack;
import java.util.Stack;

public class stack_java {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack<Integer> st = new Stack<>();

    //maximum size of stack is 10, if we add more than 10 elements then it will increase the size of stack

		System.out.println(st.capacity());  //shows the capacity of stack
		st.push(10);
		st.push(20);
		st.push(30);
		st.push(40);
		st.push(50);
		st.push(70);
		st.push(80);
		st.push(90);
		st.push(1000);
		st.push(100);

		System.out.println(st.peek());  //shows the last_in data
		System.out.println();
		System.out.println(st.size()); //shows the size of stack // we add 11 elements but it will show 10 because the size of stack is 10.
		System.out.println();
		System.out.println(st.pop());  //removes the last_in data
		System.out.println();
		System.out.println(st.peek());
		System.out.println();
		System.out.println(st.capacity()); 


		// add element at the of the stacks without using  another data structure 
		 




	}

}
