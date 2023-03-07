package InterviewPreparation;

public class FibonacciSeries {
    public static void main(String[] args) {
        int x = 1;
        int y = 1;

        System.out.println();
        System.out.printf("%d,%d",x, y);
        int limit = 12;
        int counter = 2;

        while(counter <= limit){
            y = y + x;
            System.out.printf(",%d",y);
            x = y - x;
            counter = counter + 1;
        }
    }
}
