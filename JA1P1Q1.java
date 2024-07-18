import java.util.Scanner;
class Var{
    public static void main(String[] args){
        int num,new_num;
        double num2;
        char char_var;
        boolean bool;
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter The Number as Integer : ");
        num = scan.nextInt();
        System.out.print("Enter The Number as Floating Value : ");
        num2 = scan.nextDouble();
        System.out.print("Enter The Character : ");
        char_var = scan.next().charAt(0);
        System.out.print("Enter The Bool(True/False) : ");
        bool = scan.nextBoolean();
        
        System.out.print("\nEnter A Scaler Value : ");
        new_num = scan.nextInt();
        
        System.out.println("Integer's Arithmetic Operations : ");
        System.out.println("Addition : " + (num + new_num));
        System.out.println("Subtraction : " + (num - new_num));
        System.out.println("Multiplication : " + (num * new_num));
        System.out.println("Division : " + (num / new_num));
        
        System.out.println("\nCharacter's Arithmetic Operations : ");
        System.out.println("Addition : " + ((int)char_var + new_num));
        System.out.println("Subtraction : " + ((int)char_var - new_num));
        System.out.println("Multiplication : " + ((int)char_var * new_num));
        System.out.println("Division : " + ((int)char_var / new_num));

        System.out.println("\nDouble's Arithmetic Operations : ");
        System.out.println("Addition : " + (num2 + new_num));
        System.out.println("Subtraction : " + (num2 - new_num));
        System.out.println("Multiplication : " + (num2 * new_num));
        System.out.println("Division : " + (num2 / new_num));

        if(bool == true){
            System.out.println("\nBoolean's Arithmetic Operations : ");
            System.out.println("Addition : " + (1 + new_num));
            System.out.println("Subtraction : " + (1 - new_num));
            System.out.println("Multiplication : " + (1 * new_num));
            System.out.println("Division : " + (1 / new_num));
        }
        else{
            System.out.println("\nBoolean's Arithmetic Operations : ");
            System.out.println("Addition : " + (0 + new_num));
            System.out.println("Subtraction : " + (0 - new_num));
            System.out.println("Multiplication : " + (0 * new_num));
            System.out.println("Division : " + (0 / new_num));
        }
        scan.close();
    }
}

/*

Output : 

Enter The Number as Integer : 1
Enter The Number as Floating Value : 1.1
Enter The Character : a
Enter The Bool(True/False) : true

Enter A Scaler Value : 5
Integer's Arithmetic Operations :
Addition : 6
Subtraction : -4
Multiplication : 5
Division : 0

Character's Arithmetic Operations :
Addition : 102
Subtraction : 92
Multiplication : 485
Division : 19

Double's Arithmetic Operations :
Addition : 6.1
Subtraction : -3.9
Multiplication : 5.5
Division : 0.22000000000000003

Boolean's Arithmetic Operations :
Addition : 6
Subtraction : -4
Multiplication : 5
Division : 0

*/
