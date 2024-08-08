import java.util.Scanner;

class TwoPointerArray {
    private double[] array;
    private int size; // Number of elements currently in the array

    // Constructor to initialize the array with a fixed size
    public TwoPointerArray(int capacity) {
        array = new double[capacity];
        size = 0;
    }

    // Method to flush (clear) the array
    public void flushArray() {
        size = 0; // Simply reset the size to 0 to indicate the array is empty
    }

    // Method to add a number at a specified location
    public void addNumber(double number, int index) {
        if (index < 0 || index >= array.length) {
            System.out.println("Index out of bounds.");
        } else if (size >= array.length) {
            System.out.println("Array is full. Cannot add new elements.");
        } else if (index > size) {
            System.out.println("Index is beyond the current size of the array.");
        } else {
            // Shift elements to the right if inserting in the middle
            for (int i = size; i > index; i--) {
                array[i] = array[i - 1];
            }
            array[index] = number;
            size++;
        }
    }

    // Method to display the array
    public void displayArray() {
        if (size == 0) {
            System.out.println("The array is empty.");
        } else {
            System.out.print("Array contents: ");
            for (int i = 0; i < size; i++) {
                System.out.print(array[i] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the initial size of the array: ");
        int capacity = scanner.nextInt();
        TwoPointerArray tpa = new TwoPointerArray(capacity);

        boolean running = true;

        while (running) {
            System.out.println("\nSelect an option:");
            System.out.println("1. Display array");
            System.out.println("2. Flush array");
            System.out.println("3. Add number");
            System.out.println("4. Exit");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    tpa.displayArray();
                    break;

                case 2:
                    tpa.flushArray();
                    System.out.println("Array has been flushed.");
                    break;

                case 3:
                    System.out.print("Enter number to add: ");
                    double number = scanner.nextDouble();
                    System.out.print("Enter index to add the number: ");
                    int index = scanner.nextInt();
                    tpa.addNumber(number, index);
                    break;

                case 4:
                    System.out.println("Exiting...");
                    running = false;
                    break;

                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 4.");
                    break;
            }
        }

        scanner.close();
    }
}
/*

Output :

Enter the initial size of the array: 5

Select an option:
1. Display array
2. Flush array
3. Add number
4. Exit
3
Enter number to add: 10
Enter index to add the number: 0

Select an option:
1. Display array
2. Flush array
3. Add number
4. Exit
3
Enter number to add: 12
Enter index to add the number: 1

Select an option:
1. Display array
2. Flush array
3. Add number
4. Exit
3
Enter number to add: 20
Enter index to add the number: 2

Select an option:
1. Display array
2. Flush array
3. Add number
4. Exit
3
Enter number to add: 30
Enter index to add the number: 4
Index is beyond the current size of the array.

Select an option:
1. Display array
2. Flush array
3. Add number
4. Exit
1
Array contents: 10.0 12.0 20.0 

Select an option:
1. Display array
2. Flush array
3. Add number
4. Exit
3
Enter number to add: 30
Enter index to add the number: 3

Select an option:
1. Display array
2. Flush array
3. Add number
4. Exit
1
Array contents: 10.0 12.0 20.0 30.0 

Select an option:
1. Display array
2. Flush array
3. Add number
4. Exit
3
Enter number to add: 40
Enter index to add the number: 4

Select an option:
1. Display array
2. Flush array
3. Add number
4. Exit
1
Array contents: 10.0 12.0 20.0 30.0 40.0 

Select an option:
1. Display array
2. Flush array
3. Add number
4. Exit
3
Enter number to add: 60
Enter index to add the number: 8
Index out of bounds.

Select an option:
1. Display array
2. Flush array
3. Add number
4. Exit
3
Enter number to add: -40
Enter index to add the number: 3
Array is full. Cannot add new elements.

Select an option:
1. Display array
2. Flush array
3. Add number
4. Exit
2
Array has been flushed.

Select an option:
1. Display array
2. Flush array
3. Add number
4. Exit
1
The array is empty.

Select an option:
1. Display array
2. Flush array
3. Add number
4. Exit
2
Array has been flushed.

Select an option:
1. Display array
2. Flush array
3. Add number
4. Exit
3
Enter number to add: 12
Enter index to add the number: 0

Select an option:
1. Display array
2. Flush array
3. Add number
4. Exit
1
Array contents: 12.0 

Select an option:
1. Display array
2. Flush array
3. Add number
4. Exit
3
Enter number to add: 12
Enter index to add the number: 1

Select an option:
1. Display array
2. Flush array
3. Add number
4. Exit
3
Enter number to add: 14
Enter index to add the number: 0

Select an option:
1. Display array
2. Flush array
3. Add number
4. Exit
1
Array contents: 14.0 12.0 12.0 

Select an option:
1. Display array
2. Flush array
3. Add number
4. Exit
3
Enter number to add: 60
Enter index to add the number: 5
Index out of bounds.

Select an option:
1. Display array
2. Flush array
3. Add number
4. Exit
1
Array contents: 14.0 12.0 12.0 

Select an option:
1. Display array
2. Flush array
3. Add number
4. Exit
3
Enter number to add: 50
Enter index to add the number: 4
Index is beyond the current size of the array.

Select an option:
1. Display array
2. Flush array
3. Add number
4. Exit
1
Array contents: 14.0 12.0 12.0 

Select an option:
1. Display array
2. Flush array
3. Add number
4. Exit
3
Enter number to add: 30
Enter index to add the number: 3

Select an option:
1. Display array
2. Flush array
3. Add number
4. Exit
3
Enter number to add: 40
Enter index to add the number: 4

Select an option:
1. Display array
2. Flush array
3. Add number
4. Exit
1
Array contents: 14.0 12.0 12.0 30.0 40.0 

Select an option:
1. Display array
2. Flush array
3. Add number
4. Exit
4
Exiting...

*/