import java.util.Scanner;
import java.util.StringTokenizer;

class strToken {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter a line of text : ");
        String input = scan.nextLine();

        StringTokenizer tokenizer = new StringTokenizer(input);
        int numTokens = tokenizer.countTokens();
        String[] tokens = new String[numTokens];
        
        for (int i = 0; i < numTokens; i++) {
            tokens[i] = tokenizer.nextToken();
        }
        
        System.out.println("\nTokens in reverse order : ");
        for (int i = numTokens - 1; i >= 0; i--) {
            System.out.println(tokens[i]);
        }
    }
}

/*

Output : 

Enter a line of text : Ok This is Testing String for Tokens.

Tokens in reverse order :
Tokens.
for
String
Testing
is
This
Ok

*/