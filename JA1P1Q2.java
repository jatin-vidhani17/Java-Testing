import java.util.Scanner;

class rectangle{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        float len,wid;
        System.out.print("Enter The Length Of Rectangle : ");
        len = scan.nextFloat();
        System.out.print("Enter The Width Of Rectangle : ");
        wid = scan.nextFloat();
        float area = len*wid,perimeter = 2*(len+wid);
        System.out.println("The Area Of Rectangle = "+area);
        System.out.println("The Perimeter Of Rectangle = "+perimeter);
        scan.close();
    }
}

/*

Output :

Enter The Length Of Rectangle : 5.5
Enter The Width Of Rectangle : 6.5
The Area Of Rectangle = 35.75
The Perimeter Of Rectangle = 24.0

*/
