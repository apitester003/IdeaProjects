package InterviewPreparation;

import java.util.ArrayList;
import java.util.List;

public class IterateArrayList {
    public static void main(String[] args) {
        List<String> nameList = new ArrayList<>();
        nameList.add("Samarendra");
        nameList.add("Pratap");
        nameList.add("Sahoo");

        //Iterate using For Loop
        for(int count = 0; count < nameList.size(); count++){
            System.out.println(nameList.get(count));
        }
        System.out.println();

        //Iterate using While loop
        int ctr = 0;
        while(ctr < nameList.size()){
            System.out.println(nameList.get(ctr));
            ctr++;
        }
        System.out.println();
        for (String val :
                nameList) {
            System.out.println(val);
        }
    }

}
