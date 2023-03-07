package InterviewPreparation;

public class FindSecondHighestNumberInArray {
    public static void main(String[] args) {
        int[] arr = {1,4,66,5,6,6,8,9,15,56,54};
        int highest = 0, secondHighest = 0;
        for (int val :
                arr) {
            if(highest < val){
                secondHighest = highest;
                highest = val;
            }
            if(secondHighest < val && highest > val){
                secondHighest = val;
            }
        }
        System.out.println("The highest number in the array is: " + highest);
        System.out.println("The second highest number in the array is: " + secondHighest);
    }
}
