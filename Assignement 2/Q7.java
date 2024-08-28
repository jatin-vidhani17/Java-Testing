// Write an application that reads and processes strings from the console. Perform the following functions based on the menu choice selected by the user..
//  Reverse the sequence of strings and then display it.
//  Reverse the sequence of characters in each string and then display it.
//  rearrange the strings according to the length of the string.
//  Sorting
//  Concatenation
//  Change them to uppercase, lowercase depending on user’s choice.
import java.util.*;

class mutableString{
    private String str;
    public Scanner scan = new Scanner(System.in);

    void setString(){
        System.out.print("Enter Valid Strings : ");
        str = scan.nextLine();
        str = str.replaceAll("\\s+"," ");
    }

    String sequenceReverse(){
        String[] words=str.split("\\s+");
        String str2 = "";
        for (int i = words.length-1; i>-1; i--) {
            str2 += words[i] + " ";
        }
        return str2;
    }
 
    public static void main(String[] args) {
        mutableString str1 = new mutableString();
        str1.setString(); 
        System.out.print("Reversed String : " + str1.sequenceReverse());

    }
}