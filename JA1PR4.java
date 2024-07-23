import java.util.Scanner;

class sequence{
    
    void useForLoop(int num){
		int arr[] = new int(num);
		
    }

    void menu(){
        System.out.print("----------------------------MENU----------------------------\n
        (1) Using For Loop.\n(2) Using While Loop.\n(3) Using Recurrsion.\n(4) Exit\nEnter the Choice : ")
    }

    public static void amin(String[] args){
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
                    useForLoop(num);
                    break;
                case 2:
                    useWhileLoop(num);
                    break;
                case 3:
                    useRecurrsion(num);
                    break;
                case 4:
                    exit(0);
                    break;
                
            }
        }
        while(choice!=4);
        scan.close();
    }
}