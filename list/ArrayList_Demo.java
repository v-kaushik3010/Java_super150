package list;

import java.util.*;
public final class ArrayList_Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> li = new ArrayList<>();
		li.add(10);
		li.add(20);
		li.add(30);
		System.out.println(li);
		li.add(1, 9);
		System.out.println(li);
		System.out.println(li.get(2));
		System.out.println(li.remove(2));  //print the number to be removed
		System.out.println(li);
		System.out.println(li.size());
		
	}

}
