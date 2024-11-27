package list;

import java.util.ArrayList;
import java.util.Collections;

public class ArrayList_Demo2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> li = new ArrayList<>();
		li.add(10);
		li.add(20);
		li.add(30);
		li.add(7);
		li.add(9);
		System.out.println(li);
		Collections.sort(li);
		Collections.reverse(li);
		for(int i = 0; i < li.size(); i++) {
			System.out.println(li.get(i)+" ");
		}
		System.out.println();
		int[] arr = new int [5];
		for(int v:li) {
			System.out.print(v + " ");
		}
		System.out.println();
		
		for(int v:arr) {
			System.out.print(v + " ");
		}
		
	}

}
