package Tutorial;

public class Tut_AnonymousArrays {
    public static void main(String[] args) {
        sum(new int[]{10,20,30});
    }

    private static void sum(int[] num){
        int total = 0;
        for(int i : num){
            total += i;
        }
        System.out.println("Sum is: " + total);
    }
}
