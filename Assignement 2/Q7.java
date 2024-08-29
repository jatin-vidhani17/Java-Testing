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

    void setString(String str1){
        str = str1;
        str = str.replaceAll("\\s+"," ").trim();
    }

    String getStrings(){
        return str;
    }

    void sequenceReverse(){
        String[] words = str.split("\\s+");
        String str2 = "";
        for (int i = words.length-1; i>-1; i--) {
            str2 += words[i] + " ";
        }
        this.str = str2;
    }

    void 

    void charReverse() {
        String[] words = str.split("\\s+");
        StringBuilder result = new StringBuilder();
        
        for (int i = 0;i<words.length;i++) {
            String word = words[i];
            StringBuilder wordBuilder = new StringBuilder(word);
            String reversedWord = wordBuilder.reverse().toString();
            result.append(reversedWord).append(" ");
        }

        this.str = result.toString().trim();
    }
 
    public static void main(String[] args) {
        mutableString str1 = new mutableString();
        String str;
        System.out.print("Enter Valid Strings : ");
        str = str1.scan.nextLine();
        str1.setString(str);
        str1.sequenceReverse();
        System.out.println("Reversed String : " + str1.getStrings());
        str1.charReverse();
        System.out.println("Reversed Character String : " + str1.getStrings());
    }
}
