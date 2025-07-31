package Stack;
import java.util.*;
public class CONSTRUCT_A_NUMBER_USING_STACK_LC2375 {

	public static void main(String[] args) {
String str = "IIIDD";
constructNumber(str);

	}
	public static void constructNumber(String s) {
		int [] ans = new int[s.length()+1];
		int count = 1;
		Stack<Integer> st = new Stack<>();
		for(int i =0; i < s.length(); i++) {
			if(i == s.length()||s.charAt(i) == 'I') {
			 ans[i] = count;
				count++;
				while(!st.isEmpty()) {
					ans[st.pop()] = count++;
				}
			}
			else {
				st.push(i);
			}
			}
}
}
