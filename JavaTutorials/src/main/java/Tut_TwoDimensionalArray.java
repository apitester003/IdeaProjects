public class Tut_TwoDimensionalArray {
    public static void main(String[] args) {
        //Matrix Array
        int[][] a = new int[3][4];  //Declaration of a typical 2 Dimensional array

        //Jagged Array
        int[][] b = new int[2][];
        b[0] = new int[4];
        b[1] = new int[10];

        //Initialization
        a[0][1] = 1;
        a[1][3] = 3;
        for (int[] row : a) {
            for (int val : row){
                System.out.println(val);
            }
            System.out.println();
        }

        //lengths
        System.out.println("The length of array b: " + b.length);
        System.out.println("The length of array b[1]: " + b[1].length);
    }
}
