import java.util.Scanner;

class factorial {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter a Number : ");
        int num = scan.nextInt();
        scan.nextLine();
        int temp = num,fact = 1;
        while(temp != 1){
            fact = fact * temp;
            temp--;
        }
        System.out.print("The Factorial of "+ num +" is : " + fact + ".");
        scan.close();
    }    
}

/*

Output :

Enter a Number : 5
The Factorial of 5 is : 120.

*/