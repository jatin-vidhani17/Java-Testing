/*
 4. Develop a basic graphics package.
a. Within the package create a abstract class Shape having function print().
b. Create two subclasses Two Dimensional and three Dimensional from Shape class .
c. These two subclasses also should be abstract.
d. Implement the print method in the subclasses Square, Circle, Cylinder, Cube, to output
the type and dimension of the shape Also include area and volume methods to calculate
the area and volume of the concrete shapes
e. Write a driver program that creates various shapes and put them in an array of Shape
Use polymorphism to print and calculate the area and volume of objects stored in array
 */
import shapes.*;
import java.util.Scanner;

class Graphics {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Shape[] shapes = new Shape[10];
        int shapeCount = 0;

        while (true) {
            System.out.println("\nMenu :");
            System.out.println("1. Create Square");
            System.out.println("2. Create Circle");
            System.out.println("3. Create Cube");
            System.out.println("4. Create Cylinder");
            System.out.println("5. Show Shape Details");
            System.out.println("6. Exit");
            System.out.print("\nEnter your choice : ");
            
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter side length of the square: ");
                    double sideSquare = scanner.nextDouble();
                    shapes[shapeCount++] = new Square(sideSquare);
                    break;

                case 2:
                    System.out.print("Enter radius of the circle: ");
                    double radiusCircle = scanner.nextDouble();
                    shapes[shapeCount++] = new Circle(radiusCircle);
                    break;

                case 3:
                    System.out.print("Enter side length of the cube : ");
                    double sideCube = scanner.nextDouble();
                    shapes[shapeCount++] = new Cube(sideCube);
                    break;

                case 4:
                    System.out.print("Enter radius of the cylinder: ");
                    double radiusCylinder = scanner.nextDouble();
                    System.out.print("Enter height of the cylinder: ");
                    double heightCylinder = scanner.nextDouble();
                    shapes[shapeCount++] = new Cylinder(radiusCylinder, heightCylinder);
                    break;

                case 5:
                    if (shapeCount == 0) {
                        System.out.println("No shapes created yet!");
                        break;
                    }

                    System.out.println("Available shapes:");
                    for (int i = 0; i < shapeCount; i++) {
                        System.out.println(i + ". " + shapes[i].getClass().getSimpleName());
                    }

                    System.out.print("Enter the index of the shape to view details : ");
                    int index = scanner.nextInt();

                    if (index >= 0 && index < shapeCount) {
                        shapes[index].print();
                        double area = shapes[index].area();
                        double volume = shapes[index].volume();

                        if (area > 0) {
                            System.out.println("Area : " + area);
                        }

                        if (volume > 0) {
                            System.out.println("Volume : " + volume);
                        }
                    } else {
                        System.out.println("Invalid index! Please try again.");
                    }
                    break;


                case 6:
                    System.out.println("Exiting...");
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}

/*

Output : 

Menu :
1. Create Square
2. Create Circle
3. Create Cube
4. Create Cylinder
5. Show Shape Details
6. Exit

Enter your choice : 1
Enter side length of the square: 5

Menu :
1. Create Square
2. Create Circle
3. Create Cube
4. Create Cylinder
5. Show Shape Details
6. Exit

Enter your choice : 2
Enter radius of the circle: 3

Menu :
1. Create Square
2. Create Circle
3. Create Cube
4. Create Cylinder
5. Show Shape Details
6. Exit

Enter your choice : 3
Enter side length of the cube : 4

Menu :
1. Create Square
2. Create Circle
3. Create Cube
4. Create Cylinder
5. Show Shape Details
6. Exit

Enter your choice : 4
Enter radius of the cylinder: 2
Enter height of the cylinder: 5

Menu :
1. Create Square
2. Create Circle
3. Create Cube
4. Create Cylinder
5. Show Shape Details
6. Exit

Enter your choice : 5

Available shapes:
0. Square
1. Circle
2. Cube
3. Cylinder
Enter the index of the shape to view details : 0
Shape: Square, Dimension: 2D
Area : 25.0

Menu :
1. Create Square
2. Create Circle
3. Create Cube
4. Create Cylinder
5. Show Shape Details
6. Exit

Enter your choice : 5

Available shapes:
0. Square
1. Circle
2. Cube
3. Cylinder
Enter the index of the shape to view details : 1
Shape: Circle, Dimension: 2D
Area : 28.274333882308138

Menu :
1. Create Square
2. Create Circle
3. Create Cube
4. Create Cylinder
5. Show Shape Details
6. Exit

Enter your choice : 5

Available shapes:
0. Square
1. Circle
2. Cube
3. Cylinder
Enter the index of the shape to view details : 2
Shape: Cube, Dimension: 3D
Area : 96.0
Volume : 64.0

Menu :
1. Create Square
2. Create Circle
3. Create Cube
4. Create Cylinder
5. Show Shape Details
6. Exit

Enter your choice : 5

Available shapes:
0. Square
1. Circle
2. Cube
3. Cylinder
Enter the index of the shape to view details : 3
Shape: Cylinder, Dimension: 3D
Area : 87.96459430051421
Volume : 62.83185307179586

Menu :
1. Create Square
2. Create Circle
3. Create Cube
4. Create Cylinder
5. Show Shape Details
6. Exit

Enter your choice : 6
Exiting...

*/