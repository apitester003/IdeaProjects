package Tutorial;

public class Tut_Enums {
    public static void main(String[] args) {
        System.out.println(ObjectOrientedProgramingLanguages.JAVA);

        //Print all the values of the enum
        for(ObjectOrientedProgramingLanguages lang : ObjectOrientedProgramingLanguages.values()){
            System.out.println(lang);
        }
    }
}
