package Tutorial;

import java.util.Scanner;

interface Event{
    String message = "An event has been triggered";
    void printMessage();
}

public class Tut_Innerclasses {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int number = sc.nextInt();
        if(number == 1){
            Event event = new Event() {
                @Override
                public void printMessage() {
                    System.out.println(message);
                }
            };
            event.printMessage();
        }
    }
}
