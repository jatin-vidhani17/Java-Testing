import java.util.Scanner;
class Circle{
    private double pi = 3.14;
    private float radius;

    double area(){
        return pi*radius*radius;
    }

    double circumference(){
        return 2*pi*radius;
    }

    void setRadius(){
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter Radus in Meters : ");
        radius = scan.nextFloat();
        scan.nextLine();
        scan.close();
    }

    public static void main(String[] args) {
        Circle c1 = new Circle();
        c1.setRadius();
        System.out.println("The Area Of Circle : " + c1.area());
        System.out.println("The Circumference Of Circle : " + c1.circumference());
    }
}