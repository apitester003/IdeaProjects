package Tutorial;

import java.util.Scanner;

public class Tut_StringMethods {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*System.out.println("Enter a String: ");
		Scanner sc = new Scanner(System.in);
		String name = sc.next();*/
		String name = "Samarendra";
		String name2 = "Pratap";
		
		//1-charAt()
		System.out.println(name.charAt(3));
		
		//2-compareTo() , it compares both the strings lexicographically
		System.out.println(name2.compareTo(name));
		
		//3-concat()
		System.out.println(name.concat(" " + name2));
		
		//4-contains() -- Case sensitive
		System.out.println();
		System.out.println("Contains Demo: ");
		System.out.println(name.contains("amar"));
		System.out.println(name.contains("Amar"));
		
		//5-equals()
		System.out.println();
		System.out.println("Equals Demo: ");
		System.out.println(name.equals("samarendra"));
		System.out.println(name.equals("Samarendra"));
		
		//6-equalsIgnoreCase()
		System.out.println();
		System.out.println("Equals Ignore Case Demo: ");
		System.out.println(name.equalsIgnoreCase("samarendra"));
		System.out.println(name.equalsIgnoreCase("Samarendra"));
		
		//7-indexOf()	--- Prints the first occurence of a character in the string
		System.out.println();
		System.out.println("Index Of Demo: ");
		System.out.println(name.indexOf('r'));
		
		//8-isEmpty()
		System.out.println();
		System.out.println("Is Empty Demo: ");
		System.out.println(name.isEmpty());
		
		//9-lastIndexOf()	--- Prints the last occurence of a character in the string
		System.out.println();
		System.out.println("Last Index Of Demo: ");
		System.out.println(name.lastIndexOf('r'));
		
		//10-length()
		System.out.println();
		System.out.println("String Length Demo: ");
		System.out.println(name.length());
		
		//11-replace
		System.out.println();
		System.out.println("String Replace Demo: ");
		System.out.println(name.replace("amar", " "));
		
		//12-split()	--- String explode demo
		System.out.println();
		System.out.println("String Split Demo: ");
		String fullName = "Samarendra Pratap Sahoo";
		String[] fullNameArray = fullName.split(" ");
		for(String val : fullNameArray){
			System.out.println(val);
		}
		
		//13-startsWith()	--- Case Sensitive
		System.out.println();
		System.out.println("Starts With Demo: ");
		System.out.println(name.startsWith("Sam"));
		System.out.println(name.startsWith("sam"));
		
		//14-substring		--- prints the sub string between startindex and one less than the last index.
		System.out.println();
		System.out.println("Substring Demo: ");
		System.out.println(name.substring(1, 4));
		
		//15-toCharArray()	--- String to character array
		System.out.println();
		System.out.println("Char Array Demo: ");
		char[] charsOfName = name.toCharArray();
		for(char val : charsOfName){
			System.out.println(val);
		}
		
		//16-toLowerCase()
		System.out.println();
		System.out.println("To Lower Case Demo: ");
		System.out.println(name.toLowerCase());
		
		//16-toUpperCase
		System.out.println();
		System.out.println("To Upper Case Demo: ");
		System.out.println(name.toUpperCase());
		
		//17-trim()	---Removes white spaces from both ends of the string
		System.out.println();
		System.out.println("Trim Demo: ");
		System.out.println(name.trim());
		
		//18-toString()
		System.out.println();
		System.out.println("To String Demo: ");
		Integer randomNumber = 123;
		String randomNumberAsString = randomNumber.toString();
		System.out.println(randomNumberAsString);
	}

}
