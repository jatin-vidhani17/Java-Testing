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

    void concat(String addString,int pos){
        if(pos == 0){
            this.str = addString + " " + this.str;
            System.out.println(this.getStrings());
        }
        else if(pos == 1){
            this.str = this.str + " " + addString;
            System.out.println(this.getStrings());
        }
    }

    void lengthSort() {
        String[] words = str.split(" ");
        for (int i = 0; i < words.length - 1; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (words[i].length() > words[j].length()) {
                    String temp = words[i];
                    words[i] = words[j];
                    words[j] = temp;
                }
            }
        }
        str = "";
        for (String word : words) {
            str += word + " ";
        }
        str = str.trim();
    }

    void alphaSort(){
        String[] words = this.str.split("\\s+");
        for (int i = 0; i < words.length-1; i++) {
            for (int j = i; j < words.length-1; j++) {
                
            }
        }
    }

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
        String str,str_temp;
        System.out.print("Enter Valid Strings : ");
        str = str1.scan.nextLine();
        str1.setString(str);
        str1.sequenceReverse();
        System.out.println("\nReversed String : " + str1.getStrings());
        str1.charReverse();
        System.out.println("\nReversed Character String : " + str1.getStrings());
        str1.lengthSort();
        System.out.println("\nSorted According to Length of the String : " + str1.getStrings());
        System.out.print("\nEnter The Postion where You want To Add String : \n(0) Front of Previous String.\n(1) Back of Previous String.\nEnter Position : ");
        int pos = str1.scan.nextInt();
        System.out.print("\nEnter the string you want to add : ");
        str1.scan.nextLine();
        str_temp = str1.scan.nextLine();
        // str1.scan.nextLine();
        str1.concat(str_temp, pos);
        System.out.print("\nConacatenated String : " + str1.getStrings());
    }
}
