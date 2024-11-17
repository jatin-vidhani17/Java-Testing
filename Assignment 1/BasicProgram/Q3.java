/*
 3) Write an application that generates the first 15 numbers in the Fibonacci series and first 15
    prime numbers.
 */
class FibonacciPrimeNumbers {
    public static void main(String[] args) {
        System.out.println("First 15 Fibonacci numbers:");
        generateFibonacciNumbers(15);
        
        System.out.println("\nFirst 15 prime numbers:");
        generatePrimeNumbers(15);
    }
    
    public static void generateFibonacciNumbers(int n) {
        int a = 0, b = 1;
        
        for (int i = 0; i < n; i++) {
            System.out.print(a + " ");
            int next = a + b;
            a = b;
            b = next;
        }
        System.out.println();
    }

    public static void generatePrimeNumbers(int n) {
        int count = 0;
        int num = 2;
        
        while (count < n) {
            if (isPrime(num)) {
                System.out.print(num + " ");
                count++;
            }
            num++;
        }
        System.out.println();
    }
    
    public static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}

/*

Output : 

C:\Assignment 1\BasicProgram> java FibonacciPrimeNumbers        
First 15 Fibonacci numbers:
0 1 1 2 3 5 8 13 21 34 55 89 144 233 377 

First 15 prime numbers:
2 3 5 7 11 13 17 19 23 29 31 37 41 43 47 
 
*/