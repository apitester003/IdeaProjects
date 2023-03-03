import java.util.*;

public class Tut_ArrayMethods {

	public static void main(String[] args) {
		//1 - Convert arrays to list
		String[] nameArr = {"Samarendra","Pratap","Sahoo"};
		List<String> nameList = Arrays.asList(nameArr);
		
		for (String name : nameList) {
			System.out.println(name);
		}
		
		//2 - fill all the elements in the array with same value
		int[] arrayOfNumbers = new int[5];
		Arrays.fill(arrayOfNumbers, 1000);
		
		for (int i : arrayOfNumbers) {
			System.out.println(i);
		}
		
		//3 - Duplicate an existing array
		int[] arr1 = new int[5];
		int[] arr2 = Arrays.copyOf(arr1, arr1.length);
		
		//4 - check if two arrays have same contents
		Boolean flag = Arrays.equals(arr1, arr2);
		System.out.println(flag);
		
		//5 - Sort the array
		Arrays.sort(nameArr);
		for (String string : nameArr) {
			System.out.println(string);
		}
		
		//6 - Searching in an array
		int[] arr = {8, 10, 12, 14, 19, 22};
		System.out.println(Arrays.binarySearch(arr, 19));	//binary search returns the index of an element in a sorted array
	}

}
