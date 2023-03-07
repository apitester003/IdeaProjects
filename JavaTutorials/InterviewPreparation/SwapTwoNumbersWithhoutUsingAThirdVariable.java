package InterviewPreparation;

import java.util.Scanner;

public class SwapTwoNumbersWithhoutUsingAThirdVariable {
    public static void main(String[] args) {
        System.out.println("Enter 2 nos: ");
        Scanner sc_x = new Scanner(System.in);
        int x = sc_x.nextInt();
        Scanner sc_y = new Scanner(System.in);
        int y = sc_y.nextInt();

        y = x + y;
        x = y - x;
        y = y - x;

        System.out.println("The reversed numbers are: " + x + " and " + y);
    }
}
