package Stack;
import java.util.Stack;

public class new_element_at_end_of_stack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack<Integer> st  = new Stack<>();
		st.push(10);
		st.push(20);
		st.push(30);
		st.push(40);
		st.push(50);

System.out.println(st);
addElementAtEnd(st, 60);

System.out.println(st);
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
