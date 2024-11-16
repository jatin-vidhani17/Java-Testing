/*
 3. Develop the Figure application in given steps.
a. Design an interface IFig having the following methods:
i. public void calcAreaQ;
ii. public void calcVolumeO;
iii. It must also have the variable pi of the type double and having a value 3.1428.
b. Design an abstract class called Figure.
i. It must have three attributes r. a and v of data type double.
ii. It has abstract methods:
1. public abstract void dispAreaQ;
2. public abstract void dispVolumeO;
c. Design three classes Cone, Sphere and Cylinder. Each of them, should
extend the Figure class and implement the IFig interface.
d. Write a test program to demonstrate polymorphism
 */
interface IFig {
    double pi = 3.1428;
    public void calcAreaQ();
    public void calcVolumeO();
}

abstract class Figure implements IFig {
    protected double r;
    protected double a;
    protected double v;

    public abstract void dispAreaQ();

    public abstract void dispVolumeO();
}

class Cone extends Figure {
    private double h;
    private double s;

    public Cone(double r, double h, double s) {
        this.r = r;
        this.h = h;
        this.s = s;
    }

    @Override
    public void calcAreaQ() {
        this.a = (pi * r * s) + (pi * r * r);
    }

    @Override
    public void calcVolumeO() {
        this.v = (pi * r * r * h) / 3; // Formula for volume of a cone
    }

    @Override
    public void dispAreaQ() {
        System.out.println("Area of Cone: " + a);
    }

    @Override
    public void dispVolumeO() {
        System.out.println("Volume of Cone: " + v);
    }
}

class Sphere extends Figure {

    public Sphere(double r) {
        this.r = r;
    }

    @Override
    public void calcAreaQ() {
        this.a = 4 * pi * r * r;
    }

    @Override
    public void calcVolumeO() {
        this.v = (4 * pi * r * r * r) / 3;
    }

    @Override
    public void dispAreaQ() {
        System.out.println("Area of Sphere: " + a);
    }

    @Override
    public void dispVolumeO() {
        System.out.println("Volume of Sphere: " + v);
    }
}

class Cylinder extends Figure {
    private double h;

    public Cylinder(double r, double h) {
        this.r = r;
        this.h = h;
    }

    @Override
    public void calcAreaQ() {
        this.a = (2 * pi * r * r) + (2 * pi * r * h);
    }

    @Override
    public void calcVolumeO() {
        this.v = pi * r * r * h;
    }

    @Override
    public void dispAreaQ() {
        System.out.println("Area of Cylinder: " + a);
    }

    @Override
    public void dispVolumeO() {
        System.out.println("Volume of Cylinder: " + v);
    }
}

class TestFigure {

    public static void main(String[] args) {
        Figure cone = new Cone(5, 10, 12);
        Figure sphere = new Sphere(7);
        Figure cylinder = new Cylinder(4, 8);

        cone.calcAreaQ();
        cone.calcVolumeO();
        cone.dispAreaQ();
        cone.dispVolumeO();

        System.out.println();

        sphere.calcAreaQ();
        sphere.calcVolumeO();
        sphere.dispAreaQ();
        sphere.dispVolumeO();

        System.out.println();

        cylinder.calcAreaQ();
        cylinder.calcVolumeO();
        cylinder.dispAreaQ();
        cylinder.dispVolumeO();
    }
}
