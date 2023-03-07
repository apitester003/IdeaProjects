package InterviewPreparation;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class IterateThroughHashMapUsingForEachAndWhile {
    public static void main(String[] args) {
        HashMap<Integer, String> fullNameMap = new HashMap<>();
        fullNameMap.put(0, "Samarendra");
        fullNameMap.put(1, "Pratap");
        fullNameMap.put(2, "Sahoo");

        //Using foreach
        for(Map.Entry name : fullNameMap.entrySet()){
            System.out.println("The Key: " + name.getKey() + ". The Value: " + name.getValue());
        }
        System.out.println();

        //Using While loop
        Iterator itr = fullNameMap.entrySet().iterator();
        while (itr.hasNext()){
            Map.Entry name1 = (Map.Entry) itr.next();
            System.out.println("The Key: " + name1.getKey() + ". The Value: " + name1.getValue());
        }
    }
}
