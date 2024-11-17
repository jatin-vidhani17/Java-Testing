/*
1.Write a program to read the content of a file and count the number of words in the file.
*/
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class WordCountInFile {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== File Word Counter ===");
        System.out.print("Enter the file path: ");
        String filePath = scanner.nextLine();

        int wordCount = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            System.out.println("\nReading the file content...\n");
            while ((line = reader.readLine()) != null) {
                System.out.println(line); // Display the file content (optional, for user-friendly experience)
                String[] words = line.split("\\s+"); // Split the line into words using whitespace
                wordCount += words.length;
            }
            System.out.println("\nFile read successfully!");
            System.out.println("Total number of words in the file: " + wordCount);
        } catch (IOException e) {
            System.out.println("Error: Unable to read the file. Please ensure the file path is correct and try again.");
        }

        System.out.println("\nThank you for using the File Word Counter!");
        scanner.close();
    }
}
/*
OUTPUT:
=== File Word Counter ===
Enter the file path: example.txt

Reading the file content...

Hello World!
This is a test file.
It contains multiple lines and words.

File read successfully!
Total number of words in the file: 12

Thank you for using the File Word Counter!

*/