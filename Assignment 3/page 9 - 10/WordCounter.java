
/*

3.(III) Write a program which will read text and count all occurrence of a particular word and also
reverse that word.

*/

import java.util.Scanner;
import java.util.StringTokenizer;

public class WordCounter {
    public static void main(String[] args) {
        System.out.print("Enter Text : ");
        Scanner input = new Scanner(System.in);
        String txt = input.nextLine();
        
        System.out.print("Enter word to count the occurrence from the text : ");
        String word = input.next();

        WordCounter wc = new WordCounter();

        System.out.println(wc.countWordOccurrenceFromTheText(txt.trim(), word.trim()));

        

    }

    public int countWordOccurrenceFromTheText(String txt, String word){
        StringTokenizer textParser = new StringTokenizer(txt, " ");
        int wordOccurrence = 0;
        while (textParser.hasMoreTokens()) {
            String wordToCompare = textParser.nextToken();
            if (wordToCompare.equals(word)){
                wordOccurrence ++ ;
            }
        }

        return wordOccurrence;

    }
}
