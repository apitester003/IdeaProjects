package Tutorial;

public class Tut_ArrayCreationDemo {
    public static void main(String[] args) {
        int[] a = new int[0];   //Valid Declaration
        int[] b = new int[2];

        System.out.println(b[0]);   //output: 0 .So once the array is declared default values of 0s are assigned

        b[0] = 4;
        System.out.println(b[0]);
        System.out.println("Length of array 'b' is: " + b.length);   //outputs the length

        System.out.println("Printing the array now");
        for(int value : b){
            System.out.println(value);
        }

        int[] c = new int[-4];  //there will be an exception
    }
}
