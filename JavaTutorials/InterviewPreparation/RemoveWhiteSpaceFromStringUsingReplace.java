package InterviewPreparation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RemoveWhiteSpaceFromStringUsingReplace {

	public static void main(String[] args) {
		System.out.println("Enter a sentence: ");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			String name = br.readLine();
			String commaSeparatedname = name.replace(' ', ',');
			System.out.println(commaSeparatedname);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
