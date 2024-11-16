/*
3. Write a program which creates an Array of character. Make one function with one
argument as a character and that function throw a user defined exception if the character
that u have passed is digit.
*/

import java.util.Scanner;
class DigitException extends Exception {
    public DigitException(String message) {
        super(message);
    }
}

public class CharacterArray {

    public static void checkCharacter(char c) throws DigitException {
        if (Character.isDigit(c)) {
            throw new DigitException("Error: The character '" + c + "' is a digit. Please provide a non-digit character.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char[] charArray = new char[5];
        
        System.out.println("Welcome to the Character Validator Program!");

        for (int i = 0; i < charArray.length; i++) {
            System.out.print("Enter character " + (i + 1) + ": ");
            charArray[i] = scanner.next().charAt(0);
        }

        System.out.println("\nChecking each character...");
        for (int i = 0; i < charArray.length; i++) {
            try {
                checkCharacter(charArray[i]);
                System.out.println("Character " + (i + 1) + ": " + charArray[i] + " is a valid character.");
            } catch (DigitException e) {
                System.out.println(e.getMessage());
            }
        }

    }
}

/*

Output : 

Welcome to the Character Validator Program!
Enter character 1: a
Enter character 2: 5
Enter character 3: z
Enter character 4: 9
Enter character 5: @

Checking each character...
Character 1: a is a valid character.
Error: The character '5' is a digit. Please provide a non-digit character.
Character 3: z is a valid character.
Error: The character '9' is a digit. Please provide a non-digit character.
Character 5: @ is a valid character.

*/