package InterviewPreparation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class RemoveWhiteSpaceFromStringWithoutUsingReplace {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.out.println("Enter a sentence: ");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String name = br.readLine();
		String[] nameArray = name.split(" ");		
		for(String chars : nameArray){
			System.out.print(chars+",");
		}
	}

}
