package InterviewPreparation;

import java.util.Scanner;

public class PalindromeCheck {
    public static void main(String[] args) {
        System.out.println("Enter a number or a string: ");
        Scanner sc = new Scanner(System.in);
        String name = sc.next();
        StringBuffer sb = new StringBuffer(name);
        String reverseName = sb.reverse().toString();
        if(name.equals(reverseName)){
            System.out.println("The name is a palindrome");
        } else {
            System.out.println("The name is not a palindrome");
        }
    }
}
