package shapes;

public class Circle extends TwoDimensional {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public void print() {
        System.out.println("Shape: Circle, Dimension: 2D");
    }

    @Override
    public double area() {
        return Math.PI * radius * radius;
    }
}