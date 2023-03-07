package Tutorial;

public class Tut_ThreeDimensionalArray {
    public static void main(String[] args) {
        //Jagged Three Dimensional Array
        /*int[][][] a = new int[2][][];
        a[0] = new int[1][];
        a[1] = new int[2][];*/
        int[][][] a = {{{10, 20}, {30, 40, 50, 60}, {70, 80, 90}}};
        System.out.println(a.length);
        System.out.println(a[0][0][0]);
        System.out.println(a[0][0][1]);
        System.out.println(a[0][1][0]);
        System.out.println(a[0][1][1]);

        System.out.println(a[0].length);

        for(int i = 0; i < a.length; i++){
            for(int j = 0; j < a[i].length; j++){
                for(int k = 0; k < a[i][j].length; k++){
                    System.out.println(a[i][j][k]);
                }
            }
        }
    }

}
