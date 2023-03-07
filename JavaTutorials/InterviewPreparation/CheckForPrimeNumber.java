package InterviewPreparation;

import java.util.Scanner;

public class CheckForPrimeNumber {
    public static void main(String[] args) {
        System.out.println("Enter a number: ");
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int notPrimeFlag = 0;
        for(int count = 2; count <= num/2; count++){
            if(num%count == 0){
                notPrimeFlag = 1;
                break;
            }
        }
        if(notPrimeFlag == 0){
            System.out.println("The Number is Prime");
        } else {
            System.out.println("The number is not prime");
        }
    }
}
