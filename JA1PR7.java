import java.util.Scanner;

class yearCheck{
    boolean isLeapYear(int year){
        if(year%4 == 0){
            if (year%100 == 0 && year%400 == 0){
                return true;
            }
            else if(year%100 == 0){
                return false;
            }
            else{
                return true;
            }  
        }
        else{
            return false;
        }
    }
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        yearCheck yr = new yearCheck();
        System.out.print("Enter The Year : ");
        int year = scan.nextInt();
        scan.nextLine();
        if(yr.isLeapYear(year)){
            System.out.println("It's a Leap Year");
        }
        else{
            System.out.println("It's Not a Leap Year");
        }
        scan.close();
    }
}
/*

Output : 

Enter The Year : 1700
It's Not a Leap Year

*/