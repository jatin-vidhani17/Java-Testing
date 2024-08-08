import java.util.Scanner;

class week {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter a Number between 1 to 7 : ");
        int num = scan.nextInt();
        scan.nextLine();
        switch (num) {
            case 1:
                System.out.println("It's Monday.");        
                break;
            case 2:
                System.out.println("It's Tuesday.");
                break;
            
            case 3:
                System.out.println("It's Wednesday.");
                break;
            
            case 4:
                System.out.println("It's Thursday.");
                break;    
            
            case 5:
                System.out.println("It's Friday.");
                break;
            
            case 6:
                System.out.println("It's Saturday.");
                break;
        
            case 7:
                System.out.println("It's Sunday.");
                break;
            
            default:
                System.out.println("Invalid Entry!!.");
                break;
        }
        
        scan.close();
    }
}

/*

Output :

Enter a Number between 1 to 7 : 6 
It's Saturday.

*/