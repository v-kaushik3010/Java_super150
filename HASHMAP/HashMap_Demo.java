package HASHMAP;
import java.util.*;

//contantant time for basic functions : O(1)
// doesn't preserve order


public class HashMap_Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<String, Integer> map = new HashMap<>();
		
		//add
		map.put("Raj", 77);
		map.put("Kunal",90);
		map.put("Kunal",70);  // same key : override
		map.put("pcr", 90);
		map.put("pooja", 32);
		map.put(null, 32);
		System.out.println(map);
//		//get
//		System.out.println(map.get("Raj"));
//		System.out.println(map.get("pcr"));
//		
//		//Containskey
//		System.out.println(map.containsKey("raj"));
//		System.out.println(map.containsKey("Raj"));
//		
//		//remove
//		System.out.println(map.remove("raj")); // key not available : O/P null
//		System.out.println(map.remove("Raj"));
//		
		
		//2.Tree map
		
		//time complexity O( Nlog N)
		//order by key
		
		TreeMap<String, Integer> map2 = new TreeMap<>();
//		Map<String, Integer> map2 = new TreeMap<>();
		
		map2.put("Raj", 77);
		map2.put("Kunal",90);
		map2.put("Kunal",70);  // same key : override
		map2.put("pcr", 90);
		map2.put("pooja", 32);
//		map2.put(null, 32);                         as tree map use comparator to sort so null cannot be the key
		System.out.println(map2);
		
	
		
		//3.LinkedHashMap
		//same order as data is input
		
		LinkedHashMap<String, Integer> map3 = new LinkedHashMap<>();
//      Map<String, Integer> map3 = new LinkedHashMap<>();
		map3.put("Raj", 77);
		map3.put("Kunal",90);
		map3.put("Kunal",70);  // same key : override
		map3.put("pcr", 90);
		map3.put("pooja", 32);
//		map2.put(null, 32);                         as tree map use comparator to sort so null cannot be the key
		System.out.println(map3);
		
		
//		Set<String> key = map.keySet();
//		for(String k : key) {
//			System.out.println(k + " " + map.get(k));
//		}
		
		
	}

}
