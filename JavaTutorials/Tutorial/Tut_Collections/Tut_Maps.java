package Tutorial.Tut_Collections;

import java.util.*;

public class Tut_Maps {

	public static void main(String[] args) {
		Map<Integer, String> hashMap = new HashMap<>(); //Best Performance, Random storage of values
		Map<String, Integer> linkedHashMap = new LinkedHashMap<>();	//Faster than Treeset, Insertion order maintained
		Map<Integer, String> treeMap = new TreeMap<>();	//Slowest Performance, Values stored in ASC/DESC order
		
		//insert
		hashMap.put(0, "Samarendra");
		hashMap.put(1, "Pratap");
		hashMap.put(2, "Sahoo");
		System.out.println(hashMap);
		
		//update
		hashMap.put(1, "P");
		System.out.println(hashMap);
		
		
		linkedHashMap.put("Sam", 0);
		System.out.println(linkedHashMap);
		
		//retrieve
		for(Map.Entry<Integer, String> values : hashMap.entrySet()){
			System.out.printf("%d: %s", values.getKey(), values.getValue());
			System.out.println();
		}
	}

}
