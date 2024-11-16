package shapes;

// Concrete class for Square (2D)
public class Square extends TwoDimensional {
    private double sideLength;

    public Square(double sideLength) {
        this.sideLength = sideLength;
    }

    @Override
    public void print() {
        System.out.println("Shape: Square, Dimension: 2D");
    }

    @Override
    public double area() {
        return sideLength * sideLength;
    }
}