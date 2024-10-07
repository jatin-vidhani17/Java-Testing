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
        CartesianPoint point1 = new CartesianPoint(4, 5);
        point1.display();
        point1.move(3, 5);
        point1.display();
        point1.move(9);
        point1.display();

        CartesianPoint point2 = new CartesianPoint(7);
        point2.display();
        point2.move(11, 13);
        point2.display();
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
}