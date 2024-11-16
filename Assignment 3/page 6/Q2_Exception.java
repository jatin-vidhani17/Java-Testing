/*
2. A method named average() has one argument that is an array of strings. It converts these
to double values and returns their average. The method generates a NullPointerException
if a array elements is null or NumberFormatException if an element is incorrectly
formatted. Write a program that illustrates how to declare and use this method. Include
throws clause in the method declaration to indicate that these problems can occur
*/

import java.util.Scanner;
class AverageCalculator {

    public static double average(String[] numbers) throws NullPointerException, NumberFormatException {
        if (numbers == null) {
            throw new NullPointerException("Input array is null.");
        }

        double sum = 0;
        int count = 0;

        for (String number : numbers) {
            if (number == null) {
                throw new NullPointerException("An array element is null.");
            }
            try {
                sum += Double.parseDouble(number);
                count++;
            } catch (NumberFormatException e) {
                throw new NumberFormatException("Invalid number format: " + number);
            }
        }

        if (count == 0) {
            throw new ArithmeticException("Cannot calculate average: No valid numbers.");
        }

        return sum / count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Asking user for input directly
        System.out.println("Enter the numbers separated by spaces (e.g., 10.5 20.3 30.7): ");
        String input = scanner.nextLine();
        String[] numbers = input.split(" ");

        try {
            double avg = average(numbers);
            System.out.println("The average is: " + avg);
        } catch (NullPointerException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
        }

        scanner.close();
    }
}

/*

Output 1 : 

Enter the numbers separated by spaces (e.g., 10.5 20.3 30.7): 10.5 20.3 30.7
The average is: 20.5

Ouput 2 : 

Enter the numbers separated by spaces (e.g., 10.5 20.3 30.7): 15.5 null 22.3
Error: An array element is null.

 */