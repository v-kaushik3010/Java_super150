package HASHMAP;
import java.util.*;

public class Set_Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashSet<Integer> set = new HashSet<>();
		set.add(11);
		set.add(29);
		set.add(15);
		set.add(19);
		set.add(10);
		set.add(91);
		System.out.println(set);
//		//contains
//		System.out.println(set.contains(91));
//		System.out.println(set.contains(90));
//		//remove
//		System.out.println(set.remove(91));
	
		//tree set
		Set<Integer> set2 = new TreeSet<>();
		set2.add(11);
		set2.add(29);
		set2.add(15);
		set2.add(19);
		set2.add(10);
		set2.add(91);
		System.out.println(set2);
		
		
		for(int x:set ) {
			System.out.println(x+ " ");
		}System.out.println();
		
		for(int x:set2 ) {
			System.out.println(x+ " ");
		}System.out.println();
		
		for(int x:set3 ) {
			System.out.println(x+ " ");
		}System.out.println();
		
		
		//linkedhash set
		Set<Integer> set3 = new LinkedHashSet<>();
		set3.add(11);
		set3.add(29);
		set3.add(15);
		set3.add(19);
		set3.add(10);
		set3.add(91);
		System.out.println(set);
	}

}
