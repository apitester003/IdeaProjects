package Tutorial.Tut_Collections;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class Tut_Sets {

	public static void main(String[] args) {
		Set<String> hashSet = new HashSet<String>();	//Best Performance, Random storage of values, unique and non-duplicate values
		Set<String> linkedHashSet = new LinkedHashSet<String>();	//Faster than Treeset, Insertion order maintained, unique and non-duplicate values
		Set<String> treeSet = new TreeSet<String>();	//Slowest Performance, Values stored in ASC/DESC order, unique and non-duplicate values
		
		//Add Values
		hashSet.add("Samarendra");
		hashSet.add("Pratap");
		hashSet.add("Sahoo");
		
		System.out.println(hashSet);
		
		//Length of the set
		System.out.println(hashSet.size());
				
		linkedHashSet.add("Aparajita");
		linkedHashSet.add("Sahoo");
		
		//Set Type Conversion and assignment to another set
		Set<String> unionSet = new HashSet<String>(linkedHashSet);
		
		//Union of two sets
		unionSet.addAll(hashSet);
		System.out.println(unionSet);
		
		//Intersection
		Set<String> intersectionSet = new HashSet<String>(hashSet);
		intersectionSet.retainAll(unionSet);
		System.out.println(intersectionSet);
		
		//Difference
		intersectionSet.removeAll(linkedHashSet);
		System.out.println(intersectionSet);
	}

}
