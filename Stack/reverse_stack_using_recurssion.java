package Stack;

import java.util.Stack;

public class reverse_stack_using_recurssion {
   public static void main(String[] args) {

    Stack<Integer> st  = new Stack<>();
		st.push(10);
		st.push(20);
		st.push(30);
		st.push(40);
		st.push(50);

        System.out.println(st);
        reverseStack(st);
        System.out.println(st);
    }

    public static void reverseStack(Stack<Integer> st) {
        if(st.isEmpty()) {
            return;
        }
        int x = st.pop();
        reverseStack(st);
        addElementAtEnd(st, x);
    }




    	public static void addElementAtEnd(Stack<Integer> st, int x) {
		if(st.isEmpty()) {
			st.push(x);
			return;
		}
		int temp = st.pop();
		addElementAtEnd(st, x);
		st.push(temp);
	}

}
