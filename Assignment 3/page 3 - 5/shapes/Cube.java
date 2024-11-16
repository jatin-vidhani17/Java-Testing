package shapes;

// Concrete class for Cube (3D)
public class Cube extends ThreeDimensional {
    private double sideLength;

    public Cube(double sideLength) {
        this.sideLength = sideLength;
    }

    @Override
    public void print() {
        System.out.println("Shape: Cube, Dimension: 3D");
    }

    @Override
    public double area() {
        return (double)(sideLength * sideLength * 6);  // Surface area of cube
    }

    @Override
    public double volume() {
        return sideLength * sideLength * sideLength;  // Volume of cube
    }
}
