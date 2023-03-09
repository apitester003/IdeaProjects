package InterviewPreparation;

import java.util.Scanner;

public class ArmstrongNumberCheck {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double total = 0;
		System.out.println("Enter a number: ");
		Scanner sc = new Scanner(System.in);
		String num = sc.next();
		int numLength = num.length();
		String[] numArray = num.split("");
		for(String ch : numArray){
			Integer number = Integer.parseInt(ch);
			total = total + Math.pow(number, numLength);
		}
		
		if(Integer.parseInt(num) == (int)total){
			System.out.println("The number is an armstrong number");
		} else {
			System.out.println("The number is not an armstrong number");
		}
	}

}
