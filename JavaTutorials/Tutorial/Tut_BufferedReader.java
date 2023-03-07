package Tutorial;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Tut_BufferedReader {
    public static void main(String[] args) {
        int a, b, sum;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            System.out.println("Enter a number");
            a = Integer.parseInt(br.readLine());

            System.out.println("Enter the second number");
            b = Integer.parseInt(br.readLine());

            sum = a + b;
            System.out.println("The Sum of two numbers are: " + sum);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
