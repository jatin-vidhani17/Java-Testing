package shapes;

public abstract class Shape {
    // Abstract method to print shape details
    public abstract void print();

    // Default area and volume methods returning 0 (default implementation)
    public double area() {
        return 0; // Default implementation for shapes that do not have area
    }

    public double volume() {
        return 0; // Default implementation for shapes that do not have volume
    }
}
