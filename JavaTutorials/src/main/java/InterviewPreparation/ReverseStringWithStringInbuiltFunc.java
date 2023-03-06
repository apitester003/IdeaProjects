package InterviewPreparation;

import java.util.Scanner;

public class ReverseStringWithStringInbuiltFunc {

	public static void main(String[] args) {
		String name = "Default";
		System.out.println("Enter a Name: ");
		Scanner sc = new Scanner(System.in);
		if(sc.hasNext()){
			name = sc.next();
		}
		
		StringBuffer sb = new StringBuffer(name);
		System.out.println("Reversed String: " + sb.reverse());
	}

}
