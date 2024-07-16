import java.util.Scanner;

class degree{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        float cel,fah,temperature;
        System.out.print("\n(1) Celcius To Fahrenheit.\n(2) Fahrenheit To Celcius.\nEnter Choice : ");
        int choice = scan.nextInt();
        switch(choice){
            case 1:
                System.out.print("Enter Temperature in Celcius : ");
                cel = scan.nextFloat();
                temperature = (9/5 * cel) + 32;
                System.out.println("The Temperature in Fahrenheit is "+(float)temperature);
                break;
            case 2:
                System.out.print("Enter Temperature in Fahrenheit : ");
                fah = scan.nextFloat();
                temperature = 5/9 * (fah - 32);
                System.out.println("The Temperature in Celcius is "+(float)temperature);
                break;
            default:
                System.out.println("Inavalid Choice!!");
        }

    }
}

/*

Output : 

(1) Celcius To Fahrenheit.
(2) Fahrenheit To Celcius.
Enter Choice : 1
Enter Temperature in Celcius : 66
The Temperature in Fahrenheit is 98.0

*/