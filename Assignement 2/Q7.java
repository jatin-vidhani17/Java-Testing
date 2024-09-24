// Write an application that reads and processes strings from the console.
// Perform the following functions based on the menu choice selected by the user..
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
        String[] words = str.split("\\s+");
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

    void alphaSort() {
        String[] words = this.str.split("\\s+");
        for (int i = 0; i < words.length - 1; i++) {
            for (int j = 0; j < words.length - 1 - i; j++) {
                // Compare adjacent words and swap if they are in the wrong order
                if (words[j].compareTo(words[j + 1]) > 0) {
                    String temp = words[j];
                    words[j] = words[j + 1];
                    words[j + 1] = temp;
                }
            }
        }
        str = String.join(" ", words);
    }

    void caseChange(){
        System.out.print("\n\nChoose case change option: (1) Uppercase, (2) Lowercase : ");
        int choice = scan.nextInt();
        scan.nextLine(); // Consume the newline character

        if (choice == 1) {
            str = str.toUpperCase();
        } else if (choice == 2) {
            str = str.toLowerCase();
        } else {
            System.out.println("Invalid choice. No changes made.");
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
        String str;

        System.out.print("Enter Valid Strings : ");
        str = str1.scan.nextLine();
        str1.setString(str);

        int choice;
        do {
            System.out.println("\nMenu:");
            System.out.println("1. Reverse the sequence of strings");
            System.out.println("2. Reverse the characters in each string");
            System.out.println("3. Sort according to length of strings");
            System.out.println("4. Sort alphabetically");
            System.out.println("5. Concatenate a string");
            System.out.println("6. Change case (upper/lower)");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            choice = str1.scan.nextInt();
            str1.scan.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    str1.sequenceReverse();
                    System.out.println("Reversed String: " + str1.getStrings());
                    break;
                case 2:
                    str1.charReverse();
                    System.out.println("Reversed Character String: " + str1.getStrings());
                    break;
                case 3:
                    str1.lengthSort();
                    System.out.println("Sorted According to Length of the String: " + str1.getStrings());
                    break;
                case 4:
                    str1.alphaSort();
                    System.out.println("Alphabetically Sorted String: " + str1.getStrings());
                    break;
                case 5:
                    System.out.print("Enter the position where you want to add the string (0 for front, 1 for back): ");
                    int pos = str1.scan.nextInt();
                    System.out.print("Enter the string you want to add: ");
                    str1.scan.nextLine(); // Consume the newline character
                    String str_temp = str1.scan.nextLine();
                    str1.concat(str_temp, pos);
                    System.out.println("Concatenated String: " + str1.getStrings());
                    break;
                case 6:
                    str1.caseChange();
                    System.out.println("String after case change: " + str1.getStrings());
                    break;
                case 7:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 7);
    }
}

/*

Output : 

Enter Valid Strings : Hello There!

Menu:
1. Reverse the sequence of strings
2. Reverse the characters in each string
3. Sort according to length of strings
4. Sort alphabetically
5. Concatenate a string
6. Change case (upper/lower)
7. Exit
Enter your choice: 1
Reversed String: There! Hello 

Menu:
1. Reverse the sequence of strings
2. Reverse the characters in each string
3. Sort according to length of strings
4. Sort alphabetically
5. Concatenate a string
6. Change case (upper/lower)
7. Exit
Enter your choice: 1
Reversed String: Hello There! 

Menu:
1. Reverse the sequence of strings
2. Reverse the characters in each string
3. Sort according to length of strings
4. Sort alphabetically
5. Concatenate a string
6. Change case (upper/lower)
7. Exit
Enter your choice: 2
Reversed Character String: olleH !erehT

Menu:
1. Reverse the sequence of strings
2. Reverse the characters in each string
3. Sort according to length of strings
4. Sort alphabetically
5. Concatenate a string
6. Change case (upper/lower)
7. Exit
Enter your choice: 2
Reversed Character String: Hello There!

Menu:
1. Reverse the sequence of strings
2. Reverse the characters in each string
3. Sort according to length of strings
4. Sort alphabetically
5. Concatenate a string
6. Change case (upper/lower)
7. Exit
Enter your choice: 3
Sorted According to Length of the String: Hello There!

Menu:
1. Reverse the sequence of strings
2. Reverse the characters in each string
3. Sort according to length of strings
4. Sort alphabetically
5. Concatenate a string
6. Change case (upper/lower)
7. Exit
Enter your choice: 4
Alphabetically Sorted String: Hello There!

Menu:
1. Reverse the sequence of strings
2. Reverse the characters in each string
3. Sort according to length of strings
4. Sort alphabetically
5. Concatenate a string
6. Change case (upper/lower)
7. Exit
Enter your choice: 5
Enter the position where you want to add the string (0 for front, 1 for back): 1 
Enter the string you want to add: General Kenobi!
Hello There! General Kenobi!
Concatenated String: Hello There! General Kenobi!

Menu:
1. Reverse the sequence of strings
2. Reverse the characters in each string
3. Sort according to length of strings
4. Sort alphabetically
5. Concatenate a string
6. Change case (upper/lower)
7. Exit
Enter your choice: 6


Choose case change option: (1) Uppercase, (2) Lowercase : 1
String after case change: HELLO THERE! GENERAL KENOBI!

Menu:
1. Reverse the sequence of strings
2. Reverse the characters in each string
3. Sort according to length of strings
4. Sort alphabetically
5. Concatenate a string
6. Change case (upper/lower)
7. Exit
Enter your choice: 6


Choose case change option: (1) Uppercase, (2) Lowercase : 2
String after case change: hello there! general kenobi!

Menu:
1. Reverse the sequence of strings
2. Reverse the characters in each string
3. Sort according to length of strings
4. Sort alphabetically
5. Concatenate a string
6. Change case (upper/lower)
7. Exit
Enter your choice: 7
Exiting...

*/
