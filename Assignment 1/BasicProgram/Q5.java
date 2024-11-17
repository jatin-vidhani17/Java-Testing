/*
 5) write a Java program to calculate the minimum of three integer numbers:
 */

class min{
    public static void main(String[] args) {
        if (args.length < 3) {
            System.out.println("Please provide three integer numbers as command line arguments.");
            return;
        }

        int num1 = Integer.parseInt(args[0]);
        int num2 = Integer.parseInt(args[1]);
        int num3 = Integer.parseInt(args[2]);

        int min = findMin(num1, num2, num3);

        System.out.println("The minimum of the three numbers is: " + min);
    }

    public static int findMin(int a, int b, int c) {
        int min = a;
        if (b < min) {
            min = b;
        }
        if (c < min) {
            min = c;
        }
        return min;
    }
}
/*

Output : 

C:\Assignment 1\BasicProgram> java min 08 -9 35
The minimum of the three numbers is: -9

*/