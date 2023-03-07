package InterviewPreparation;

import java.util.Scanner;

public class ReverseStringWithoutStringInbuiltFunctions {
	public static void main(String[] args) {
		String name = "Default";
		System.out.println("Enter a name: ");		
		Scanner sc = new Scanner(System.in);
		if(sc.hasNext()){
			name = sc.next();
		}
		char[] nameArray = name.toCharArray();
		System.out.println(nameArray.length);
		for(int i = (nameArray.length - 1); i >= 0; i--){
			System.out.print(nameArray[i]);
		}
	}	
}
