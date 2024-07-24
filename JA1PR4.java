import java.util.Scanner;

class sequence{
    static void useWhileLoop(int num){
	    if(num <= 0){
            System.out.println("Invalid Number!!");
            return ;
        }
        int num1 = 0, num2 = 1,i = 0;
        while(i != num){
            System.out.print(num1 + " ");
            int add = num1 + num2;
            num1 = num2;
            num2 = add;
            i++;
        }
        System.out.println();
    }

    static void useForLoop(int num){
        if(num <= 0){
            System.out.println("Invalid Number!!");
            return ;
        }
        int num1 = 0, num2 = 1;
        for(int i = 0; i<num;i++){
            System.out.print(num1 + " ");
            int add = num1 + num2;
            num1 = num2;
            num2 = add;
        }
        System.out.println();
    }

    static void useRecurrsion(int num,int num2,int num3){
        if(num > 0){
            System.out.print(a + " ");
            useRecurrsion(num-1,b,a+b);
        }
    }

    static void menu(){
        System.out.print("---------------MENU----------------\n(1) Using For Loop.\n(2) Using While Loop.\n(3) Using Recurrsion.\n(4) Exit\nEnter the Choice : ");
    }

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int choice = 0;
        do{
            System.out.print("Enter the Number Till You Want Numbers of Fibonaaci Sequence : ");
            int num = scan.nextInt();
            scan.nextLine();
            menu();
            choice = scan.nextInt();
            scan.nextLine();
            switch(choice){
                case 1:
                    System.out.print("The Fibonacci Sequence using For Loop : ");
                    useForLoop(num);
                    break;
                case 2:
                    System.out.print("The Fibonacci Sequence using While Loop : ");
                    useWhileLoop(num);
                    break;
                case 3:
                    System.out.print("The Fibonacci Sequence using Recurrsion : ");
                    useRecurrsion(num,0,1);
                    break;
                case 4:
                    System.exit(0);
                    break;
                default:
                    System.err.println("Invalid Choice!!");
            }
        }
        while(choice!=4);
        scan.close();
    }
}
