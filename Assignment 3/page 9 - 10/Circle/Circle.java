/*
2.(I) Write an application that defines a Circle class with two constructors.

The first form accepts a double value that represents the radius of the circle. This constructor assumes that the circle is centered at the origin.

The second form accepts three double values. The first two arguments define the coordinates of the center, and the third argument defines the radius.

Create 10 objects of the Circle type and save them in an array. Randomly select a radius between 1 and 10 cm for each Circle created. After all circles have been created, display each circle and the total area of all the circles.
 
 
 
*/


package Circle;

public class Circle {

    private double radius;
    private double centerX;
    private double centerY;
    public Circle(double radius){
        this.radius = radius;
        this.centerX = 0;
        this.centerY = 0;
    }

    public Circle(double radius, double centerX, double centerY){
        this.radius = radius;
        this.centerX = centerX;
        this.centerY = centerY;
    }

    static public int getGeneratedRandomCentiMeter(){
        return (int)Math.ceil(   (double)Math.random() * 1  +  (double) Math.random()*10);
    }

    

    static public double getGeneratedRandomCenterX(){
        return Math.random()*10;
    }

    static public double getGeneratedRandomCenterY(){
        return Math.random()*10;
    }

    public double getArea(){
        return Math.PI * this.radius * this.radius;
    }

    public void displayCircle(){
        System.out.printf("Circle with radius: %.2f, Center: (%.2f, %.2f), Area: %.2f%n", this.radius, this.centerX, this.centerY, this.getArea());
    }
    
    public static void main(String[] args){
        Circle C[] = new Circle[10];
        for (int i=0; i<10; i++){
            if (i%2 == 0){
                double radius = getGeneratedRandomCentiMeter();
                C[i] = new Circle(radius);
            }else{
                double radius = getGeneratedRandomCentiMeter();
                double centerX = getGeneratedRandomCenterX();
                double centerY = getGeneratedRandomCenterY();
                C[i] = new Circle(radius, centerX, centerY);
            }

        }

        for (Circle CObj : C){
            CObj.displayCircle();
        }
        
    }

}
