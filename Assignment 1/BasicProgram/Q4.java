/*
4) Write and run a Java program to calculate factorial and the cube of the given integer number.
Also find the sum and multiplication of its digits. Also check whether the no entered is
palindrome or not.
 */
class FactCubePallindrom{
    public static void main(String[] args) {
        int number = Integer.parseInt(args[0]);
        System.out.println("Factorial: " + factorial(number));
        System.out.println("Cube: " + cube(number));
        System.out.println("Sum of digits: " + sumOfDigits(number));
        System.out.println("Multiplication of digits: " + multiplicationOfDigits(number));
        System.out.println("Is palindrome: " + isPalindrome(number));
    }

    public static long factorial(int n) {
        long fact = 1;
        for (int i = 1; i <= n; i++) {
            fact *= i;
        }
        return fact;
    }

    public static int cube(int n) {
        return n * n * n;
    }

    public static int sumOfDigits(int n) {
        int sum = 0;
        while (n != 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }

    public static int multiplicationOfDigits(int n) {
        int product = 1;
        while (n != 0) {
            product *= n % 10;
            n /= 10;
        }
        return product;
    }

    public static boolean isPalindrome(int n) {
        int original = n;
        int reversed = 0;
        while (n != 0) {
            reversed = reversed * 10 + n % 10;
            n /= 10;
        }
        return original == reversed;
    }
}
/*

Output : 

C:\Assignment 1\BasicProgram> java FactCubePallindrom 08 
Factorial: 40320
Cube: 512
Sum of digits: 8
Multiplication of digits: 8
Is palindrome: true
*/