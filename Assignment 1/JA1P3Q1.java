import java.util.Scanner;

class num{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter a Number : ");
        int num1 = scan.nextInt();
        scan.nextLine();

        if(num1 % 2 != 0){
            System.out.println("It's an Odd Number.");
        }else{
            System.out.println("It's an Even Number.");
        }

        scan.close();
    }
}

/*
 
Output : 

Enter a Number : 63 
It's an Odd Number.

 */