import java.util.Scanner;

class multiples{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter a Number : ");
        int num = scan.nextInt();
        scan.nextLine();
        System.out.println();
        for(int i = 1; i<11;i++){
            System.out.println(num + " X " + i + " = " + num*i);
        }
        scan.close();
    }
}
/*

Output : 

Enter a Number : 45

45 X 1 = 45
45 X 2 = 90
45 X 3 = 135
45 X 4 = 180
45 X 5 = 225
45 X 6 = 270
45 X 7 = 315
45 X 8 = 360
45 X 9 = 405
45 X 10 = 450

*/