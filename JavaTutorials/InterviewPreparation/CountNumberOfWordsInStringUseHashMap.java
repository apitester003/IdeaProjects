package InterviewPreparation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class CountNumberOfWordsInStringUseHashMap {
    public static void main(String[] args) throws IOException {
        System.out.println("Enter a String of multiple words: ");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String name = reader.readLine().toString();
        String[] arrayOfStrings = name.split(" ");

        HashMap<Integer, String> mapOfString = new HashMap<>();
        for(int count = 0; count < arrayOfStrings.length; count++){
            mapOfString.put(count, arrayOfStrings[count]);
        }

        System.out.println(mapOfString);
        System.out.println("The total number of words in the string are: " + mapOfString.size());
    }
}
