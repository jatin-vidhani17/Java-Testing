package shapes;

// Concrete class for Cylinder (3D)
public class Cylinder extends ThreeDimensional {
    private double radius;
    private double height;

    public Cylinder(double radius, double height) {
        this.radius = radius;
        this.height = height;
    }

    @Override
    public void print() {
        System.out.println("Shape: Cylinder, Dimension: 3D");
    }

    @Override
    public double area() {
        return (double)(Math.PI * radius * (radius + height) * 2);  // Surface area of cylinder
    }

    @Override
    public double volume() {
        return Math.PI * radius * radius * height;  // Volume of cylinder
    }
}