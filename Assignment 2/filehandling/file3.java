/*
3.Write a program to merge two file contents into another file.
*/
import java.io.*;
import java.util.Scanner;

public class FileMerger {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the File Merger Program!");

        System.out.print("Enter the first source file path: ");
        String sourceFilePath1 = scanner.nextLine();

        System.out.print("Enter the second source file path: ");
        String sourceFilePath2 = scanner.nextLine();

        System.out.print("Enter the destination file path: ");
        String destinationFilePath = scanner.nextLine();

        try (BufferedReader reader1 = new BufferedReader(new FileReader(sourceFilePath1));
             BufferedReader reader2 = new BufferedReader(new FileReader(sourceFilePath2));
             BufferedWriter writer = new BufferedWriter(new FileWriter(destinationFilePath))) {

            String line;

            while ((line = reader1.readLine()) != null) {
                writer.write(line);
                writer.newLine();
            }

            while ((line = reader2.readLine()) != null) {
                writer.write(line);
                writer.newLine();
            }

            System.out.println("The contents of the two files have been successfully merged into " + destinationFilePath);

        } catch (FileNotFoundException e) {
            System.out.println("Error: One of the source files was not found. Please check the file paths.");
        } catch (IOException e) {
            System.out.println("Error: An I/O error occurred while merging the files.");
        }

        System.out.println("Thank you for using the File Merger Program!");
        scanner.close();
    }
}
/* 
OUTPUT:
file1.txt:-
Hello from the first file.
This is the first file.

file2.txt:-
Hello from the second file.
This is the second file.

Mergefile:-
Welcome to the File Merger Program!
Enter the first source file path: file1.txt
Enter the second source file path: file2.txt
Enter the destination file path: mergedFile.txt

The contents of the two files have been successfully merged into mergedFile.txt
Thank you for using the File Merger Program!

Content of Mergefile.txt:-
Hello from the first file.
This is the first file.
Hello from the second file.
This is the second file.

*/
