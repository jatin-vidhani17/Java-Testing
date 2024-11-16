class CartesianPoint{
    private int x,y;

    public CartesianPoint(int x, int y){
        this.x = x;
        this.y = y;
    }

    public CartesianPoint(int val){
        this.x = val;
        this.y = val;
    }

    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;
    }

    public void move(int x, int y){
        this.x += x;
        this.y += y;
    }

    public void move(int val){
        this.x = val;
        this.y = val;
    }

    public void display(){
        System.out.println("The Value Of X is : " + this.getX());
        System.out.println("The Value Of Y is : " + this.getY());
    }
}

class TestCartesionPoint{
    public static void main(String[] args) {
        CartesianPoint p1 = new CartesianPoint(4, 5);
        p1.display();
        p1.move(3, 5);
        p1.display();
        p1.move(9);
        p1.display();

        CartesianPoint p2 = new CartesianPoint(7);
        p2.display();
        p2.move(11, 13);
        p2.display();
    }
}

class Triangle{
    private CartesianPoint p1;
    private CartesianPoint p2;
    private CartesianPoint p3;
    
    public Triangle(CartesianPoint p1, CartesianPoint p2,CartesianPoint p3){
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
    }

    public float calculateArea(){
        float area = 0.5f * Math.abs(
            p1.getX() * (p2.getY() - p3.getY()) +
            p2.getX() * (p3.getY() - p1.getY()) +
            p3.getX() * (p1.getY() - p2.getY())
        );
        return area;
    }
    
    public float distance(CartesianPoint p1, CartesianPoint p2){
        return (float)(Math.sqrt( Math.pow(p2.getX()- p1.getX(),2) + Math.pow(p2.getY()- p1.getY(),2)));
    }

    public float calculatePerimeter(){
        return distance(p1, p2) + distance(p2, p3) + distance(p1, p3); 
    }

    public void display(){
        System.out.println("(" + p1.getX() + ", " + p1.getY() + ") : (" + p2.getX() + ", " + p2.getY() + ") : (" + p3.getX() + ", " + p3.getY() + ")" );
    }

    public void move(int x,int y){
        this.p1.move(x, y);
    }

    public void move(CartesianPoint p4){
        this.p1.move(p4.getX(), p4.getY());
    }

    public void rotate(CartesianPoint center, double angle) {
        double angleRad = Math.toRadians(angle);
        rotatePoint(p1, center, angleRad);
        rotatePoint(p2, center, angleRad);
        rotatePoint(p3, center, angleRad);
    }

    private void rotatePoint(CartesianPoint p, CartesianPoint center, double angle) {
        int cx = center.getX();
        int cy = center.getY();
        int x = p.getX();
        int y = p.getY();
        int newX = (int)(cx + (x - cx) * Math.cos(angle) - (y - cy) * Math.sin(angle));
        int newY = (int)(cy + (x - cx) * Math.sin(angle) + (y - cy) * Math.cos(angle));
        p.move(newX, newY);
    }
}

class TestTriangle {
    public static void main(String[] args) {
        CartesianPoint p1 = new CartesianPoint(0, 0);
        CartesianPoint p2 = new CartesianPoint(4, 0);
        CartesianPoint p3 = new CartesianPoint(2, 3);
        
        Triangle triangle = new Triangle(p1, p2, p3);
        System.out.print("Triangle Points Before Move : ");
        triangle.display();
        System.out.println("Area : " + triangle.calculateArea() + " Sq Units.");
        System.out.println("Perimeter : " + triangle.calculatePerimeter() + " Per Units.");

        triangle.move(1, 1);
        System.out.print("Triangle Points After Move : ");
        triangle.display();

        triangle.rotate(new CartesianPoint(2, 3), 90);
        System.out.print("Triangle Points Before Rotate : ");
        triangle.display();
    }
}

class Rectangle {
    private CartesianPoint p1;
    private CartesianPoint p2;
    private CartesianPoint p3;
    private CartesianPoint p4;

    public Rectangle(CartesianPoint p1, CartesianPoint p2, CartesianPoint p3, CartesianPoint p4) {
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
        this.p4 = p4;
    }

    public double area() {
        double width = Math.abs(p1.getX() - p2.getX());
        double height = Math.abs(p1.getY() - p4.getY());
        return width * height;
    }

    public double perimeter() {
        double width = Math.abs(p1.getX() - p2.getX());
        double height = Math.abs(p1.getY() - p4.getY());
        return 2 * (width + height);
    }

    public void display() {
        System.out.println("(" + p1.getX() + ", " + p1.getY() + "):" +
                           "(" + p2.getX() + ", " + p2.getY() + "):" +
                           "(" + p3.getX() + ", " + p3.getY() + "):" +
                           "(" + p4.getX() + ", " + p4.getY() + ")");
    }

    public void move(int dx, int dy) {
        p1.move(p1.getX() + dx, p1.getY() + dy);
        p2.move(p2.getX() + dx, p2.getY() + dy);
        p3.move(p3.getX() + dx, p3.getY() + dy);
        p4.move(p4.getX() + dx, p4.getY() + dy);
    }
}

class TestRectangle {
    public static void main(String[] args) {
        CartesianPoint p1 = new CartesianPoint(0, 0);
        CartesianPoint p2 = new CartesianPoint(4, 0);
        CartesianPoint p3 = new CartesianPoint(4, 3);
        CartesianPoint p4 = new CartesianPoint(0, 3);
        
        Rectangle rectangle = new Rectangle(p1, p2, p3, p4);
        System.out.print("Rectangle Points Before Move : ");
        rectangle.display();
        System.out.println("Area : " + rectangle.area() + " Sq Units.");
        System.out.println("Perimeter : " + rectangle.perimeter() + "Per Units.");

        rectangle.move(1, 1);
        System.out.print("Rectangle Points After Move : ");
        rectangle.display();
    }
}

/*

Output : 

PS C:\javatp> javac JA3Q2.java
PS C:\javatp> java CartesianPoint
The Value Of X is : 4
The Value Of Y is : 5
The Value Of X is : 7
The Value Of Y is : 10
The Value Of X is : 9
The Value Of X is : 7
The Value Of Y is : 7
The Value Of X is : 18
The Value Of Y is : 20
PS C:\javatp> java TestTriangle      
Triangle Points Before Move : (0, 0) : (4, 0) : (2, 3)
Area : 6.0 Sq Units.
Perimeter : 11.2111025 Per Units.
Triangle Points After Move : (1, 1) : (4, 0) : (2, 3)
Triangle Points Before Rotate : (5, 2) : (9, 5) : (4, 6)
PS C:\javatp> java TestRectangle
Rectangle Points Before Move : (0, 0):(4, 0):(4, 3):(0, 3)
Area : 12.0 Sq Units.
Perimeter : 14.0Per Units.
Rectangle Points After Move : (1, 1):(9, 1):(9, 7):(1, 7)
PS C:\javatp>

*/