package Tutorial;

public class Tut_StringBuilder {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();                   //Creates an empty String Builder of 16 character capacity
        System.out.println(sb.capacity());      //16

        StringBuilder sb1 = new StringBuilder("Hello Sam!!");     //Initializes a new String Builder with a new String value
        System.out.println(sb1.capacity());     //27

        StringBuilder sb2 = new StringBuilder(1000);      //Assigning default capacity of the String Builder
        System.out.println(sb2.capacity());     //1000

        //1- Append method
        sb.append("Sam");
        System.out.println(sb.capacity());      //Default capacity of 16 is retained

        sb.append(" is the shortform of the name Samarendra");
        System.out.println(sb.capacity());      //The new capacity here is 43, Thus the capacity dynamically increases by the nearest lowest multiples of 16 plus extra numbers

        //2- Length method
        System.out.println(sb.length());        //Prints the length of the String

        //3 - CharAt method
        System.out.println(sb);
        System.out.println(sb.charAt(14));      //Print the character present in the given index

        //4 - Delete method
        System.out.println(sb.delete(4, 31));   //Deletes the characters in the given range 4<= characters < 31
        System.out.println(sb);

        //5 - DeleteCharAt
        System.out.println(sb.deleteCharAt(4)); //Deletes the character at the given index

        //6 - Equals method
        StringBuilder sb3 = new StringBuilder("Hello Sam");
        StringBuilder sb4 = new StringBuilder("Hello Sam");
        System.out.println(sb3.equals(sb4));    //false as both the String Builders refer to different objects

        StringBuilder sb5 = sb3.append(" Sahoo");
        System.out.println(sb3.equals(sb5));    //true as both the String Builders refer to same objects, even though the values are different

        //7 - IndexOf method
        System.out.println(sb.indexOf("Samarendra"));   //5 , it's the starting index of the mentioned string in the String Builder object, it gives the first occurrence of the mentioned String.

        //8 - LastIndexOf method
        System.out.println(sb.lastIndexOf("Samarendra")); //5 , it's the starting index of the mentioned string in the String Builder object, it gives the last occurrence of the mentioned String.

        //9 - Insert method
        System.out.println(sb.insert(4, "Pratap")); //Inserts the mentioned string at the given index

        //10 - Replace method
        System.out.println(sb.replace(11, 21, "Sahoo")); //Replaces the characters in the given range 11<= characters < 21 with the mentioned string

        //11 - Reverse method
        System.out.println(sb.reverse());       //Reverses the String Builder contents
        sb.reverse();

        //12 - Subsequence method
        System.out.println(sb.subSequence(3, 6));   //Outputs the characters in the given range 3<= characters < 6 in the given string

        //13 - Substring method
        System.out.println(sb.substring(3, 6)); //Outputs the characters in the given range 3<= characters < 6 in the given string

        //14 - ToString method
        System.out.println(sb.toString());      //Converts the given StringBuilder into a string

        //15 - SetCharAt method
        sb.setCharAt(9 , 'P');        //Updates the character in the given string at the mentioned index
        System.out.println(sb);

        //16 - TrimToSize
        System.out.println(sb.capacity());
        sb.trimToSize();
        System.out.println(sb.capacity());      //Updates the capacity of the StringBuilder to the length of the string. This reduces occupied memory. Here the capacity reduced from 43 to 16
    }
}
