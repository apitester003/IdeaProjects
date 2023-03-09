package InterviewPreparation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FindDuplicateCharactersInAString {
	public static void main(String[] args) throws IOException {
		System.out.println("Enter a String: ");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int count = 0;
        char[] chars = str.toCharArray();
        System.out.println("Duplicate characters are:");
        for (int i=0; i<str.length();i++) {
	        for(int j=i+1; j<str.length();j++) {
               if (chars[i] == chars[j]) {
                          System.out.println(chars[j]);
                          count++;
                          break;
                }
	         }
         }
	}
}
