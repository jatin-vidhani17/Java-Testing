/*
 8) Write an application that counts the total number of characters in all of its command-line
arguments.
*/

class commandLine {
    public static void main(String[] args) {
        int totalCharacters = 0;
        for (String arg : args) {
            totalCharacters += arg.length();
        }
        System.out.println("Total number of characters in all command-line arguments: " + totalCharacters);
    }
}
/*
 
Output : 

C:\Assignment 1\BasicProgram> java commandLine Hello There!, This is Testing String in Command.
Total number of characters in all command-line arguments: 40
 
*/