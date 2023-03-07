package InterviewPreparation;

import java.util.Scanner;

public class SwapTwoNumbersUsingAThirdVariable {
    public static void main(String[] args) {
        System.out.println("Enter two numbers: ");
        Scanner sc_x = new Scanner(System.in);
        Scanner sc_y = new Scanner(System.in);
        int x = sc_x.nextInt();
        int y = sc_y.nextInt();
        int z = y;
        y = x;
        x = z;
        System.out.println("The new swapped numbers are: " + x + " and " + y);
    }
}
