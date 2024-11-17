/*
2.Write a program to copy contents from one file to another file.

*/
import java.io.*;
import java.util.Scanner;

public class FileCopy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the File Copy Program!");

        System.out.print("Enter the source file path: ");
        String sourceFilePath = scanner.nextLine();

        System.out.print("Enter the destination file path: ");
        String destinationFilePath = scanner.nextLine();

        try (BufferedReader reader = new BufferedReader(new FileReader(sourceFilePath));
             BufferedWriter writer = new BufferedWriter(new FileWriter(destinationFilePath))) {

            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line);
                writer.newLine();
            }

            System.out.println("File has been copied successfully!");
        } catch (FileNotFoundException e) {
            System.out.println("Error: The source file was not found. Please check the file path.");
        } catch (IOException e) {
            System.out.println("Error: An I/O error occurred while copying the file.");
        }

        System.out.println("Thank you for using the File Copy Program!");
        scanner.close();
    }
}
/*
Output:
Enter the source file path: source.txt
Enter the destination file path: destination.txt

Welcome to the File Copy Program!
File has been copied successfully!
Thank you for using the File Copy Program!
*/